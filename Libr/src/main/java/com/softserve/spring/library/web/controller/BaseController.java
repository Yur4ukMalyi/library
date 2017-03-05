
package com.softserve.spring.library.web.controller;





import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 
 * Core servlet controller class.
 *
 */
@Controller
public class BaseController {

    /**
     * Handles request to welcome page
     * @return logical view name
     */
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "home";
	}
	
	

	@RequestMapping(value = { "/contactus"}, method = RequestMethod.GET)
	public String contactUsPage(ModelMap model) {
		return "contactus";
		
	}
	@RequestMapping(value = { "/contactus/cc"}, method = RequestMethod.GET)
	public String contacttUsPage(ModelMap model) {
		return "contactus";
}}