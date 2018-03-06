package br.com.hrom.bookapi.endpoint;

import br.com.hrom.bookapi.domain.Book;
import br.com.hrom.bookapi.domain.BookRequest;
import br.com.hrom.bookapi.service.BookService;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Book> findAllBooks(int page, int quantityByPage){
		return bookService.listBooks(page, quantityByPage);
	}

	@GetMapping("{/id}")
	public ResponseEntity findBook(@PathVariable String id){
		Optional<Book> book = bookService.findBook(id);

		if(book.isPresent())
			return ResponseEntity.ok(book.get());

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Void> createBook(@Valid @RequestBody BookRequest bookRequest){
		Book book = bookService.createBook(bookRequest);
		return ResponseEntity.created(URI.create("/books/" + book.getId())).build();
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable String id){
		bookService.deleteBook(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateBook(@Valid @RequestBody BookRequest bookRequest, @PathVariable String id){
		bookService.updateBook(id, bookRequest);
	}

}
