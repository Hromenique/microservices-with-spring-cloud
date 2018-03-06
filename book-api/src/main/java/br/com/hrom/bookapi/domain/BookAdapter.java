package br.com.hrom.bookapi.domain;

import org.springframework.beans.BeanUtils;

public class BookAdapter {

	public static Book toBook(BookRequest from){
		Book book = new Book();
		BeanUtils.copyProperties(from, book);

		return book;
	}
}
