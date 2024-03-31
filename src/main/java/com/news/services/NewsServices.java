package com.news.services;

import java.util.List;

import com.news.payloads.NewsDto;

public interface NewsServices {
	
	void createNews(NewsDto newsDTo);
	List<NewsDto> findAllNews();
	List<NewsDto> findByCategory(String category);
	NewsDto updateByTitle(NewsDto newsDTo);
	NewsDto  deleteNews(NewsDto newsDto);

}
