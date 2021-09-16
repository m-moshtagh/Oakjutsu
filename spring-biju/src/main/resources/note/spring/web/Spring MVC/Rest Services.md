## Spring MVC
***
### Rest Services
Spring has sets of annotation in order to use rest services. 

* First we declare a controller class and mark it with `@RestController` annotation
* > All controller classes Should be under springApplication package to be detected by spring or, we need to define a configuration.
  * This annotation is a combination of `@Controller`, `@Documented`, `@ResponseBody` and some more.
  * This annotation converts the output of our methods to JSON.
* We specify `@RequestMapping` in order to map the coming requests to this controller class
  * We pass a URL argument to it.
> It's recommended to specify API version in URL so that we can have multiple versions of it.
> Usually We just include the major number of version however we can add minor number too but,
> it's not recommended including patch number.
* We use `@GetMapping`, `@PostMapping`, `@PutMapping` and `@DeleteMapping` to implement our Http methods.
  * We can use {/foo} in order to create dynamic path. 
  * We need to also mention ``@PathVariable("foo") Foo bar`` in method signature in order to use path variable.
* In order to return a more detailed object, we can use `ResponseEntity<T>` Which allows us to return HttpStatus object too.
  * We can also use `@ResponseStatus(HttpStatus)` on method signature.
  * If we want to wrap something as a header We can use `HttpHeader` type.
* Sometimes we want to bind an object from a form in POST or PUT method. here we need to pass `@RequestBody Foo bar` as argument in order to capture the object from request.

### Model Object
In order to send Java objects We can wrap them in model object
and send it with our response. This is accessible by Thymeleaf 
In our view templates.
