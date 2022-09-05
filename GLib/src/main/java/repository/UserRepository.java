package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.User;

public class UserRepository implements IUserRepository {
	
	private Connection conn;
	
	public UserRepository() {
		conn = ConnectionFactory.getConnection();
	}

	@Override
	public User insert(User user) {
		PreparedStatement statement = null;
		
		try {
            String sql = "INSERT INTO tbUser(tbUser_name,tbUser_username,tbUser_password,tbUser_status) VALUES(?,?,?,?)";
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getName());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getType().toInteger());
			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet ids = statement.getGeneratedKeys();
				
				while (ids.next()) {
					user.setId(ids.getInt(1));
				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User update(User user) {
		PreparedStatement statement = null;
		
		try {
            String sql = "UPDATE tbUser SET tbUser_name = ?, tbUser_username = ?, tbUser_password = ?, tbUser_status = ? WHERE (tbUser_id = ?)";
			statement = conn.prepareStatement(sql);

            statement.setString(1, user.getName());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getType().toInteger());
            statement.setInt(5, user.getId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public Integer deleteById(Integer id) {
		PreparedStatement statement = null;
		
		try {
			String sql = "DELETE FROM tbUser WHERE (tbUser_id = ?)";
			statement = conn.prepareStatement(sql);
			
			statement.setInt(1, id);
			
			int rowsAffected = statement.executeUpdate();
			//System.out.println("Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return id;
	}

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		PreparedStatement stmt = null;
		ResultSet result = null;
	
		try {
            String sql = "SELECT * FROM tbUser";
			stmt = conn.prepareStatement(sql);
			result = stmt.executeQuery();
			
			while(result.next()) {
                User u = new User();

                u.setId(result.getInt("tbUser_id"));
                u.setName(result.getString("tbUser_name"));
                u.setUsername(result.getString("tbUser_username"));
                u.setPassword(result.getString("tbUser_password"));
                u.setType(result.getInt("tbUser_status"));

                users.add(u);
			}
		} catch (SQLException e) {
		
			throw new RuntimeException(e.getMessage());
		
		} finally {
						
			try {
				stmt.close();
				result.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return users;
	
	}

	@Override
	public User find(Integer id) {
        User user = null;
		PreparedStatement statement = null;
		ResultSet result = null;
	
		try {
            String sql = "SELECT * FROM tbUser WHERE (tbUser_id = ?)";
			statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

			result = statement.executeQuery();
			
			while(result.next()) {
                user = new User();

                user.setId(result.getInt("tbUser_id"));
                user.setName(result.getString("tbUser_name"));
                user.setUsername(result.getString("tbUser_username"));
                user.setPassword(result.getString("tbUser_password"));
                user.setType(result.getInt("tbUser_status"));
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
		
		return user;
	}

	@Override
	public User find(String username) {
		User user = null;
		PreparedStatement statement = null;
		ResultSet result = null;
	
		try {
            String sql = "SELECT * FROM tbUser WHERE (tbUser_username = ?)";
			statement = conn.prepareStatement(sql);
            statement.setString(1, username);

			result = statement.executeQuery();
			
			while(result.next()) {
                user = new User();

                user.setId(result.getInt("tbUser_id"));
                user.setName(result.getString("tbUser_name"));
                user.setUsername(result.getString("tbUser_username"));
                user.setPassword(result.getString("tbUser_password"));
                user.setType(result.getInt("tbUser_status"));
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
		
		return user;
	}
}
