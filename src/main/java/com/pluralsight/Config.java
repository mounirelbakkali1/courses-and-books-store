package com.pluralsight;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.pluralsight") //@ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.
public class Config {
}
