import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {

        LinkedList<Integer> list = new LinkedList<>();
        for(int i: asteroids){
            list.add(i);
        }
        for(int i=0; i<list.size()-1; i++){
            if(i >= 0 && list.get(i+1) < 0 && list.get(i) > 0){
                if(Math.abs(list.get(i+1)) != list.get(i)){
                    if(Math.abs(list.get(i+1)) > list.get(i)){
                        list.remove(i);
                        if(i > 0)
                            i=i-2;
                        if(i <0) i=-1;
                    }else{
                        list.remove(i+1);
                        i=i-1;
                        if(i <0) i=-1;
                    }
                }else {
                    list.remove(i);
                    list.remove(i);
                    i=i-2;
                    if(i <0) i=-1;
                }

            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,-1,-2};

        int[] res = asteroidCollision(a);
        for(int i: res){
            System.out.println(i);
        }
    }
}
