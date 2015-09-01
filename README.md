spring-web-xml-less-config
==========================

Spring MVC Web Application configured without web.xml

If `spring-web.jar` is located in `lib/` directory, the application works correctly when deployed on WildFly 8/9/10.

If `spring-web.jar` is installed as a module in WildFly and the application uses `jboss-deployment-structure.xml` (services="import"), it doesn't work. It doesn't work even if `Dependencies:org.springframework.spring services` is added to the MANIFEST.MF

To have `spring-web.jar` (and other required spring jars) that contains `META-INF/services` in provided scope, use `module-spring` profile.

This is reproducer for https://issues.jboss.org/browse/WFLY-3971

In modules directory there is the spring module you can install to WildFly, use path `WILDFLY_HOME/modules/system/add-ons/spring`. It doesn't contain all the required spring jars, you can download them from maven central repository.

To create war use maven:
`mvn clean package` (spring-web.jar bundled in war)
`mvn clean package -Pmodule-spring` (spring-web.jar must be installed as a static module in WildFly8)
