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


