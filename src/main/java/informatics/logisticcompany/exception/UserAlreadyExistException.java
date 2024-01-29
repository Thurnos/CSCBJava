package informatics.logisticcompany.exception;

public class UserAlreadyExistException extends Exception {

    private String message;

    public UserAlreadyExistException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserAlreadyExistException{" +
                "message='" + message + '\'' +
                '}';
    }
}
