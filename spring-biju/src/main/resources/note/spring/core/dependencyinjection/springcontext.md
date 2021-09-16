## The Spring Context
This is also called Application Context or Spring IoC container
Best brief explanation with code samples:<br>
[**Baeldung spring container**](https://www.baeldung.com/spring-application-context)
***
### Application Context interfaces
The Spring IoC container is responsible for managing the objects of an application.
It uses dependency injection to achieve inversion of control.
The interfaces BeanFactory and ApplicationContext represent the Spring IoC container.
Here, BeanFactory is the root interface for accessing the Spring container.
</br>It provides more enterprise-specific functionalities.
The important features of ApplicationContext are resolving messages,
supporting internationalization, publishing events, and application-layer specific contexts.
This is why we use it as the default Spring container.

### Bean
a bean is an object that the Spring container instantiates, assembles, and manages.
In order to configure beans we can use Java-based configuration, annotation-based configuration 
and XML configuration.

### Types of Application Context
* AnnotationConfigApplicationContext
* AnnotationConfigWebApplicationContext
* XmlWebApplicationContext
* FileSystemXMLApplicationContext
* ClassPathXmlApplicationContext
* SpringApplication in spring boot applications.

### Spring bean lifecycle
![Bean-life-Cycle](../../pics/bean-life-cycle.png)
![Bean-life-Cycle](../../pics/bean-life-cycle2.png)
Spring has two interfaces we can implement for callback events
* InitializingBean.afterPropertiesSet()
  * Called after properties are set.
* DisposableBean.destroy()
  * Called during bean destruction in shutdown.

Spring also has two annotations we can use to hook into the bean lifecycle.
* @PostConstruct annotated methods will be called after bean is constructed but, before its returned to requested object
* @PreDestroy is called just before the bean is destroyed by the container.

Bean PostProcessors
* We can manage our beans inside spring context lifecycle and, interact with them as they are being processed.
* implement BeanPostProcessor interface.
  * postProcessBeforeInitialization: called before bean initialization method
  * postProcessAfterInitialization: called after bean initialization. 
  * both get the bean object as argument.

Aware interfaces
* has 14 Aware interfaces, these are used to access the spring framework infrastructure. widely used within the framework.
![Aware Interfaces](../../pics/aware-interface.png)

