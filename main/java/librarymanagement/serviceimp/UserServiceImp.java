package librarymanagement.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import librarymanagement.model.User;
import librarymanagement.repository.UserRepository;
import librarymanagement.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public String signUp(String name, String email, String password) {
		
		if(userRepo.findByEmail(email).isPresent()) {
			throw new RuntimeException("Email already registered...");
		}
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassord(passwordEncoder.encode(password));
		userRepo.save(user);
		
		return "Registration sucessfull...!";
		
	}

	@Override
	public boolean login(String email, String password) {
		User user = userRepo.findByEmail(email).orElseThrow(
				()-> new RuntimeException("user not found!"));
	
		return passwordEncoder.matches(password, user.getPassord());
	}

}
