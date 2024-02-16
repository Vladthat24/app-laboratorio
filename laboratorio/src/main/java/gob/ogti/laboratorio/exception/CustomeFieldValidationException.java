package gob.ogti.laboratorio.exception;

public class CustomeFieldValidationException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4485845156928654618L;
	
private final String fieldName;
	
	public CustomeFieldValidationException(String message, String fieldName) {
		
		super(message);
		this.fieldName = fieldName;
		
	}
	
	public String getFieldName() {
		return this.fieldName;
	}

}
