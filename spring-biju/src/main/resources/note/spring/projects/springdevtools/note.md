## Spring boot - developer tools
***
* Auto restart
  * Triggers restart of spring context when a class changes
  * Uses two classloaders: one for app and the other for jar dependencies
  * In eclipse it's triggered via save and in intellij by build
  * By default, templates are cached for performance but this tool disables it, so we can see changes
  * It also includes a liveReload server