package sugarwood.supermarket;

public class NoSuchUserException extends Exception {

    public NoSuchUserException() {
    }

    public NoSuchUserException(User user) {
        super("The user " + user + " doesn't exit");
    }
}
