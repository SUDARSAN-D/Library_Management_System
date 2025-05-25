package librarymanagement.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(unique=true,nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String passord;
	
	private LocalDate date = LocalDate.now();	
	private boolean isActive = true;
	
	public User(long userId) {
		this.userId = userId;
	}
}
