package com.dalingjia.spring.cyclicDependency;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("com.dalingjia.spring.cyclicDependency")
public class Appconfig {

}
