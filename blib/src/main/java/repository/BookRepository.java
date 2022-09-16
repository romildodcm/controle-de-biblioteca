package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import models.Book;

public class BookRepository implements IBookRepository {
	private Connection conn;
	
	public BookRepository() {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public Book insert(Book book) {
		PreparedStatement statement = null;
		
		try {
			String sql = "INSERT INTO tbBook(tbBook_name,tbBook_author,tbBook_date,tbBook_status) VALUES(?,?,?,?)";
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, book.getName());
			statement.setString(2, book.getAuthor());
            statement.setDate(3, java.sql.Date.valueOf(book.getDate()));
            statement.setInt(4, book.getStatus().toInteger());
			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet ids = statement.getGeneratedKeys();
				
				while (ids.next()) {
					book.setId(ids.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public Book update(Book book) {
		PreparedStatement statement = null;
				
		try {
			String sql = "UPDATE tbBook SET tbBook_name = ?, tbBook_date = ?, tbBook_author = ?, tbBook_status = ? WHERE tbBook_id = ?";
			statement = conn.prepareStatement(sql);

            statement.setString(1, book.getName());
            statement.setDate(2, java.sql.Date.valueOf(book.getDate()));
            statement.setString(3, book.getAuthor());
            statement.setInt(4, book.getStatus().toInteger());
            statement.setInt(5, book.getId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public Integer deleteById(Integer id) {
		PreparedStatement statement = null;
		
		try {
            String sql = "DELETE FROM tbBook WHERE (tbBook_id = ?)";
			statement = conn.prepareStatement(sql);

            statement.setInt(1, id);
			
			int rowsAffected = statement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return id;
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = new ArrayList<Book>();
		
		PreparedStatement stmt = null;
		ResultSet result = null;
	
		try {
			String sql = "SELECT * FROM tbBook";
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			while(result.next()) {

                Book book = new Book();
                book.setId(result.getInt("tbBook_id"));
                book.setName(result.getString("tbBook_name"));
                book.setAuthor(result.getString("tbBook_author"));
                book.setDate(result.getDate("tbBook_date").toLocalDate());
                book.setStatus(result.getInt("tbBook_status"));

                books.add(book);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				stmt.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return books;
	}

	@Override
	public Book find(Integer id) {
		Book book = null;
		PreparedStatement statement = null;
		ResultSet result = null;
	
		try {
            String sql = "SELECT * FROM tbBook WHERE (tbBook_id = ?)";
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			
			while(result.next()) {
                book = new Book();
                book.setId(result.getInt("tbBook_id"));
                book.setName(result.getString("tbBook_name"));
                book.setAuthor(result.getString("tbBook_author"));
                book.setDate(result.getDate("tbBook_date").toLocalDate());
                book.setStatus(result.getInt("tbBook_status"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				statement.close();
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return book;
	}

    @Override
	public Book find(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
