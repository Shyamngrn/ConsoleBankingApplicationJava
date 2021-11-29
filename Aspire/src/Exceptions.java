class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message){
        super(message);
    }
}

class NonExistingUser extends Exception {
	public NonExistingUser(String message) {
		super(message);
	}
}