import java.util.*;

public class StringFrequency {
    public static void main(String[] args) {
        int[] result = frequency("23#(2)24#25#26#23#(3)");
        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] frequency(String s) {
        int[] result = new int[26];
        int len = s.length();
        int i = 0;

        while(i < len) {
            int val = 0;
            if(i+2 >= len || s.charAt(i+2)!= '#') {
                val = s.charAt(i) - '0';
                System.out.println("index: " + (val-1));
                result[val-1] =  result[val-1] + 1;
                i++;
            }
            else if(s.charAt(i+2) == '#') {
                val = (s.charAt(i) - '0')*10 +  (s.charAt(i+1) - '0');
                result[val-1] =  result[val-1] + 1;
                i = i + 3;
            }
            if(i < len) {
                if(s.charAt(i) == '(') {
                    int freq = s.charAt(i + 1) - '0';
                    result[val-1] += freq - 1;
                    i = i + 3;
                }
            }
        }
        return result;
    }
}