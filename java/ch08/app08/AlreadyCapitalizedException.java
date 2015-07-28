package app08;
public class AlreadyCapitalizedException extends Exception {
    @Override
    public String toString() {
        return "Input has already been capitalized";
    }
}