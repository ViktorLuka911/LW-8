package Exceptions;

class TestEndException extends RuntimeException {
    public TestEndException() {
        super("Test should end after this exception");
    }
}