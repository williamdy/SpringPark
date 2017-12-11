package com.will;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan
@ServletComponentScan
@SpringBootApplication
public class App 
{
	private static Class<App> applicationClass = App.class;

    public static void main( String[] args )
    {
    	SpringApplication.run(applicationClass, args);
    }
}
