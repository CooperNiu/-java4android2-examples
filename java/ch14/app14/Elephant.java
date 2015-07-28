package app14;
public class Elephant implements Comparable {
    public float weight;
    public int age;
    public float tuskLength;
    public int compareTo(Object obj) {
        Elephant anotherElephant = (Elephant) obj;
        if (this.weight > anotherElephant.weight) {
            return 1;
        } else if (this.weight < anotherElephant.weight) {
            return -1;
        } else {
            // both elephants have the same weight, now
            // compare their age
            return (this.age - anotherElephant.age);
        }
    }
}