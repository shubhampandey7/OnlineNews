package com.news.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.news.entities.News;
import com.news.payloads.NewsDto;
import com.news.repository.NewsRepo;
import com.news.services.NewsServices;

@Service
public class NewsServiceImpl implements NewsServices {

	
	@Autowired
	private NewsRepo newsRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void createNews(NewsDto newsDTo) {
		
		News news=this.dtoTonews(newsDTo);
		this.newsRepo.save(news);
	}

	

	@Override
	public List<NewsDto> findAllNews() {
		
		List<News> ln=this.newsRepo.findAll();
		List<NewsDto> dtoL=ln.stream().map(n->this.newsToDto(n)).collect(Collectors.toList());
		return dtoL;
	}

	@Override
	public List<NewsDto> findByCategory(String category) {
		
		List<News> ln=this.newsRepo.findByCategory(category);
		List<NewsDto> dtoL=ln.stream().map(n->this.newsToDto(n)).collect(Collectors.toList());
		return dtoL;
	}
	
	@Override
	public NewsDto deleteNews(NewsDto newsDto) {
		News news=this.newsRepo.findByTitle(newsDto.getTitle());
		if(news==null)
			return null;
		this.newsRepo.delete(news);
		return newsDto;
		
	}
	
	public NewsDto newsToDto(News news) {
		return this.modelMapper.map(news, NewsDto.class);
	}
	
	public News dtoTonews(NewsDto news) {
		return this.modelMapper.map(news, News.class);
	}

	@Override
	public NewsDto updateByTitle(NewsDto newsDTo) {
		News news=this.newsRepo.findByTitle(newsDTo.getTitle());
		if(news==null)
			return null;
		news.setTitle(newsDTo.getTitle());
		news.setContent(newsDTo.getContent());
		News update=this.newsRepo.save(news);
		return this.modelMapper.map(update, NewsDto.class);
		
	}

	
}
