package codeyasam.baseapi.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3167909564000682283L;
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
