package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bookservice.BookService;
import com.example.demo.model.Book;

@RestController
public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks()
	{
		List<Book> book = bookservice.getAllBooks();
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}

	@PostMapping("/book")
	public ResponseEntity<Integer> addBook(@RequestBody Book book)
	{
		int id = bookservice.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(id);
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> removeBook(@PathVariable int id)
	{
		 bookservice.removeBook(id);
		return ResponseEntity.ok("Id was Removed");
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable int id)
	{
	    Book books = bookservice.updateBook(book,id);
	    return ResponseEntity.status(HttpStatus.CREATED).body(books);
	}
	
}
