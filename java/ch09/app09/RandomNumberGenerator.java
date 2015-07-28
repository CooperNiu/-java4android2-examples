package app09;

public class RandomNumberGenerator {

    /*
     * Returns a random number between 0 and 9 (inclusive)
     */
    public int generate() {
        double random = Math.random();
        return (int) (random * 10);
    }

    public static void main(String[] args) {
        RandomNumberGenerator generator = 
                new RandomNumberGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate());
        }

    }
}