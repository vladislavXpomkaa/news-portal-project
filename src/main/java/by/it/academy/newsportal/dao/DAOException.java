package by.it.academy.newsportal.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = 2890115794179154869L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}
}
