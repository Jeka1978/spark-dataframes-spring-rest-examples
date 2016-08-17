package ru.jug.jpoint.web;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ru.jug.jpoint.AppConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Evegeny on 21/04/2016.
 */
public class WebStarter implements WebApplicationInitializer{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebConfig.class);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
        servlet.setLoadOnStartup(1);

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);

        servletContext.addListener(new ContextLoaderListener(appContext));

        servlet.addMapping("/*");
    }
}
