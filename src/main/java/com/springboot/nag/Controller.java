package com.springboot.nag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class Controller {

	@RequestMapping("/hystrixtimeout")
	@HystrixCommand(fallbackMethod = "hystrixFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public HystrixResponse hystrixTimeout() {

		HystrixResponse customStatusResponse = new HystrixResponse();
		customStatusResponse.setStatusCode(100);
		customStatusResponse.setStatusMessgae("Hello, Spring Boot hystrix service is running . . .");

		try {
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println("Exception occured due to:" + ex);
		}
		return customStatusResponse;
	}

	@RequestMapping("/hystrix")
	@HystrixCommand(fallbackMethod = "hystrixFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })
	public HystrixResponse histrix() {

		HystrixResponse customStatusResponse = new HystrixResponse();
		customStatusResponse.setStatusCode(100);
		customStatusResponse.setStatusMessgae("Hello, Spring Boot hystrix service is running . . .");

		try {
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println("Exception occured due to:" + ex);
		}
		return customStatusResponse;
	}

	@SuppressWarnings("unused")
	private HystrixResponse hystrixFallBack() {
		HystrixResponse customStatusResponse = new HystrixResponse();
		customStatusResponse.setStatusCode(101);
		customStatusResponse.setStatusMessgae("Request Failed. it is taking long time to respond");
		return customStatusResponse;

	}

}
