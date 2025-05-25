package librarymanagement.service;

import librarymanagement.model.BorrowRecord;

public interface BorrowRecordService {
	
	
	public String borrowBook(long bookId,long userId);
	public String returnBook(long recordId);
	
	
}
