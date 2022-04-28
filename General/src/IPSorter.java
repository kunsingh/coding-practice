import java.util.*;

/**
 * 10.1.123.211 
 * 2.10.123.45 
 * 10.2.45.77 
 * 45.123.211.2 
 *
 *
 * output 
 * 2.10.123.45 
 * 10.1.123.211 
 * 10.2.45.77 
 * 45.123.211.2
 */
public class IPSorter {

    public void sortIPAddresses(final List<String> ipAddresses){

        Collections.sort(ipAddresses, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (Integer.parseInt(o1.substring(0, o1.indexOf("."))) - (Integer.parseInt(o2.substring(0, o2.indexOf(".")))));
            }
        });


        for(int i=0; i< ipAddresses.size();i++){
            List<String> newList = new ArrayList<>();
            String[] splittedAddress = ipAddresses.get(i).split(".");
            String[] splittedAddressNext = ipAddresses.get(i+1).split(".");
            if(splittedAddress[0].equals(splittedAddressNext[0])){
                newList.add(ipAddresses.get(i));
            }
//            sortAgain

        }


        if(ipAddresses != null && ipAddresses.size() > 0){

            ipAddresses.forEach(ipAddress ->{
                String[] splittedAddress = ipAddress.split(".");



            });

        }
    }

    private void sortByDotPosition(final List<String> ipAddresses, final int startPos,final int endPos){

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("10.1.123.211","2.10.123.45","10.2.45.77"));

        List<String> addressList = new ArrayList<>(Arrays.asList("192.168.0.5", //
                "192.168.0.1", "192.168.25.1", "192.168.10.21", "192.168.77.1"));
        Collections.sort(list, (a, b) -> {
            int[] aOct = Arrays.stream(a.split("\\.")).mapToInt(Integer::parseInt).toArray();
            int[] bOct = Arrays.stream(b.split("\\.")).mapToInt(Integer::parseInt).toArray();
            int r = 0;
            for (int i = 0; i < aOct.length && i < bOct.length; i++) {
                r = Integer.compare(aOct[i], bOct[i]);
                if (r != 0) {
                    return r;
                }
            }
            return r;
        });
        System.out.println(list);
    }
}
