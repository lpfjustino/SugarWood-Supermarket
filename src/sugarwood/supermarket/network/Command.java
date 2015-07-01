package sugarwood.supermarket.network;

public enum Command {
    EXIT("exit"), LOGIN("login"), INVALID_USER("invalid_user"), 
    LOGIN_SUCCESS("login_success");
    
    String representation;
    
    private Command(String representation) {
        this.representation = representation;
    }
    
    public static Command parseCommand(String cmd) {
        switch(cmd) {
            case "invalid_user":
                return INVALID_USER;
            
            case "exit":
                return EXIT;
                
            default:
                return null;
        }
    }
    
    public static String parseCommand(Command cmd) {
        switch(cmd) {
            case INVALID_USER:
                return "invalid_user";
                
            case LOGIN_SUCCESS:
                return "login_success";
                
            case EXIT:
                return "exit";
                
            default:
                return null;
        }
    }
}