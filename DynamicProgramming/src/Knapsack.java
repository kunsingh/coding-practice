import java.io.File;
import java.util.Scanner;

public class Knapsack {

    public static int getMaximum(int[] profits, int[] weights, int maxWeight) {

        if (profits == null || profits.length == 0 || weights == null || weights.length == 0) {
            return 0;
        }

        int n = profits.length;

        int[][] F = new int[n + 1][maxWeight + 1];
        int[] selected = new int[n + 1];

        for (int i = 0; i < F.length; i++) {
            F[i][0] = 0;
        }

        for (int i = 0; i <= maxWeight; i++) {
            F[0][i] = 0;
        }

        for (int p = 1; p <= profits.length; p++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (weights[p - 1] <= w) {
                    F[p][w] = Math.max(F[p - 1][w], F[p - 1][w - weights[p - 1]] + profits[p - 1]);
                } else {
                    F[p][w] = F[p - 1][w];
                }
            }
        }
        System.out.println("\nItems selected : ");
        int tempW = maxWeight;
        int y = 0; //to index in selected
        for (int x = weights.length; x > 0; x--) {
            if ((tempW - weights[x - 1] >= 0) && (F[x][tempW] - F[x - 1][(int) (tempW - weights[x - 1])] == profits[x - 1])) {
                selected[y++] = x - 1; //store current index and increment y
                tempW -= weights[x - 1];
            }
        }
        for (int j = y - 1; j >= 0; j--) {
            System.out.print("#" + (selected[j] + 1) + " ");
            System.out.println(profits[selected[j]]);
        }
        return F[profits.length][maxWeight];
    }

    public static int getMaximumPackage(int[] profits, int[] weights, int maxWeight) {

        if (profits == null || profits.length == 0 || weights == null || weights.length == 0) {
            return 0;
        }

        int n = profits.length;

        int[][] F = new int[n + 1][maxWeight + 1];
        int[] selected = new int[n + 1];

        for (int p = 1; p <= profits.length; p++) {
            for (int w = 0; w <= maxWeight; w++) {
                if (p == 0 || w == 0) {
                    F[p][w] = 0;
                } else if (weights[p - 1] <= w) {
                    F[p][w] = Math.max(F[p - 1][w], F[p - 1][w - weights[p - 1]] + profits[p - 1]);
                } else {
                    F[p][w] = F[p - 1][w];
                }
            }
        }
        int tempW = maxWeight;
        int y = 0;
        for (int x = weights.length; x > 0; x--) {
            if ((tempW - weights[x - 1] >= 0) && (F[x][tempW] - F[x - 1][(tempW - weights[x - 1])] == profits[x - 1])) {
                selected[y++] = x - 1;
                tempW -= weights[x - 1];
            }
        }
        String result = "";
        for (int j = y - 1; j >= 0; j--) {
            result = result + (selected[j] + 1) + ",";
        }
        if (!result.isEmpty()) {
            System.out.println(result.substring(0, result.lastIndexOf(",")));
        } else {
            System.out.println("-");
        }

        return F[profits.length][maxWeight];
    }


    public static void main(String[] args) throws Exception {
//        int value[] = { 60, 100, 120, 170 };
//        int weight[] = { 10, 20, 30, 40 };
//        int maxWeight = 50;
//        System.out.println(getMaximum(value, weight,maxWeight));

        File file = new File("/Users/kunal/data/test.txt");
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (!line.isEmpty()) {
                int maxWeight = Integer.parseInt(line.substring(0, line.indexOf(":")).trim());
                String[] data = line.substring(line.indexOf(":") + 1).trim().split(" ");
                int[] weight = new int[data.length];
                int[] cost = new int[data.length];
                for (int i = 0; i < data.length; i++) {
                    String[] values = data[i].split(",");
                    weight[i] = (int) Double.parseDouble(values[1]);
                    cost[i] = Integer.parseInt(values[2].substring(1, values[2].length() - 1));


                }
                getMaximumPackage(cost, weight, maxWeight);
            }
        }
    }
}
