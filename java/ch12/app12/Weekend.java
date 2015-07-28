package app12;

public enum Weekend {
    SATURDAY,
    SUNDAY;
    
    private Weekend() {
    }
    
    @Override
    public String toString() {
        return "Fun day " + (this.ordinal() + 1);
    }
    public static void main(String[] args) {
        // print class name
        System.out.println(
                Weekend.SATURDAY.getClass().getName());
        
        for (Weekend w : Weekend.values()) {
            System.out.println(w.name() + ": " + w);
        }
    }
}