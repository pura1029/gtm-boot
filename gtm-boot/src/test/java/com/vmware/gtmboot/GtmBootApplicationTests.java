package com.vmware.gtmboot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vmware.gtmboot.controller.HomeController;

public class GtmBootApplicationTests {

	@Test
	public void testHomeResult() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "GTM Spring Boot Home!");
	}

}
