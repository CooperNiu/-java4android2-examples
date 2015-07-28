package app06;
import java.util.Arrays;

public class MultidimensionalDemo1 {
    public static void main(String[] args) {
        int[][] matrix = new int[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = j + i;
            }
        }

        for (int i = 0; i < 2; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}