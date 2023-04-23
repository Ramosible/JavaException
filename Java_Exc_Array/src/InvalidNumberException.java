public class InvalidNumberException extends RuntimeException {
    private String description;
    InvalidNumberException(String msg,String description){
        super(msg);
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

}
