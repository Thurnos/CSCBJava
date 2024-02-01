package informatics.logisticcompany.exception;


/**
 * Custom exception class to signal that an attempt to create a new user
 * has failed because the user already exists in the system.
 * This exception is typically thrown during user registration processes
 * when a user with the same identifying information (e.g., username or email)
 * already exists in the database.
 */
public class UserAlreadyExistException extends Exception {

    private String message;


    /**
     * Constructs a new UserAlreadyExistException with the specified detail message.
     * The message provides more information about the reason why the user already exists.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public UserAlreadyExistException(String message) {
        this.message = message;
    }


    /**
     * Returns a string representation of the UserAlreadyExistException.
     * This overrides the toString method of class java.lang.Throwable.
     *
     * @return A string representation of this exception, including the detail message.
     */
    @Override
    public String toString() {
        return "UserAlreadyExistException{" +
                "message='" + message + '\'' +
                '}';
    }
}
