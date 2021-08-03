package by.it.academy.newsportal.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 7336687545455142585L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}
}
