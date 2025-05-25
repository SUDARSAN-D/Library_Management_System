package librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import librarymanagement.model.Book;
import librarymanagement.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookService.getBooks();
	}
	
	@PostMapping("/addbook")
	public String addBook(@RequestParam("title") String title,
			              @RequestParam("author") String author,
			              @RequestParam("isbn") String isbn,
			              @RequestParam("quantity") int quantity) {
		
		return bookService.addBook(title, author, isbn, quantity);
		
	}
	
}
