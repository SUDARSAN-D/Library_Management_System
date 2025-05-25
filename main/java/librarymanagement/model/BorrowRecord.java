package librarymanagement.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long recordId;
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private User user;
	
	private LocalDate borrowDate;
	private LocalDate returnDate;
	private BigDecimal fine;
}
