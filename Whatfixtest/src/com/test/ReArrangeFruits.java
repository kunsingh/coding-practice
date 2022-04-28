package com.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ReArrangeFruits {


    public String reArrangeFruits(final String fruitsString){

        StringBuilder fruits = new StringBuilder();
        Map<String, Integer> fruitsCount = new HashMap<>();

        String[] splittedFruits = fruitsString.split(",");

        for(String fruit: splittedFruits){

            if(fruitsCount.containsKey(fruit)){

                int count = fruitsCount.get(fruit);
                fruitsCount.put(fruit, count + 1);

            }else{
                fruitsCount.put(fruit, 1);
            }
        }

        //Arrangement






        return fruits.toString();

    }
}

/**
 *
 AAAA,B,C


 A - 4
 B-1
 C-1
 ------
 6   no of unique char = 3



 A

 A - 1
 ------
 1


 AAB

 A-2
 B-1
 ----
 3     no of unique char = 2



 AABC

 A-2
 B-1
 C-1
 ----
 4     char unique = 3


 AAABC

 5   3

 AABBC

 A- 2
 B - 2
 C-1

 1 -1  = 0 < no of unique char
 2 -2  = 0
 3 -2  = 1
 4- 2  = 2
 5- 3  = 2

 6 -3  = 3

 AAAAAABBBCDD
 ABABABACACA




 A - 6 = 5 = 4 = 3 = 2 = 1 = 0
 B-3    = 2 = 1 =0
 C-2     = 1 = 0
 D-2 = 0
 11 - 3 = 8

 ABABACADABACD



 */
