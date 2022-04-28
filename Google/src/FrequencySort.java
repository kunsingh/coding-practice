import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FrequencySort {

    public static String frequencySort(String s) {
        String result="";
        if(s != null && !s.isEmpty()){
            List<Count> list = new ArrayList<>();
            for(int i=0;i<s.length();i++){
                char chr = s.charAt(i);
                Count c = new Count(chr);

                if(list.contains(c)){
                    Count count = list.get(list.indexOf(c));
                    count.value = count.value + chr;
                    count.count = count.count + 1;
                }else {
                    c.count=1;
                    c.value = c.value + chr;
                    list.add(c);
                }
            }
            list.sort((o1, o2) -> o2.count - o1.count);
            for(Count count:list){
                result = result + count.value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("raaeaedere"));
    }
}

class Count{
    char c;
    int count;
    String value="";

    public Count(char c) {
        this.c = c;
    }

    public Count(char c, int count) {
        this.c = c;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
        return c == count.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c);
    }
}
