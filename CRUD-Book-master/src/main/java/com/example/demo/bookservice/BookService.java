package com.example.demo.bookservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bookrepository.BookRepository;
import com.example.demo.model.Book;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookrepository;
	
	public List<Book>getAllBooks()
	{
		return bookrepository.findAll();
	}
	
	public int addBook(Book book)
	{
		Book deliver = bookrepository.save(book);
		return deliver.getId();
	}
	public void removeBook(int id)
	{
		bookrepository.deleteById(id);
	}
	
	public Book updateBook(Book book,int id)
	{
		Book books = bookrepository.findById(id).orElse(null);
		books.setAuthorName(book.getAuthorName());
		books.setBookName(book.getBookName());
		books.setPrice(book.getPrice());
		books.setQuantity(book.getQuantity());
		
		return bookrepository.save(books);
	}
}
