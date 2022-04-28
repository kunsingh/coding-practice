import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class MergeINterval {

    public static int[][] merge(int[][] intervals) {

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Pair pair = new Pair(intervals[i][0], intervals[i][1]);
            pairs.add(pair);
        }

        pairs.sort(Comparator.comparingInt(o -> o.start));

        for (int i = 0; i < pairs.size() - 1; i++) {
            Pair pair = pairs.get(i);
            Pair nextPair = pairs.get(i + 1);

            if (pair.start <= nextPair.start && pair.end >= nextPair.start) {
                pair.end = Math.max(pair.end, nextPair.end);
                pairs.remove(nextPair);
                i--;
            }
        }


        int[][] result = new int[pairs.size()][2];
        for (int i = 0; i < pairs.size(); i++) {
            result[i][0] = pairs.get(i).start;
            result[i][1] = pairs.get(i).end;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});//, {8, 10}, {15, 18}});0,2/1,4/3,5
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

class Pair {
    int start;
    int end;

    public Pair(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return start == pair.start &&
                end == pair.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
