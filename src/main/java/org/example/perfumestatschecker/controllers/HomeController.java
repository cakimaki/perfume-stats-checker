package org.example.perfumestatschecker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		return "Hello to home page";
	}
	
	@GetMapping("/printjson")
	public String printJson(){
		return "gonna print test json here";
	}
	
	@GetMapping("/offers")
	public ModelAndView offersView(){
		return new ModelAndView("offers");
		}
}