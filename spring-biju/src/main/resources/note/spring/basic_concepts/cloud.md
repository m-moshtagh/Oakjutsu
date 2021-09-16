## Cloud
-- --
### What is The Cloud?
Clouds is a concept which abstracts the physical underlying hardware and allows us to use virtual servers & services.
Like Amazon Web Services which allows provisioning zones(a physical region made of many datacenters appearing as one)

#### Cloud Based Architectures
* microservices are a key aspect of cloud based architectures
* cloud based architectures focus on abstraction, redundancy and avoidance of single point of failures.
* Saving a file to AWS S3:
  * file copied to multiple servers and data centers before the save is confirmed
  * Thus protected from server failure and even loss of data center.
* Typically, multiple instances of microservices are deployed in cloud environment to increase reliability.

#### Common Deployment Tools
* AWS beanstalk
* AWS ECS/EKS
* Kubernetes
* Docker swarm
* Red hat openshift
* Cloud Foundry