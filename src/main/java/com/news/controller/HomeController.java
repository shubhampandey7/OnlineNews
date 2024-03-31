package com.news.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.news.payloads.NewsDto;
import com.news.services.impl.NewsServiceImpl;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private NewsServiceImpl newsServiceImpl;
	@GetMapping("/")
	public String homepage(Model model) {
		List<NewsDto> ls=this.newsServiceImpl.findAllNews();
		model.addAttribute("news",ls);
		model.addAttribute("date",LocalDate.now().toString());
		model.addAttribute("Date","Date");
		
		return "post";
	}
	
	@GetMapping("/politics")
	public String politicsNews(Model model) {
		
		List<NewsDto> ls=this.newsServiceImpl.findByCategory("politics");
		model.addAttribute("news",ls);
		model.addAttribute("date",LocalDate.now().toString());
		model.addAttribute("Date","Date");
		
		return "post";
	}
	
	@GetMapping("/sport")
	public String sportNews(Model model) {
		
		List<NewsDto> ls=this.newsServiceImpl.findByCategory("sports");
		model.addAttribute("news",ls);
		model.addAttribute("date",LocalDate.now().toString());
		model.addAttribute("Date","Date");
		
		return "post";
	}
	
	@GetMapping("/international")
	public String internationalNews(Model model) {
		
		List<NewsDto> ls=this.newsServiceImpl.findByCategory("International");
		model.addAttribute("news",ls);
		model.addAttribute("date",LocalDate.now().toString());
		model.addAttribute("Date","Date");
		
		return "post";
	}
	
	@GetMapping("/entertainment")
	public String entertainmentNews(Model model) {
		
		List<NewsDto> ls=this.newsServiceImpl.findByCategory("Entertainment");
		model.addAttribute("news",ls);
		model.addAttribute("date",LocalDate.now().toString());
		model.addAttribute("Date","Date");
		
		return "post";
	}
	

}
