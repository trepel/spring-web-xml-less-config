package springtest.common;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebXmlLessInitializer implements WebApplicationInitializer, ServletContainerInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(Config.class);

        servletContext.addListener(new ContextLoaderListener(ctx));

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.addMapping("/*");
        servlet.setLoadOnStartup(1);

    }

    @Override
    public void onStartup(Set<Class<?>> arg0, ServletContext arg1) throws ServletException {
        onStartup(arg1);
    }

}
