package br.com.hrom.bookapi.service;

import br.com.hrom.bookapi.domain.Book;
import br.com.hrom.bookapi.domain.BookAdapter;
import br.com.hrom.bookapi.domain.BookRequest;
import br.com.hrom.bookapi.repository.BookRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

public class BookService {

	@Autowired
	private BookRepository repository;

	public Optional<Book> findBook(String id){
		return repository.findById(id);
	}

	public List<Book> listBooks(int page, int quantityForPage){
		Page<Book> pg = repository.findAll(new PageRequest(page, quantityForPage));
		return Lists.newArrayList(pg);
	}

	public Book createBook(BookRequest bookRequest){
		return repository.save(BookAdapter.toBook(bookRequest));
	}

	public void deleteBook(String id){
		repository.delete(id);
	}

	public void updateBook(String id, BookRequest bookRequest){
		Book book = BookAdapter.toBook(bookRequest);
		book.setId(id);

		repository.save(book);
	}
}
