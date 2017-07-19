package by.home.homeproject.service.exception;

public class ServiceException extends Exception{
	private static final long serialVersionUID = 1L;

	public ServiceException() {
	}

	public ServiceException(String massage) {
		super(massage);
	}
}