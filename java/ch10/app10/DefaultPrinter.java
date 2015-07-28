package app10;
public abstract class DefaultPrinter {
    @Override
    public String toString() {
        return "Use this to print documents.";
    }
    public abstract void print(Object document);
}