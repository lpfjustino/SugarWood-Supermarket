package sugarwood.supermarket.network;

import sugarwood.supermarket.User;

public enum Command {
    EXIT("exit"), LOGIN("login"), INVALID_USER("invalid_user"), 
    LOGIN_SUCCESS("login_success");
    
    String representation;
    
    private Command(String representation) {
        this.representation = representation;
    }
    
    public static Command parseCommand(String cmd) {
        String[] parts = cmd.split(",");
        
        switch(parts[0]) {
            case "login":
                return LOGIN;
                
            case "login_success":
                return LOGIN_SUCCESS;
                
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
    
    public static String loginCommand(String mail, String pwd, String type) {
        return String.join(",", LOGIN.representation, mail, pwd, type);
    }
    
    public static String loginResponse(boolean success, User user) {
        if(success == true) {
            String userInfo = String.join(",", user.getFieldValues());
            return String.join(",", LOGIN_SUCCESS.representation, userInfo);
        } else {
            return INVALID_USER.representation;
        }
    }
    
    public static User userFromLoginResponse(String response) {
        String[] params = response.split(",");
        
        User user = new User(Integer.parseInt(params[1]), params[2], params[3],
                params[4], params[5], params[6]);
        return user;
    }
    
}