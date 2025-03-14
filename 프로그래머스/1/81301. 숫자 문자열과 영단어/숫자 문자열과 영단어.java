import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        Map<String, String> word = new HashMap<>();
        word.put("zero", "0");
        word.put("one", "1");
        word.put("two", "2");
        word.put("three", "3");
        word.put("four", "4");
        word.put("five", "5");
        word.put("six", "6");
        word.put("seven", "7");
        word.put("eight", "8");
        word.put("nine", "9");

        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for(int i=0; i<str.length; i++){

            if(Character.isDigit(str[i]))
                result.append(str[i]);
            else{
                sb.append(str[i]);
            }


            if(word.containsKey(sb.toString())){
                result.append(word.get(sb.toString()));
                sb = new StringBuilder();
            }

        }

        return Integer.parseInt(result.toString());
    }
}