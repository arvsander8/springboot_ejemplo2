package com.example.demo.book;


public interface BookRepository {
	Book getByIsbn(String isbn);
}

