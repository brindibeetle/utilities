package nl.lunatech.emile.utilities.domain;

public class BsnCheckReturn {

	private int code;
	private String message;

	public BsnCheckReturn() {
		super();
	}

	public BsnCheckReturn(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
