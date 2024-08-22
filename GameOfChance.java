import java.util.Scanner;

public class GameOfChance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] luckiness = new long[n];
        for (int i = 0; i < n; i++) {
            luckiness[i] = scanner.nextLong();
        }
        scanner.close();

        double[] probabilities = new double[n];
        for (int i = 0; i < n; i++) {
            probabilities[i] = 1.0; // Initially, everyone has a 100% chance of winning
        }

        int currentSize = n;
        while (currentSize > 1) {
            int nextSize = currentSize / 2;
            for (int i = 0; i < nextSize; i++) {
                int idx1 = 2 * i;
                int idx2 = 2 * i + 1;

                double winProb1 = (double) luckiness[idx1] / (luckiness[idx1] + luckiness[idx2]);
                double winProb2 = (double) luckiness[idx2] / (luckiness[idx1] + luckiness[idx2]);

                probabilities[idx1] *= winProb1;
                probabilities[idx2] *= winProb2;
            }

            // Move to the next round
            currentSize = nextSize;
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < n; i++) {
            output.append(String.format("%.9f", probabilities[i])).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}
