package br.com.hrom.bookapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Document
public class Book implements Serializable{
	@Id
	private String id;
	@NotNull
	private String title;
	@NotNull
	private String author;
}
