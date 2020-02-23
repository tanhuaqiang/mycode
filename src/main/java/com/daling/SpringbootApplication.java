package com.daling;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
//@ImportResource是引入spring配置文件.xml; @Import注解是引入带有@Configuration的java类。
@ImportResource(locations = "classpath:applicationContext.xml")
//制定开启缓存对应的包路径名，激活Cached注解
@EnableMethodCache(basePackages = "com.daling.cache")
//开启对应的CreateCache注解
@EnableCreateCacheAnnotation
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
