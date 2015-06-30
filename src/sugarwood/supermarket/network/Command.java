package sugarwood.supermarket.network;

public enum Command {
    EXIT("exit"), LOGIN("login");
    
    String representation;
    
    private Command(String representation) {
        this.representation = representation;
    }
    
    public static Command parseCommand(String cmd) {
        switch(cmd) {
            case "exit":
                return EXIT;
                
            default:
                return null;
        }
    }
    
    public static String parseCommand(Command cmd) {
        switch(cmd) {
            case EXIT:
                return "exit";
                
            default:
                return null;
        }
    }
}
