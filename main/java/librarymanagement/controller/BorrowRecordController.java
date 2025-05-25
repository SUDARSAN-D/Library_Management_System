package librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import librarymanagement.service.BorrowRecordService;

@RestController
@RequestMapping("/api")
public class BorrowRecordController {
	
	@Autowired
	BorrowRecordService borrowRecordService;
	
	
	@PostMapping("/borrow")
	public String borrowBook(@RequestParam("bookId")long bookId,
			                 @RequestParam("userId")long userId) {
		return borrowRecordService.borrowBook(bookId, userId);
	}
	
	@PatchMapping("/return")
	public String returnBook(@RequestParam("recordId") long recordId) {
		
		return borrowRecordService.returnBook(recordId);
		
	}
}
