package com.starwavelin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public ModelAndView addCustomer(ModelAndView model) {
		Customer customer = new Customer();
		model.addObject("customer", customer);
		model.setViewName("CustomerForm");
		return model;
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer cus = customerDAO.get(id);
		ModelAndView model = new ModelAndView("CustomerForm");
		model.addObject("customer", cus);
	 
	    return model;
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute Customer cus) {
		customerDAO.saveOrUpdate(cus);
		return new ModelAndView("redirect:CustomerList");
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		customerDAO.delete(id);
		return new ModelAndView("redirect:CustomerList");
	}
}