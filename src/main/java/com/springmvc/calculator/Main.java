package com.springmvc.calculator;


import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class Main implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext registory) {
		System.out.println("Start... Love Calculator Web Site");
		AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
		context.register(LoveCalculatorConfig.class);
		DispatcherServlet servlet=new DispatcherServlet(context);
		ServletRegistration.Dynamic myServletDynamic=registory.addServlet("myDservlet", servlet);
		myServletDynamic.setLoadOnStartup(1);
		myServletDynamic.addMapping("/");		
		
		
	}

}
