package librarymanagement.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import librarymanagement.model.Book;
import librarymanagement.repository.BookRepository;
import librarymanagement.service.BookService;

@Service
public class BookServiceImp implements BookService{

	@Autowired
	BookRepository bookRepo;
	
	@Override
	public List<Book> getBooks() {
		return bookRepo.findAll();	
	}

	@Override
	public String addBook(String title, String author, String isbn, int quantity) {
		Book newBook = new Book();
		newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setIsbn(isbn);
        newBook.setQuantity(quantity);
        
        bookRepo.save(newBook);
		
		return title + " added sucessfully...!";
	}

}
