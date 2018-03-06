package br.com.hrom.bookapi.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookRequest {
	@NotNull
	private String title;
	@NotNull
	private String author;
}
