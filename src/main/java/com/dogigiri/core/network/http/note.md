## HTTP

***
The Hypertext Transfer Protocol (HTTP) is a standard that defines how a web client talks to a server and how data is
transferred from the server back to the client.

### The Protocol

HTTP specifies how a client and server establish a connection, how the client requests data from the server, how the
server responds to that request, and finally, how the connection is closed. HTTP connections use the TCP/IP protocol for
data trans‐ fer. For each request from client to server, there is a sequence of four steps:

1. The client opens a TCP connection to the server on port 80, by default; other ports may be specified in the URL.
2. The client sends a message to the server requesting the resource at a specified path. The request includes a header,
   and optionally (depending on the nature of the request) a blank line followed by data for the request.
3. The server sends a response to the client. The response begins with a response code, followed by a header full of
   metadata, a blank line, and the requested document or an error message.
4. The server closes the connection.

In HTTP 1.1 multiple requests & responses can be sent over one TCP/IP connection. This is sent in chunks and is much
scalable.

```http request
GET /index.html HTTP/1.1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:20.0)Gecko/20100101 Firefox/20.0
Host: en.wikipedia.org
Connection: keep-alive
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8

```

> This request doesn't contain message body so request ends with a blank line.

The first line is called the request line, and includes a method, a path to a resource, and the version of HTTP.

Accept header tells the server the types of data the client can handle (though servers often ignore this).

MIME types are classified at two levels: a type and a subtype. The type shows very generally what kind of data is
contained, The subtype identifies the specific type of data.

Top level types:

* text/* for human-readable words
* image/* for pictures
* model/* for 3D models such as VRML files
* audio/* for sound
* video/* for moving pictures, possibly including sound
* application/* for binary data
* message/* for protocol-specific envelopes such as email messages and HTTP responses
* multipart/* for containers of multiple documents and resources
* custom types begin with x-

> request ends with `\r\n\r\n`

```http response
HTTP/1.1 200 OK
Date: Sun, 21 Apr 2013 15:12:46 GMT
Server: Apache
Connection: close
Content-Type: text/html; charset=ISO-8859-1
Content-length: 115
<html>
<head>
<title>
A Sample HTML file
</title>
</head>
<body>
The rest of the document goes here
</body>
</html>
```

> Regardless of version, a response code from 100 to 199 always indicates an informational response, 200 to 299 always indicates success, 300 to 399 always indicates redirection, 400 to 499 always indicates a client error, and 500 to 599 indicates a server error.

### Keep-alive

A client indicates that it’s willing to reuse a socket by including a Connection field in the HTTP request header with
the value Keep-Alive We can change this via:

* Set `http.keepAlive`to “true or false”
* Set `http.maxConnections` to the number of sockets you’re willing to hold open at one time. The default is 5.
* Set `http.keepAlive.remainingData` to true to let Java clean up after abandoned connections (Java 6 or later). It is
  false by default.
* Set `sun.net.http.errorstream.enableBuffering` to true to attempt to buffer the relatively short error streams from
  400- and 500-level responses, so the connection can be freed up for reuse sooner. It is false by default.
* Set `sun.net.http.errorstream.bufferSize` to the number of bytes to use for buffering error streams. The default is
  4,096 bytes.
* Set `sun.net.http.errorstream.timeout` to the number of milliseconds before timing out a read from the error stream.
  It is 300 milliseconds by default.

### HTTP methods

* GET
    * The GET method retrieves a representation of a resource. GET is side effect free, and can be repeated without
      concern if it fails. Furthermore, its output is often cached, though that can be controlled with the right
      headers,
* POST
    * The POST method is the most general method. It, too, uploads a representation of a re‐ source to a server at a
      known URL, but it does not specify what the server is to do with the newly supplied resource. For instance, the
      server does not necessarily have to make that resource available at the target URL, but may instead move it to a
      different URL. Or the server might use the data to update the state of one or more completely different resources.
      POST should be used for unsafe operations that should not be repeated, such as making a purchase.
* PUT
    * The PUT method uploads a representation of a resource to the server at a known URL. It is not side effect free,
      but it is idempotent. That is, it can be repeated without concern if it fails. Putting the same document in the
      same place on the same server twice in a row leaves the server in the same state as only putting it once.
* DELETE
    * The DELETE method removes a resource from a specified URL. It, too, is not side effect free, but is idempotent. If
      you aren’t sure whether a delete request succeeded—for in‐ stance, because the socket disconnected after you sent
      the request but before you received a response—just send the request again. Deleting the same resource twice is
      not a mistake.

> Only operations that commit should use POST.

We also have other methods like HEAD which only Gets Headers. it is used to get the modification of a file. OPTIONS lets
client ask the server what methods are available to it. TRACE, which echoes back the client request for debugging
purposes, especially when proxy servers are misbehaving.
> URL class uses GET, but URLConnection class can use all these four methods.

### Request Body

In POST & PUT cases, the client supplies the representation of the resource, in addition to the path and the query
string. The representation of the resource is sent in the body of the request, after the header. Request contains:

1. A starter line including the method, path and query string, and HTTP version
2. An HTTP header
3. A blank line (two successive carriage return/linefeed pairs)
4. The body

```http request
POST /cgi-bin/register.pl HTTP 1.0
Date: Sun, 27 Apr 2013 12:32:36
Host: www.cafeaulait.org
Content-type: application/x-www-form-urlencoded
Content-length: 54

username=Elliotte+Harold&email=elharo%40ibiblio.org
```

### Cookies

Many websites use small strings of text known as cookies to store persistent client-side state between connections.
Cookies are passed from server to client and back again in the HTTP headers of requests and responses. Cookies can be
used by a server to indicate session IDs, shopping cart contents, login credentials, user preferences, and more. more
likely, the value is a meaningless string such as "`ATVPDKIKX0DER`", which identifies a particular record in a database
Cookies are limited to nonwhitespace ASCII text, and may not contain commas or semicolons.
</br>
To set a cookie in a browser, the server includes a Set-Cookie header line in the HTTP header.

```http request
GET /index.html HTTP/1.1
Host: www.example.org
Cookie: cart=ATVPDKIKX0DER
Accept: text/html
```

As long as the server doesn't reuse cookies, this enables it to track individual users and sessions across multiple,
otherwise stateless, HTTP connections.

In addition to a simple name=value pair, cookies can have several attributes that control their scope including
expiration date, path, domain, port, version, and security options.
> Set-Cookie: user=gold;Domain=.foo.example.com

> Websites work around this restriction by embedding an image or other content hosted on one domain in a page hosted at a second do‐ main. The cookies set by the embedded content, not the page itself, are called third-party cookies. Many users block all third-party cookies, and some web browsers are starting to block them by default for privacy reasons.

Cookies are also scoped by path, so they’re returned for some directories on the server, but not all. The default scope
is the original URL and any subdirectories. For instance, if a cookie is set for the
URL http://www.cafeconleche.org/XOM/, the cookie also applies in http://www.cafeconleche.org/XOM/apidocs/, but not
in http://www.cafeconleche.org/
slides/ or http://www.cafeconleche.org/. However, the default scope can be changed using a Path attribute in the cookie.
For example, this next response sends the browser a cookie with the name “user” and the value “gold” that applies only
within the server’s /restrict‐ ted subtree, not on the rest of the site:
> Set-Cookie: user=gold; Path=/restricted

A cookie can include both a domain and a path. For instance, this cookie applies in the /restricted path on any servers
within the example.com domain
> Set-Cookie: user=gold;Path=/restricted;Domain=.example.com

The order of the different cookie attributes doesn't matter, as long as they’re all separated by semicolons and the
cookie’s own name and value come first. However, this isn’t true when the client is sending the cookie back to the
server. In this case, the path must precede the domain.
> Cookie: user=gold; Path=/restricted;Domain=.foo.example.com

A cookie can be set to expire at a certain point in time by setting the expires attribute to a date in the form Wdy,
DD-Mon-YYYY HH:MM:SS GMT. In the pattern language used by java.text.SimpleDateFormat, this is E, dd-MMM-yyyy H:m:s z.
For instance, this cookie expires at 3:23 P.M. on December 21, 2015

> Set-Cookie: user=gold; expires=Wed, 21-Dec-2015 15:23:00 GMT

The Max-Age attribute that sets the cookie to expire after a certain number of seconds have passed instead of at a
specific moment. For instance, this cookie expires one hour
(3,600 seconds) after it’s first set
> Set-Cookie: user="gold"; Max-Age=3600

each cookie can have a secure attribute with no value
> Set-Cookie: key=etrogl7*;Domain=.foo.example.com; secure

Browsers are supposed to refuse to send such cookies over insecure channels. For additional security against
cookie-stealing attacks like XSRF, cookies can set the HttpOnly attribute. This tells the browser to only return the
cookie via HTTP and HTTPS and specifically not by JavaScript.
> Set-Cookie: key=etrogl7*;Domain=.foo.example.com; secure; httponly

### CookieManager

Java `CookieManager` class should get activated first:
`CookieManager manager = new CookieManager();`
<br>
`CookieHandler.setDefault(manager);`

After installing a CookieManager with those two lines of code, Java will store any cookies sent by HTTP servers you
connect to with the URL class, and will send the stored cookies back to those same servers in subsequent requests.
However, you may wish to be a bit more careful about whose cookies you accept. You can do this by specifying a
CookiePolicy. Three policies are predefined

* CookiePolicy.ACCEPT_ALL All cookies allowed
* CookiePolicy.ACCEPT_NONE No cookies allowed
* CookiePolicy.ACCEPT_ORIGINAL_SERVER Only first party cookies allowed

For example, this code fragment tells Java to block third-party cookies but accept first- party cookies

```java
CookieManager manager=new CookieManager();
manager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
CookieHandler.setDefault(manager);
```

f you want more fine-grained control, for instance to allow cookies from some known domains but not others, you can
implement the CookiePolicy interface yourself and override the shouldAccept() method
`public boolean shouldAccept(URI uri, HttpCookie cookie)`

CookiePolicy that blocks cookies from .gov domains, but allows others.

```java
public class NoGovernmentCookies implements CookiePolicy {
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        if (uri.getAuthority().toLowerCase().endsWith(".gov")
                || cookie.getDomain().toLowerCase().endsWith(".gov")) {
            return false;
        }
        return true;
    }
}
```

### CookieStore

It is sometimes necessary to put and get cookies locally. For instance, when an application quits, it can save the
cookie store to disk and load those cookies again when it next starts up. You can retrieve the store in which the
CookieManager saves its cookies with the getCookieStore()
`CookieStore store = manager.getCookieStore();`
The CookieStore class allows you to add, remove, and list cookies, so you can control the cookies that are sent outside
the normal flow of HTTP requests and responses

Each cookie in the store is encapsulated in an HttpCookie object that provides methods for inspecting the attributes of
the cookie

```java
package java.net;

public class HttpCookie implements Cloneable {
    public HttpCookie(String name, String value)

    public boolean hasExpired();

    public void setComment(String comment);

    public String getComment();

    public void setCommentURL(String url);

    public String getCommentURL();

    public void setDiscard(boolean discard);

    public boolean getDiscard();

    public void setPortlist(String ports);

    public String getPortlist();

    public void setDomain(String domain);

    public String getDomain();

    public void setMaxAge(long expiry);

    public long getMaxAge();

    public void setPath(String path);

    public String getPath();

    public void setSecure(boolean flag);

    public boolean getSecure();

    public String getName();

    public void setValue(String value);

    public String getValue();

    public int getVersion();

    public void setVersion(int v);

    public static boolean domainMatches(String domain, String host);

    public static List<HttpCookie> parse(String header);

    public String toString();

    public boolean equals(Object obj);

    public int hashCode();

    public Object clone();
}
```
>Several of these attributes are not actually used any more. In particular comment, comment
URL, discard, and version are only used by the now obsolete Cookie 2 specification
that never caught on.

