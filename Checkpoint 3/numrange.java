public class Solution {
    public int numRange(int[] A, int B, int C) {
        int totalInRange = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = A[i];
            if (isInRange(sum, B, C)) {
                totalInRange++;
            } else if (sum > C) {
                continue;
            }
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                if (isInRange(sum, B, C)) {
                    totalInRange++;
                } else if (sum > C) {
                    break;
                }
            }
        }
        return totalInRange;
    }
    
    public boolean isInRange(int x, int B, int C) {
        return x >= B && x <= C;
    }
}
