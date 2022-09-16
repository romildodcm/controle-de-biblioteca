package models;

import java.time.LocalDate;

public class Book {
	private Integer id;
	private String name;
	private LocalDate date;
	private String author;
    private BookStatus status;

    public Book() {}

    public Book(Integer id, String name, LocalDate date, String author, BookStatus status) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
        this.status = status;
    }

    public Book(Integer id, String name, LocalDate date, String author, Integer status) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
        this.status = BookStatus.fromInteger(status);
    }

    public Book(String name, LocalDate date, String author, BookStatus status) {
        super();
        this.name = name;
        this.date = date;
        this.author = author;
        this.status = status;
    }

    public Book(String name, LocalDate date, String author, Integer status) {
        super();
        this.name = name;
        this.date = date;
        this.author = author;
        this.status = BookStatus.fromInteger(status);
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

    public LocalDate getDate() {
        return date;
    }

    public String getDateFormatted() {
        return date.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setStatus(Integer status) {
        this.status = BookStatus.fromInteger(status);
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
            Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
