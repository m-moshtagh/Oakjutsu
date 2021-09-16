package com.dogigiri.core.annotations.userdefined;

import org.slf4j.LoggerFactory;

@MetaProject(programmer = "m-moshtagh")
public class Project {
    public static void main(String[] args) {
        var data = Project.class.getAnnotation(MetaProject.class).programmer();
        LoggerFactory.getLogger(Project.class).info("{}", data);
    }
}
