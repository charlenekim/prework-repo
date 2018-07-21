public class Solution {
    public int[][] prettyPrint(int A) {
        int matrixLen = A * 2 - 1;
        int[][] matrix = new int[matrixLen][matrixLen];
        int minIndex = 0, maxIndex = matrixLen - 1;
        
        for (int currentA = A; currentA >= 2; currentA--) {
            for (int i = minIndex; i <= maxIndex; i++) {
                matrix[minIndex][i] = currentA;
                matrix[i][maxIndex] = currentA;
                matrix[maxIndex][i] = currentA;
                matrix[i][minIndex] = currentA;
            }
            minIndex++;
            maxIndex--;
        }
        if (minIndex == maxIndex) {
            matrix[minIndex][maxIndex] = 1;
        }
        return matrix;
    }
}
