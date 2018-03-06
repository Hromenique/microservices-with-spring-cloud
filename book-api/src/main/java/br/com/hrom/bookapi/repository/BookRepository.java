package br.com.hrom.bookapi.repository;

import br.com.hrom.bookapi.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
	Optional<Book> findById(String id);
}
