package by.home.homeproject.command.exception;

public class CommandException extends Exception{
	private static final long serialVersionUID = 1L;

	public CommandException() {
	}

	public CommandException(String massage) {
		super(massage);
	}
}