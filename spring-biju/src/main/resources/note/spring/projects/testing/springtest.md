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

## Spring boot support for junit

Spring provides tools to enhance the productivity of writing unit tests. Spring gives us three configurations:

* SpringBootTest: Loads the application context into tests
* MockMVC: comprehensive testing of controller units
* Mockito Integration: @MockBean for easy mockito integration

Also provides tool for testing third party backend resources:

* DBUnit: Pre populate and clean up database between tests
* MongoDB: manage MongoDB data
* WireMock: simulate third party API responses

### Spring Testing Context

We want to use SpringApplicationContext to handle our objects and Junit features. We can `autowire` objects.

#### Setup

We need to put `@SpringJunitConfiguration` annotation which provides needed annotations for us. We can pass
Configuration
classes to this annotation. These classes can be defined isolated or as inner classes.

WE can use `@ActiveProfile` and `@Profile` for using profiles for tests.

We can also use `@TestPropertySource` for external properties.

### Spring MVC Tests

#### MockMVC

Spring has a feature for testing controllers. Old days we had to bring the whole web server up for testing it, but
now we can mock web server. Actually we are not going to mock web server, we just mock the dispatcher servlet.
We can configure it in different ways:

![MockMVC](../../pics/mockmvc1.png)
![MockMVC](../../pics/mockmvc2.png)
![MockMVC](../../pics/mockmvc3.png)

* standalone which is for TDD
* WebAppContext which is for BDD.

Now we pass the test subject to it and build. We use perform method and pass the http method we want and chain the
andExpect() method to it.

```java
MockMVC mockmvc=MockMVCBuilders.standAloneSetup(controller).build();
        mockmvc.perform(get("/")).andExpect(status.isOk()).andExpect(view().name("index"));
```

We can also chain model test with andExpect() function to test the Model attributes.

### Service Layer test

![MockMVC](../../pics/servicetest1.png)
![MockMVC](../../pics/servicetest2.png)

### Repository Layer test

#### Using JDBC template

![MockMVC](../../pics/repotest1.png)
![MockMVC](../../pics/repotest2.png)
![MockMVC](../../pics/repotest3.png)
![MockMVC](../../pics/repotest4.png)
![MockMVC](../../pics/repotest5.png)
![MockMVC](../../pics/repotest6.png)
![MockMVC](../../pics/repotest7.png)
![MockMVC](../../pics/repotest8.png)

#### Using spring Data for NOSQL database

![MockMVC](../../pics/mongotest1.png)
![MockMVC](../../pics/mongotest2.png)
![MockMVC](../../pics/mongotest3.png)
![MockMVC](../../pics/mongotest4.png)
![MockMVC](../../pics/mongotest5.png)
![MockMVC](../../pics/mongotest6.png)
![MockMVC](../../pics/mongotest7.png)
![MockMVC](../../pics/mongotest8.png)
![MockMVC](../../pics/mongotest9.png)
![MockMVC](../../pics/mongotest10.png)
![MockMVC](../../pics/mongotest11.png)
![MockMVC](../../pics/mongotest12.png)
![MockMVC](../../pics/mongotest13.png)
![MockMVC](../../pics/mongotest14.png)
![MockMVC](../../pics/mongotest15.png)
![MockMVC](../../pics/mongotest16.png)
![MockMVC](../../pics/mongotest17.png)
![MockMVC](../../pics/mongotest18.png)
![MockMVC](../../pics/mongotest19.png)
![MockMVC](../../pics/mongotest20.png)
![MockMVC](../../pics/mongotest21.png)
![MockMVC](../../pics/mongotest22.png)
![MockMVC](../../pics/mongotest23.png)
![MockMVC](../../pics/mongotest24.png)
![MockMVC](../../pics/mongotest25.png)

### Testing using WireMock

![MockMVC](../../pics/wiremock1.png)
![MockMVC](../../pics/wiremock2.png)
![MockMVC](../../pics/wiremock3.png)
![MockMVC](../../pics/wiremock4.png)
![MockMVC](../../pics/wiremock5.png)
![MockMVC](../../pics/wiremock6.png)
![MockMVC](../../pics/wiremock7.png)
![MockMVC](../../pics/wiremock8.png)

#### Spring Integration Tests

![MockMVC](../../pics/integrationtest1.png)
![MockMVC](../../pics/integrationtest2.png)
![MockMVC](../../pics/integrationtest3.png)
![MockMVC](../../pics/integrationtest4.png)
![MockMVC](../../pics/integrationtest5.png)
![MockMVC](../../pics/integrationtest6.png)
![MockMVC](../../pics/integrationtest7.png)
![MockMVC](../../pics/integrationtest8.png)
![MockMVC](../../pics/integrationtest9.png)
![MockMVC](../../pics/integrationtest10.png)
![MockMVC](../../pics/integrationtest11.png)
![MockMVC](../../pics/integrationtest12.png)
![MockMVC](../../pics/integrationtest13.png)
![MockMVC](../../pics/integrationtest14.png)
![MockMVC](../../pics/integrationtest15.png)
![MockMVC](../../pics/integrationtest16.png)
![MockMVC](../../pics/integrationtest17.png)
![MockMVC](../../pics/integrationtest18.png)
![MockMVC](../../pics/integrationtest19.png)
![MockMVC](../../pics/integrationtest20.png)
![MockMVC](../../pics/integrationtest21.png)
![MockMVC](../../pics/integrationtest22.png)
![MockMVC](../../pics/integrationtest23.png)
![MockMVC](../../pics/integrationtest24.png)
![MockMVC](../../pics/integrationtest25.png)
![MockMVC](../../pics/integrationtest26.png)
![MockMVC](../../pics/integrationtest27.png)
![MockMVC](../../pics/integrationtest28.png)
![MockMVC](../../pics/integrationtest29.png)
![MockMVC](../../pics/integrationtest30.png)

In order to do some integration tests we annotate the class `@RunWIth(Spring.class)` and if it's a database
operation we can use `@DataJPATest` which brings entity manager.

