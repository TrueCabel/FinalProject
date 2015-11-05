package com.catalyst.devworks.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController 
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homePage(@RequestParam Optional<String> error)
	{
		return new ModelAndView("index.html", "error", error);
	}
}
