package librarymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import librarymanagement.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
