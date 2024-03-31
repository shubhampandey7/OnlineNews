package com.news.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.news.payloads.NewsDto;
import com.news.services.impl.NewsServiceImpl;

@Controller
@RequestMapping("/admin/post")
public class NewsController {
	
	@Autowired
	private NewsServiceImpl newsServiceImpl;
	

	@GetMapping("/")
	public String home(Model model) {
		
		
		return "AdminHome";
	}
	
	@GetMapping("/create")
	public String createNews(Model model) {
		
		model.addAttribute("news", new NewsDto());
		return "news";
	}
	
	@PostMapping("/news_added")
    public String postNews(@ModelAttribute NewsDto news,Model model) {
		this.newsServiceImpl.createNews(news);
		model.addAttribute("news", new NewsDto());
		return "news";
	}
	
	@GetMapping("/update")
	public String updateNews(Model model) {
		
		model.addAttribute("news", new NewsDto());
		return "update";
	}
	
	@PostMapping("/news_updated")
	 public String updateNews(@ModelAttribute NewsDto news,Model model) {
		NewsDto dto=this.newsServiceImpl.updateByTitle(news);
		if(dto==null)
			return "error";
		model.addAttribute("news", new NewsDto());
		return "update";
	}
	//to display page on website ist this has to be done then only data can be send to webpage with hepl of below method
	@GetMapping("/delete")
	public String deleteNews(Model model) {
		
		model.addAttribute("news", new NewsDto());
		return "delete";
	}
	
	//will takes action on delete.hml and redirects to /news_deleted
	@PostMapping("/news_deleted")
	 public String deleteNews(@ModelAttribute NewsDto news,Model model) {
		NewsDto dto=this.newsServiceImpl.deleteNews(news);
		if(dto==null)
			return"error";
		model.addAttribute("news", new NewsDto());
		return "delete";
	}
	
	
	
	
	
	

}
