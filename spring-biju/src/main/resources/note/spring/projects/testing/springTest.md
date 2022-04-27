# Testing Using Spring Framework

## Terminology

![test](../../pics/test1.png)
![test](../../pics/test2.png)
![test](../../pics/test3.png)
![test](../../pics/test4.png)
![test](../../pics/test5.png)
![test](../../pics/test6.png)
![test](../../pics/test7.png)
![test](../../pics/test8.png)
![test](../../pics/test9.png)
![test](../../pics/test10.png)
![test](../../pics/test11.png)
![test](../../pics/test12.png)

> Pure Junit & Mockito notes are available in core module.

### Spring specific tests

![springtest](../../pics/spt1.png)
![springtest](../../pics/spt2.png)
![springtest](../../pics/spt3.png)
![springtest](../../pics/spt4.png)
![springtest](../../pics/spt5.png)
![springtest](../../pics/spt6.png)
![springtest](../../pics/spt7.png)
![springtest](../../pics/spt8.png)
![springtest](../../pics/spt9.png)
![springtest](../../pics/spt10.png)

## Spring MVC Tests

### MockMVC

Spring has a feature for testing controllers. Old days we had to bring the whole web server up for testing it, but
now we can mock web server. Actually we are not going to mock web server, we just mock the dispatcher servlet.
We can create MOCKMVC object with MockMVCBuilders which gives us two options:

* standalone which is for TDD
* WebAppContext which is for BDD.

Now we pass the test subject to it and build. We use perform method and pass the http method we want and chain the
andExpect() method to it.

```java
MockMVC mockmvc = MockMVCBuilders.standAloneSetup(controller).build();
mockmvc.perform(get("/")).andExpect(status.isOk()).andExpect(view().name("index"));
```

We can also chain model test with andExpect() function to test the Model attributes.

### Spring Integration Tests

In order to do some integration tests we annotate the class `@RunWIth(Spring.class)` and if it's a database 
operation we can use `@DataJPATest` which brings entity manager.

## Spring Testing Context


