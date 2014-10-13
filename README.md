spring-web-xml-less-config
==========================

Spring MVC Web Application configured without web.xml

If spring-web.jar is located in lib/ directory, the application works correctly when deployed on WildFly 8.

If spring-web.jar is installed as a module in WildFly8 and the application uses jboss-deployment-structure.xml (services="import"), it doesn't work. It doesn't work even if `Dependencies:org.springframework.spring services` is added to the MANIFEST.MF

To have spring-web.jar that contains META-INF/services in provided scope, use module-spring profile.

This is reproducer for https://issues.jboss.org/browse/WFLY-3971

In modules directory there is the spring module you can install to WildFly8.

To create war use maven:
mvn clean package (spring-web.jar bundled in war)
mvn clean package -Pmodule-spring (spring-web.jar must be installed as a static module in WildFly8)
