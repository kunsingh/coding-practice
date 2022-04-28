import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 1. You are a in flight Movie service provider. You are given a list of movie lengths and the duration of the flight.
 * return a pair (2) movies whose combined length is the highest and is less than or equal to flight duration.
 * If multiple such combinations are possible, return the pair which has the movie of longer longest duration.
 *
 * Ex :
 *
 * MovieLenghts : {27, 1,10, 39, 12, 52, 32, 67, 76}
 *
 * Flight Duration : 77.
 *
 * The 2 possible pairs are (1,76) and (10,67), The answer is (1,76) as per the last constraint.
 */

public class FlightExperience {

    public static Pairs getHighestLengthMovie(final int[] movieDurations, int flightLength){
        Pairs pairs = new Pairs();
        if(movieDurations != null && movieDurations.length>0 && flightLength > 0){
            Arrays.sort(movieDurations);

            int start =0;
            int end = movieDurations.length-1;

            while (start < end){
                int durationCombined = movieDurations[start] + movieDurations[end];
                if(durationCombined <= flightLength){
                    pairs.first = movieDurations[start];
                    pairs.second = movieDurations[end];
                    start++;
                }else
                   break;
                }
            }

        return pairs;
    }

    static class Pairs{
        int first;
        int second;
    }

    public static void main(String[] args) {
        Pairs pairs = getHighestLengthMovie(new int[]{27, 1,10, 2,39, 12, 52, 32, 67, 76}, 77);
        System.out.println(pairs.first + " - " + pairs.second);
    }
}
