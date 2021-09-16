## Monolithic Architecture
-- --
### Traditional Monolith Applications Characteristics
These applications mostly have these characteristics:
* One code base
* One build system
* Single execution program
* In enterprise app can scale very big
* Code is stored together
* Typically, will use one Database
* Code releases are done as one big version
* We cannot scale one component individually.
* We need to cluster Application

Benefits of Monolithic Apps:
* Easy development
* Easy deployment
* Easy testing

Problems with Monolithic apps:
* as app grows, complexity also grows
* can lead to spaghetti code and big ball of mud
* smallest change requires full deployment
* difficult to introduce to new tech
* becomes tightly coupled with tech stack used in project
* CI/CD difficult

> So in terms of Smaller and Simpler application that have no issue 
> on Cloud environment Monolith applications are great.
