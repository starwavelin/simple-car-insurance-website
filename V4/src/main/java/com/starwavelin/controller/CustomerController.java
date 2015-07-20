package com.starwavelin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value = "/CustomerList", method = RequestMethod.GET)
	public String gotoCustomerList(Model model) {
		logger.info("Direct to CustomerList.jsp");
		return "CustomerList";
	}
	
}	
