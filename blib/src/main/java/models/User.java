package models;

public class User {
	private Integer id;
	private String name;
	private String username;
	private String password;
	private UserType type;

    public User() {}

    public User(Integer id, String name, String username, String password, UserType type) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(Integer id, String name, String username, String password, Integer type) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = UserType.fromInteger(type);
    }

    public User(String name, String username, String password, UserType type) {
        super();
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String name, String username, String password, Integer type) {
        super();
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = UserType.fromInteger(type);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }
    
    public void setType(UserType type) {
        this.type = type;
    }

    public void setType(Integer type) {
        this.type = UserType.fromInteger(type);
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
            User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    // java username validation
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9_-]{3,15}$");
    }

    // java password validation
    public static boolean isValidPassword(String password) {
        return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
    }

    // isValidType
    public static boolean isValidType(Integer type) {
        return type == 0 || type == 1;
    }

    // is valid id
    public static boolean isValidId(Integer id) {
        return id > 0;
    }


}
