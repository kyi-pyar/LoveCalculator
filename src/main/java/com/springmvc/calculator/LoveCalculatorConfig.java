package com.springmvc.calculator;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springmvc.calculator.Dao.LoveUserDao;
import com.springmvc.calculator.DaoImpl.LoverUserDaoImpl;
import com.springmvc.calculator.ServiceImpl.LoveCalculateServiceImpl;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "com.springmvc.calculator.Controller", "com.springmvc.calculator.ServiceImpl"})
public class LoveCalculatorConfig implements WebMvcConfigurer{
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewresolver=new InternalResourceViewResolver();
		viewresolver.setPrefix("/WEB-INF/view/");
		viewresolver.setSuffix(".jsp");		
		return viewresolver;
	}
	
	@Bean
	public LoveCalculateServiceImpl lovecalculate() {
		System.out.println("com.springmvc.calculator.ServiceImpl created");
		return new LoveCalculateServiceImpl();
	}
	
	@Bean
	public DataSource getDateSource() {
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/discussforum");
		datasource.setPassword("");
		datasource.setUsername("root");
		return datasource;
		
	}
	
	@Bean
	public LoveUserDao loverUserDao() {
		return new LoverUserDaoImpl(getDateSource());
	}
	
	@Bean
    public JavaMailSender getJavaMailSender() 
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(25);
          
        mailSender.setUsername("kyipyarlwinlkw@gmail.com");
        mailSender.setPassword("htayhtayshin624");
          
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
          
        return mailSender;
    }
     
    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("somebody@gmail.com");
        message.setFrom("admin@gmail.com");
        message.setText("FATAL - Application crash. Save your job !!");
        return message;
    }

}
