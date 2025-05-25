package librarymanagement.serviceimp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import librarymanagement.model.Book;
import librarymanagement.model.BorrowRecord;
import librarymanagement.model.User;
import librarymanagement.repository.BookRepository;
import librarymanagement.repository.BorrowRecordRepo;
import librarymanagement.service.BorrowRecordService;

@Service
public class BorrowRecordServiceImp implements BorrowRecordService {
	
	@Autowired
	BorrowRecordRepo borrowRecordRepo;
	
	@Autowired
	BookRepository bookRepo;
	

	@Override
	public String borrowBook(long bookId, long userId) {
		
		Book book = bookRepo.findById(bookId)
	    .orElseThrow(() -> new RuntimeException("Book not found"));
		
		if(book.getQuantity()<=0) {
			throw new RuntimeException("Book Out Of Stock");
		}
		
		BorrowRecord record = new BorrowRecord();
		record.setBook(book);
		record.setUser(new User(userId));
		record.setBorrowDate(LocalDate.now());
		
		book.setQuantity(book.getQuantity()-1);
		bookRepo.save(book);
		borrowRecordRepo.save(record);

		return "Return the Book within 15days to avoid fine...!  Thank you ";
	}

	@Override
	public String returnBook(long recordId) {
		
		BorrowRecord record = borrowRecordRepo.findById(recordId)
		.orElseThrow(()-> new RuntimeException("Record not found!"));
		
		
		long days = ChronoUnit.DAYS.between(
				record.getBorrowDate().plusDays(14),LocalDate.now());
		
		boolean flag = false;
	    BigDecimal fine = BigDecimal.valueOf(days*10);
		
		if(days>0) {
			record.setFine(fine);
			flag =true;
		}
		Book book = record.getBook();
		book.setQuantity(book.getQuantity()+1);
		bookRepo.save(book);
		borrowRecordRepo.save(record);
		
		return flag?"Your fine amount : "+fine : "ThankYou! come again...";
	}
	
}
