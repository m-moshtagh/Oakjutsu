package com.dogigiri.core.annotations.userdefined;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = {ElementType.METHOD, ElementType.TYPE})
public @interface MetaProject {
    String programmer()
            default "Dogigiri";

    String projectName()
            default "Kenjutsu";

    String date()
            default "Today";
}
