package librarymanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import librarymanagement.model.Book;

public interface BookService {
	
	public List<Book> getBooks();
	public String addBook(String title, String author, String isbn, int quantity);
	
}
