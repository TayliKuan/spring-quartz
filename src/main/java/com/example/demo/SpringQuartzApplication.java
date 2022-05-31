package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class SpringQuartzApplication {
	/*
	 * @SpringBootApplication 是複合註解 包括了 @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan
	 * 
	 * @SpringBootConfiguration - 繼承自 @Configuration, 標註當前類別是配置類, 並會將當前類別標記為@Bean的實例加入到spring 容器中
	 * @EnableAutoConfiguration - 啟動自動加入配置, 導入你所需要的jar包, 例如本專案有用到 spring-boot-starter-web, 而這是spring的核心, 裡面包刮了webmvc, tomcat....等等, 它會自動加入
	 * @ComponentScan 掃描當前包與底下所有@Controller, @Service, @Compoment, @Repository項目
	 */
	public static void main(String[] args) {
		//step 1
		System.out.println("尚未 將配置 加入到spring 容器中");

		SpringApplication.run(SpringQuartzApplication.class, args);
		
		//step 7
		System.out.println("已加載所有配置 到spring 容器中");
		System.out.println("=============== 以下正式開始執行 spring quratz ================");
	}

}
