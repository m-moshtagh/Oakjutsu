## URLConnections

***

### Preface

URLConnection is an abstract class that represents an active connection to a resource
specified by a URL.
It has different purposes from URL class:

* it provides more control over the interaction with a server
* A URLConnection can inspect the header sent by the server and respond accordingly.
* a URLConnection can send data back to a web server with POST, PUT, and other HTTP request methods.
* the URLConnection class is part of Java’s protocol handler mechanism, which also includes the URLStreamHandler class
* URLConnection can configure the request parameters sent to the server.

> The idea behind protocol handlers is simple:
> they separate the details of processing a protocol from processing particular data types,
> providing user interfaces, and doing the other work that a monolithic web browser
> performs. The base java.net.URLConnection class is abstract; to implement a specific
> protocol, you write a subclass. These subclasses can be loaded at runtime by applications.
>
> For example, if the browser runs across a URL with a strange scheme, such as com‐
> press, rather than throwing up its hands and issuing an error message, it can download
> a protocol handler for this unknown protocol and use it to communicate with the server

### Opening URLConnections

* Construct a URL Object
* Invoke URL openConnection() to retrieve URLConnection object for the URL.
* Configure the URLConnection
* Read the Header fields
* Get an input stream and read data
* Get an output stream and write data
* Close connection

> If we try to create a subclass or implement a protocol handler surely we need to implement
> connect() method.

### Reading data from a server

1. Construct a URL object.
2. Invoke the URL object’s openConnection() method to retrieve a URLConnection
   object for that URL.
3. Invoke the URLConnection’s getInputStream() method.
4. Read from the input stream using the usual stream API

### Reading the Header

Http server provide metadata per request. We can query these headers using URLConnection methods.
We can access most relevant headers using:

* getContentType(): returns MIME media type, relies on web server. returns null if it's NA.
* getContentLength(): returns how many bytes there are in content. This is used to know exactly how many bytes we want
  read or create buffer large enough to read the content.

> If the file is too large that exceeds int maximum value, we have `getContentLengthLong()` method.
> It is more reliable to use URLConnection in order to download binary files, because `openStream()` doesn't know when
> to stop reading. Example 7-3 of rusty eliot book shows how to download binary file.

* getContentEncoding(): returns encoding if available. HTTP servers mostly return null. This is different from character
  encoding, character encoding is determined by content-type header and specifies how characters are encoded in bytes
  but, this specifies how bytes are encoded in other bytes.
* getDate(): Returns long value that tells when the doc was sent.
* getExpiration(): if 0 there is no expiration date. this will specify that the content must be deleted from cache in a
  specific time and should be reloaded by server.
* getLastModified()
* getHeaderField(String name)
* getHeaderFieldKey(int n)
* getHeaderField(int n)
* getHeaderFieldDate(String name, long default)
* getHeaderFieldInt(String name, int default)

### Caches

In order to save load time, Browsers can cache the resources. Cache content can be controlled via `expires` header and
`cache-control` header. cache control header options are massive.
Cache-control has several policies:

* max-age=[seconds]: Number of seconds from now before the cached entry
  should expire
* s-manage=[seconds]: Number of seconds from now before the cached entry
  should expire from a shared cache. Private caches can store the entry for longer.
* public: OK to cache an authenticated response. Otherwise, authenticated responses are not cached.
* private: Only single user caches should store the response; shared caches should
  not.
* no-cache: Not quite what it sounds like. The entry may still be cached, but the
  client should verify the state of the resource with an ETag or Last-modified
  header on each access.
* no-store: Do not cache the entry no matter what.
  Cache-control overrides Expires if both are present. A server can send multiple
  Cache-control headers in a single header as long as they don’t conflict.
* The Last-modified header is the date when the resource was last changed. A client
  can use a HEAD request to check this and only come back for a full GET if its local
  cached copy is older than the Last-modified date.
* The ETag header (HTTP 1.1) is a unique identifier for the resource that changes
  when the resource does. A client can use a HEAD request to check this and only come
  back for a full GET if its local cached copy has a different ETag.

### Web caches for Java

By default, Java does not cache anything. To install a system-wide cache of the URL class
will use, you need the following:

* A concrete subclass of ResponseCache
* A concrete subclass of CacheRequest
* A concrete subclass of CacheResponse

You install your subclass of ResponseCache that works with your subclass of CacheRe
quest and CacheResponse by passing it to the static method ResponseCache.setDe
fault(). This installs your cache object as the system default. A Java virtual machine
can only support a single shared cache.

Once a cache is installed whenever the system tries to load a new URL, it will first look
for it in the cache. If the cache returns the desired content, the URLConnection won’t
need to connect to the remote server. However, if the requested data is not in the cache,
the protocol handler will download it. After it’s done so, it will put its response into the
cache so the content is more quickly available the next time that URL is loaded.

```java
import java.io.*;
import java.net.*;

public class SimpleCacheRequest extends CacheRequest {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Override
    public OutputStream getBody() throws IOException {
        return out;
    }

    @Override
    public void abort() {
        out.reset();
    }

    public byte[] getData() {
        if (out.size() == 0) return null;
        else return out.toByteArray();
    }
}
```

```java
import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleCacheResponse extends CacheResponse {
    private final Map<String, List<String>> headers;
    private final SimpleCacheRequest request;
    private final Date expires;
    private final CacheControl control;


    public SimpleCacheResponse(
            SimpleCacheRequest request, URLConnection uc, CacheControl control)
            throws IOException {
        this.request = request;
        this.control = control;
        this.expires = new Date(uc.getExpiration());
        this.headers = Collections.unmodifiableMap(uc.getHeaderFields());
        new Date(uc.getExpiration());
    }

    @Override
    public InputStream getBody() {
        return new ByteArrayInputStream(request.getData());
    }

    @Override
    public Map<String, List<String>> getHeaders()
            throws IOException {
        return headers;
    }

    public CacheControl getControl() {
        return control;
    }

    public boolean isExpired() {
        Date now = new Date();
        if (control.getMaxAge().before(now)) return true;
        else if (expires != null && control.getMaxAge() != null) {
            return expires.before(now);
        } else {
            return false;
        }
    }
}
```

```java
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.net.*;


public class MemoryCache extends ResponseCache {
    private final Map<URI, SimpleCacheResponse> responses
            = new ConcurrentHashMap<URI, SimpleCacheResponse>();
    private final int maxEntries;

    public MemoryCache() {
        this(100);
    }

    public MemoryCache(int maxEntries) {
        this.maxEntries = maxEntries;
    }

    @Override
    public CacheRequest put(URI uri, URLConnection conn)
            throws IOException {
        if (responses.size() >= maxEntries) return null;
        CacheControl control = new CacheControl(conn.getHeaderField("Cache-Control"));
        if (control.noStore()) {
            return null;
        } else if (!conn.getHeaderField(0).startsWith("GET ")) {
// only cache GET
            return null;
        }
        SimpleCacheRequest request = new SimpleCacheRequest();
        SimpleCacheResponse response = new SimpleCacheResponse(request, conn, control);
        responses.put(uri, response);
        return request;
    }

    @Override
    public CacheResponse get(URI uri, String requestMethod,
                             Map<String, List<String>> requestHeaders)
            throws IOException {
        if ("GET".equals(requestMethod)) {
            SimpleCacheResponse response = responses.get(uri);
// check expiration date
            if (response != null && response.isExpired()) {
                responses.remove(response);
                response = null;
            }
            return response;
        } else {
            return null;
        }
    }
}
```

### Configuring the connection

This class has seven protected instance fields which define how clients connect to server:

* url
* doInput
* doOutput
* allowUserInteraction
* useCaches
* isModifiedSince
* connected

> we can control these fields using getters and setters before URLConnection is connected to server.

#### URL url

Specifies the URL this URLConnection connects to.

```java
import java.io.*;
import java.net.*;

public class URLPrinter {
    public static void main(String[] args) {
        try {
            URL u = new URL("http://www.oreilly.com/");
            URLConnection uc = u.openConnection();
            System.out.println(uc.getURL());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
```

#### connected

If true the connection is open and false if it's closed. If you inherit URLConnection to write a protocol handler, you
are responsible for
setting connected to true when you are connected and resetting it to false when the connection closes.

#### allowUserInteraction

If we need user interaction we need this to be true. In a standalone application, you first need to install an
Authenticator, as
discussed in “Accessing Password-Protected Sites” on page 161.

#### doInput

When this field is true, URLConnection is able to read from the server.

#### doOutput

This field is true when we need to write to the server. When this is true on HTTP URLs the method will change
to POST.

#### isModifiedSince

When we try to retrieve files from server and, we use cache we can set this value to check if the content has changed
since certain time.

#### useCaches

This field determines to use cache or not.

#### timeouts

We have four methods for controlling the time underlying socket uses:

* setConnectTimeout
* getConnectTimeout
* setReadTimeout
* getReadTimeout

The `setConnectTimeout()/getConnectTimeout()` methods control how long the socket waits for the initial connection.
The `setReadTimeout()/getReadTimeout()` methods control how long the input stream waits for data to arrive.

### Configuring the client request HTTP Header

We can send header values by using `setRequestProperty()` & `getRequestProperty` on HTTP URLs. this method accepts two
String values. We can pass multiple values by separating them with comma and semicolon. We can see the example in
browser
requests which have, Accept header. We can also name the property Cookie and pass the values separated by semicolons to
it.

### Writing Data to server

We can write data on URL using POST and PUT methods. The `getOutputStream()` will aid us with it.
A URLConnection doesn't allow output by default, so you have to call `setDoOutput(true)` before asking for an output
stream.

#### Example 7-14: posting a form

```java
import java.io.*;
import java.net.*;

public class FormPoster {
    private URL url;
    // from Chapter 5, Example 5-8
    private QueryString query = new QueryString();

    public FormPoster(URL url) {
        if (!url.getProtocol().toLowerCase().startsWith("http")) {
            throw new IllegalArgumentException(
                    "Posting only works for http URLs");
        }
        this.url = url;
    }

    public void add(String name, String value) {
        query.add(name, value);
    }

    public URL getURL() {
        return this.url;
    }

    public InputStream post() throws IOException {
// open the connection and prepare it to POST
        URLConnection uc = url.openConnection();
        uc.setDoOutput(true);
        try (OutputStreamWriter out
                     = new OutputStreamWriter(uc.getOutputStream(), "UTF-8")) {
// The POST line, the Content-type header,
// and the Content-length headers are sent by the URLConnection.
// We just need to send the data
            out.write(query.toString());
            out.write("\r\n");
            out.flush();
        }
// Return the response
        return uc.getInputStream();
    }

    public static void main(String[] args) {
        URL url;
        if (args.length > 0) {
            try {
                url = new URL(args[0]);
            } catch (MalformedURLException ex) {
                System.err.println("Usage: java FormPoster url");
                return;
            }
        } else {
            try {
                url = new URL(
                        "http://www.cafeaulait.org/books/jnp4/postquery.phtml");
            } catch (MalformedURLException ex) { // shouldn't happen
                System.err.println(ex);
                return;
            }
        }
        FormPoster poster = new FormPoster(url);
        poster.add("name", "Elliott Rusty Harold");
        poster.add("email", "elharo@ibiblio.org");
        try (InputStream in = poster.post()) {
// Read the response
            Reader r = new InputStreamReader(in);
            int c;
            while ((c = r.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
```

All the things to be done:

1. Decide what name-value pairs you’ll send to the server-side program.
2. Write the server-side program that will accept and process the request. If it doesn't
   use any custom data encoding, you can test this program using a regular HTML
   form and a web browser.
3. Create a query string in your Java program. The string should look like this: name1=value1&name2=value2&name3=value3
4. Open a URLConnection to the URL of the program that will accept the data.
5. Set doOutput to true by invoking setDoOutput(true).
6. Write the query string onto the URLConnection’s OutputStream.
7. Close the URLConnection’s OutputStream.
8. Read the server response from the URLConnection’s InputStream.

### Security Considerations for URLConnections

We only need to be aware that do we have permission to do the specific job we want. we can get the permission if there
is
by `getPermission()`.

### Guessing MIME Media Types

Java provides two methods to determine what is MIME type of content server is configured:

* guessContentTypeFromName(String name)
* guessContentTypeFromStream(InputStream in)

The second one looks at 16 first bytes of the file and tries to guess the MIME type.

### HttpURLConnection

An abstract derived class of URLConnection which can't be instantiated directly because of protected constructor.
however, we can open connection a URL and cast it to HttpURLConnection class.

`URL u = new URL("http://lesswrong.com/");
HttpURLConnection http = (HttpURLConnection) u.openConnection();`

#### Request method

HttpURLConnection uses GET method by default we can set others with `setRequestMethod()`. This class only supports:

* GET
* POST
* DELETE
* PUT
* OPTIONS
* TRACE
* HEAD

##### HEAD

returns HTTP header. We can check if a file has been changed since last time it was cached.

```java
import java.io.*;
import java.net.*;
import java.util.*;

public class LastModified {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                URL u = new URL(args[i]);
                HttpURLConnection http = (HttpURLConnection) u.openConnection();
                http.setRequestMethod("HEAD");
                System.out.println(u + " was last modified at "
                        + new Date(http.getLastModified()));
            } catch (MalformedURLException ex) {
                System.err.println(args[i] + " is not a URL I understand");
            } catch (IOException ex) {
                System.err.println(ex);
            }
            System.out.println();
        }
    }
}
```

##### TRACE

We use this method to see if there's any proxy servers between client and server. if the server responses with the
client
headers there's no proxy in between.

#### Closing connection

Since HTTP 1.1 supports multiple requests over one tcp connection, we can explicitly `disconnect()` the connection and
make sure next set of requests don't time out.

#### Handling server responses

We can get response message using `getResponseMessage()` and the code with `getResponseCode()`.

##### Example 7-16: source viewer3

```java
import java.io.*;
import java.net.*;

public class SourceViewer3 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
// Open the URLConnection for reading
                URL u = new URL(args[i]);
                HttpURLConnection uc = (HttpURLConnection) u.openConnection();
                int code = uc.getResponseCode();
                String response = uc.getResponseMessage();
                System.out.println("HTTP/1.x " + code + " " + response);
                for (int j = 1; ; j++) {
                    String header = uc.getHeaderField(j);
                    String key = uc.getHeaderFieldKey(j);
                    if (header == null || key == null) break;
                    System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
                }
                System.out.println();
                try (InputStream in = new BufferedInputStream(uc.getInputStream())) {
// chain the InputStream to a Reader
                    Reader r = new InputStreamReader(in);
                    int c;
                    while ((c = r.read()) != -1) {
                        System.out.print((char) c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
```

For error handling we can use `getErrorStream()` which returns null if we encounter error.

##### Example 7-17 download a page with URLConnection

```java
import java.io.*;
import java.net.*;

public class SourceViewer4 {
    public static void main(String[] args) {
        try {
            URL u = new URL(args[0]);
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();
            try (InputStream raw = uc.getInputStream()) {
                printFromStream(raw);
            } catch (IOException ex) {
                printFromStream(uc.getErrorStream());
            }
        } catch (MalformedURLException ex) {
            System.err.println(args[0] + " is not a parseable URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void printFromStream(InputStream raw) throws IOException {
        try (InputStream buffer = new BufferedInputStream(raw)) {
            Reader reader = new InputStreamReader(buffer);
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        }
    }
}
```

#### Redirects

We can choose to followed redirects if the content has been moved to a new location because this may have security risks.
we have `getFollowRedirects()` & `setFollowRedirects(boolean follow)` which let us choose.

#### Proxies

we can check if the server is using proxy by `usingProxy()`.

#### Streaming Mode

For transferring really large contents Java provides two solutions:
if you know the size of your data—for instance, you’re uploading a file of known size using
HTTP PUT—you can tell the HttpURLConnection object the size of that data. If you don’t
know the size of the data in advance, you can use chunked transfer encoding instead.
In chunked transfer encoding, the body of the request is sent in multiple pieces, each
with its own separate content length.
`setChunkedStreamingMode(int chunkLength)`
This method is so risky that we should only use it when we need it because this goes in the way of authentication so, we
need to retry again.
if we know the exact length we can use:
`setFixedLengthStreamingMode(long contentLength)`
