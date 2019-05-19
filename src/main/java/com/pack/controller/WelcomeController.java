package com.pack.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="/firstRequest")
	public ModelAndView sayWelcome(){
		ModelAndView mav=new ModelAndView("welcome","message","welcome to spring mvc training...");
		return mav;
	}

	@RequestMapping("/secondRequest/{country}/{userName}")
	public ModelAndView helloWorld(@PathVariable Map<String,String> pathVar){
		
		String name=pathVar.get("userName");
		String country=pathVar.get("country");
		ModelAndView mav=new ModelAndView("welcome","message","Hi Mr. "+name +" to "+country);
		return mav;
	}

}
