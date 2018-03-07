package br.com.hrom.bookapi.service;

import br.com.hrom.bookapi.domain.Book;
import br.com.hrom.bookapi.domain.BookAdapter;
import br.com.hrom.bookapi.domain.BookRequest;
import br.com.hrom.bookapi.exception.NotFoundException;
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

	/**
	 * Delete a book
	 *
	 * @param id book id
	 * @throws NotFoundException when there is not a book with id
	 */
	public void deleteBook(String id) throws NotFoundException{
		IsThereABookWithId(id);

		repository.delete(id);
	}

	/**
	 * Update a book
	 *
	 * @param id book id
	 * @param bookRequest book data to do a book update
	 * @throws NotFoundException when there is not a book with id
	 */
	public void updateBook(String id, BookRequest bookRequest) throws NotFoundException{
		IsThereABookWithId(id);

		Book book = BookAdapter.toBook(bookRequest);
		book.setId(id);

		repository.save(book);
	}

	/**
	 * Verify if a book exists. When not exists a book, throw a exception
	 *
	 * @param id book id
	 * @throws NotFoundException when there is not a book with id
	 */
	private void IsThereABookWithId(String id) throws NotFoundException{
		repository.findById(id).orElseThrow(() -> new NotFoundException("There is not a book with a id " + id));
	}
}
