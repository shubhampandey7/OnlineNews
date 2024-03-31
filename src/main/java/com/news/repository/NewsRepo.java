package com.news.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.entities.News;

public interface NewsRepo extends JpaRepository<News,Integer> {
	
	List<News> findByCategory(String category);
	News findByTitle(String title);

}
