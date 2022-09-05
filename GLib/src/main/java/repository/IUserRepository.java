package repository;

import java.util.List;

import model.User;

public interface IUserRepository {
	
	public User insert(User user);
	
	public User update(User user);
	
	public Integer deleteById(Integer id);
	
	public List<User> findAll();
	
	public User find(Integer id);
	
	public User find(String username);

}
