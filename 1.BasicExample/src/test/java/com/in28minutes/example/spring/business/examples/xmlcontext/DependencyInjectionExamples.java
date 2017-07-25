package com.in28minutes.example.spring.business.examples.xmlcontext;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.in28minutes.example.spring.business.examples.HiService;


@Configuration
@ComponentScan(basePackages="com.in28minutes.example.spring.business.examples")
class JavaTestContext{
	
}


//Who is creating Spring?
//How does spring know where to search for Components or Beans?
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/TestContext.xml" })
@ContextConfiguration(classes = JavaTestContext.class)
// Spring IOC Container => service
// beans
// 1. Spring -> create a GoodMorningService => @Component
// 2. Spring -> Needs to DependencyInjectionExamples the created
// GoodMorningService
// Caused by:
// org.springframework.context.annotation.ConflictingBeanDefinitionException:
// Annotation-specified bean name 'javaTestContext' for bean class
// [com.in28minutes.example.spring.business.examples.javacontext.JavaTestContext]
// conflicts with existing, non-compatible bean definition of same name and
// class
// [com.in28minutes.example.spring.business.examples.injectionexamples.JavaTestContext]
public class DependencyInjectionExamples {

	@Autowired//he said that this is usually the preferred method of DI
	HiService service;

	@Test
	public void dummyTest() {
		System.out.println(service.sayHi());
		assertEquals("Good Morning", service.sayHi() );
	}
	
	@Test
	public void myTest() {
		assertEquals("Howdy ho!", service.sayHo() );
		System.out.println( service.sayHo() );
	}

	@Autowired //setter injection
	public void setService(HiService service) {
		this.service = service;
	}
	
	
	
}












