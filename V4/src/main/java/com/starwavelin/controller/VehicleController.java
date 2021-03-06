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

import com.starwavelin.dao.VehicleDAO;
import com.starwavelin.model.Vehicle;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleDAO vehicleDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
	
	@RequestMapping(value = "/VehicleList", method = RequestMethod.GET)
	public String gotoVehicleList(Model model, HttpServletRequest request) {
		logger.info("Direct to VehicleList.jsp");
		
		int cusid = Integer.parseInt(request.getParameter("cusid"));
		logger.info("cusid = " + cusid);
		
		List<Vehicle> vhcList = vehicleDAO.list(cusid);
//		logger.info("VIN of the first car in the list is " + vhcList.get(0).getVin());
		
		model.addAttribute("vhcList", vhcList);
		
		return "VehicleList";
	}
	
	@RequestMapping(value = "/addVehicle", method = RequestMethod.GET)
	public ModelAndView addVehicle(ModelAndView model) {
		
		Vehicle vehicle = new Vehicle();
		model.addObject("vehicle", vehicle);
		model.setViewName("VehicleAddForm");
		
		return model;
	}
	
	@RequestMapping(value = "/editVehicle", method = RequestMethod.GET)
	public ModelAndView editVehicle(ModelAndView model, HttpServletRequest request) {
		String vin = request.getParameter("vin");
		
		Vehicle vehicle = vehicleDAO.get(vin);
		model.addObject("vehicle", vehicle);
		model.setViewName("VehicleEditForm");
		
		return model;
	}
	
	
	
	@RequestMapping(value = "/saveInsertVehicle", method = RequestMethod.POST)
	public ModelAndView saveInsert(@ModelAttribute Vehicle vhc, 
			HttpServletRequest request) {
		
		vehicleDAO.saveInsert(vhc);
		int cusid = Integer.parseInt(request.getParameter("cusid"));
		return new ModelAndView("redirect:VehicleList?cusid=" + cusid);
	}
	
	
	@RequestMapping(value = "/saveUpdateVehicle", method = RequestMethod.POST)
	public ModelAndView saveUpdate(@ModelAttribute Vehicle vhc, 
			HttpServletRequest request) {
		
		vehicleDAO.saveUpdate(vhc);
		int cusid = Integer.parseInt(request.getParameter("cusid"));
		return new ModelAndView("redirect:VehicleList?cusid=" + cusid);
	}
	
	
	
	@RequestMapping(value = "/deleteVehicle", method = RequestMethod.GET)
	public ModelAndView deleteVehicle(HttpServletRequest request) {
		String vin = request.getParameter("vin");
		logger.info("DEBUG: /deleteVehicle vin is " + vin);
		
		int cusid = Integer.parseInt(request.getParameter("cusid"));
		logger.info("DEBUG: /deleteVehicle cusid is " + cusid);
		
		vehicleDAO.delete(vin);
		return new ModelAndView("redirect:VehicleList?cusid=" + cusid);
	}
}
