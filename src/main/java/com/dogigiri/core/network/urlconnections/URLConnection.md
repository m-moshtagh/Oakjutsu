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
they separate the details of processing a protocol from processing particular data types,
providing user interfaces, and doing the other work that a monolithic web browser
performs. The base java.net.URLConnection class is abstract; to implement a specific
protocol, you write a subclass. These subclasses can be loaded at runtime by applications.
> 
> For example, if the browser runs across a URL with a strange scheme, such as com‐
press, rather than throwing up its hands and issuing an error message, it can download
a protocol handler for this unknown protocol and use it to communicate with the server

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
* getContentLength(): returns how many bytes there are in content. This is used to know exactly how many bytes we want read or create buffer large enough to read the content.
> If the file is too large that exceeds int maximum value, we have `getContentLengthLong()` method.
> It is more reliable to use URLConnection in order to download binary files, because `openStream()` doesn't know when to stop reading. Example 7-3 of rusty eliot book shows how to download binary file.
* getContentEncoding(): returns encoding if available. HTTP servers mostly return null. This is different from character encoding, character encoding is determined by content-type header and specifies how characters are encoded in bytes but, this specifies how bytes are encoded in other bytes.
* getDate(): Returns long value that tells when the doc was sent.
* getExpiration(): if 0 there is no expiration date. this will specify that the content must be deleted from cache in a specific time and should be reloaded by server.
* getLastModified()
* getHeaderField(String name)
* getHeaderFieldKey(int n)
* getHeaderField(int n)
* getHeaderFieldDate(String name, long default)
* getHeaderFieldInt(String name, int default)

### Caches