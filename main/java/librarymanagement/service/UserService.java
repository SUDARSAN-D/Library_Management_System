package librarymanagement.service;

public interface UserService {
	
	public String signUp(String name,String email,String password);
	public boolean login(String email,String password);
}
