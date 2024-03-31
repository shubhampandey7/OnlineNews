package com.news.payloads;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NewsDto {
	
	private String title;
	private String category;
	private String content;

}
