package librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import librarymanagement.model.BorrowRecord;

public interface BorrowRecordRepo extends JpaRepository<BorrowRecord,Long>{

}
