package IO;


public class DataFormatException extends Exception {
    String message;

    public DataFormatException() {

    }

    public DataFormatException(String initialMessage) {
        super(initialMessage);
    }

    public String getMessage() {
        return message;
    }
}
