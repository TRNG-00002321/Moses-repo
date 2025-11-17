public class DepositeException extends Exception {
    public DepositeException(double amount) {
        super("Amount has to be greater than zero. You entered: " + amount);
    }
}