# Gradle

## Purpose

Gradle is another famous build tool which can aid us in packaging, deploying, testing and resolving project
dependencies.

## Gradle vs Maven

Gradle uses Groovy or Kotlin DSL for configuration. Gradle also uses prebuilt feature which can accelerate building
process. Project structure is so similar to maven. We can also use mavenCentral or Jcenter for resolving our
dependencies.

We write gradle settings inside build.gradle file. Instead of maven lifecycles we have tasks Which are defined with
every plugin we define. Closures are used to define dependencies, plugins etc. inside configuration file.

## Features

We create a build.gradle file and add this line to it:
`apply plugin: 'java'`

Add source code declaration to build.gradle:
we create sourceSets closure:

```groovy

sourceSets {
    main {
        java.srcDirs = ['src']
    }
}
```

### Creating new Gradle task

For example, we are trying to create a task to get the current date, we write thi using groovy. We write it down in
build file:

```groovy
task showDate {
    doLast {
        print "current date" + new LocalDateTime().now()
    }
}
```

If we want to make this task dependant to build task. we just add a line above doLast block:
`dependsOn TASK_NAME`

### Generate report

```groovy
apply plugin: 'project-report' 
```

### Gradle Profile

Report on the build highlighting performance, It can be created anytime we run a task. It can be saved permanently to
record history of build performance.
Profiles are enabled by default in Gradle.
We can generate it by:
`gradle build --profile`
Rerun this command won't replace it, it will create a new report.

### Gradle Cloud Build Scan

This is a new Capability added recently, It's just a set of build reports that are saved on cloud.
To enable it we add following to beginning of build file:

```groovy
plugin {
    id 'com.gradle.build-scan' version '1.6'
}

buildScan {
    licenseAgreementUrl = 'https://gradle.com/terms-of-services'
    licenseAgree = 'yes'
}
```

Then we can check `geradle --scan` and it will give us URL for cloud. After Authentication, we can see the build report.

## Best Practices

### Gradle Wrapper

In each project structure gradle would create wrapper files which make our project portable. It's always recommended
that we build and package our project using wrappers.

### Always Specify settings.gradle

In order to have consistent settings in our project we need this file. We should always declare our root.ProjectName
Otherwise, it will use the project directory name.

### Use Standard Project Layout

It's always the best to keep up with the standards because newComers can adopt themselves much easier, There is no extra
work etc.

### Use the latest Gradle version

We can update wrapper using `./gradlew wrapper --gradle-version foo`

### Version your project

We can specify version: `version = 0.0.1-SNAPSHOT`
Instead of hardcoding the version in our build.gradle file we can use plugins which can do the dirty work for us.
maven has its own release plugin, we can use axion release plugin for gradle.

### Stop cleaning each time

Unlike maven gradle supports incremental builds so, it can detect tasks needed to be done automatically.

### Run tests in parallel

We have some tests that are isolated from each other and don't share common resources. We don't want to wait and
execute them one by one. We can use `maxParallelForks foo` inside test closure to exceed the testing phase.

### Configuration avoidance

Gradle has three different phases:

* initialization: figuring what project is involved
* configuration: runs build script
* execution: execute tasks

We can define tasks like this:

```groovy
task foo {
    sleep(3000)
    doLast {
        print "something"
    }
}
```

We can take it out of configuration phase using:

```groovy
tasks.register('foo') {
    sleep(3000)
    doLast {
        print "something"
    }
}
```

This can help us exceed building phase by removing unnecessary tasks from configuration.

### Execute the right task

We can use task info plugins to see the detailed task tree graphs so that we can explicitly use the right task we want.

### Use abbreviated names for long task names

We can abbreviate long task names and gradle can understand it.

### Use Gradle Completion third party tool

We can use this tool for command completion.

### Java toolchain

Sometimes we might have encounter problems related to java version we are using. We can solve this by:

```groovy
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(16)
    }
}
```

### Optimise repositories

We can order repositories in build file. It's always better to put mavenCentral & JCenter at first order to avoid 
unnecessary request for local or network repositories.

#### use local maven repository

we can add `mavenLocal()` or if the path is special we can:

```groovy
repositories {
    maven {
        url '/path/to/your/repository'
    }
}
```

### Move tasks to buildSrc directory

We can create our custom tasks inside buildSrc Directory to trim the build.gradle much better and externalize the task
definition. All we need to do is to create `buildSrc/src/main/groovy` and we can create tasks classes here. Then 
we just import them in build.gradle and register them:
```groovy
tasks.register('fooTask', FooClass) {
    // implementation detail
}
```

### Tasks related videos were ambiguous so, Will postpone it till we try it in production
