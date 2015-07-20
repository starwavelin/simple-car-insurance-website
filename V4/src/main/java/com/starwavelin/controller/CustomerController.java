package com.starwavelin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.starwavelin.dao.CustomerDAO;
import com.starwavelin.model.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value = "/CustomerList", method = RequestMethod.GET)
	public String gotoCustomerList(Model model) {
		logger.info("Direct to CustomerList.jsp");
		
		List<Customer> cusList = customerDAO.list();
		model.addAttribute("cusList", cusList);				
		
		return "CustomerList";
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public ModelAndView newCustomer(ModelAndView model) {
		Customer customer = new Customer();
		model.addObject("customer", customer);
		model.setViewName("CustomerForm");
		return model;
	}
	
}	
