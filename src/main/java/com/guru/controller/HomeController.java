package com.guru.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.guru.model.Bank;
import com.guru.model.Student;

@Controller
@RequestMapping(value="/")
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String showHome(Model model,Student student){
		model.addAttribute("limit","limit item");
		student.getBanks().add(new Bank());
		return "page/index";
	}

	@RequestMapping(params={"addForm"})
	public String addRow(Student student,@RequestParam("addForm") String addForm){
		student.getBanks().add(new Bank());
		return "page/index";
	}
	
	@RequestMapping(params={"removeRow"})
	public String removeRow(@RequestParam("removeRow")int rowId,Student student){
		student.getBanks().remove(rowId);
		return "page/index";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String showHome(@Valid Student student,BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){
			return "page/index";
		}
		model.addAttribute("success");
		return "success";
	}
	
	
}
