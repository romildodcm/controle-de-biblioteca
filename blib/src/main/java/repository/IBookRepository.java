package repository;

import java.util.List;

import models.Book;

public interface IBookRepository {
	
	public Book insert(Book book);
	
	public Book update(Book book);
	
	public Integer deleteById(Integer id);
	
	public List<Book> findAll();
	
	public Book find(Integer id);
	
	public Book find(String name);

}
