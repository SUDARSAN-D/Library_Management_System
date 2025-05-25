package librarymanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import librarymanagement.model.User;
import librarymanagement.repository.UserRepository;
import librarymanagement.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired 
	UserRepository userRepo;

	@PostMapping("/signup")
	public String signUp(@RequestParam("name") String name,
			             @RequestParam("email") String email,
			             @RequestParam("password") String password) {
		
		return userService.signUp(name, email, password);
	}
	
	@GetMapping("/isactive/{email}")
	public String isActive(@PathVariable String email) {

		return userRepo.findByEmail(email)
				.map(user -> user.isActive()?"Active":"Expired")
				.orElseThrow(()-> new RuntimeException("user not found"));
	}
	
	@GetMapping("/login")
	public boolean login(@RequestParam("email") String email,
			             @RequestParam("password") String password) {
		
		return userService.login(email, password);
	}
}
