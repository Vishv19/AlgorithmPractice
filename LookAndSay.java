// import java.util.*;
public class LookAndSay {
    public static void main(String[] args) {
        String ans = lookAndSay(4);
        System.out.println(ans);
    }

    public static String lookAndSay(int n) {
        String s = "1";
        for(int i = 0; i < n; i++) {
            s = nextNumber2(s);
        }
        return s;
    }

    public static String nextNumber(String s) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int count = 1;
            while(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                i++;
                count++;
            }
            str.append(count);
            str.append(s.charAt(i));
        }
        return str.toString();
    }

    public static String nextNumber2(String s) {
        StringBuilder str = new StringBuilder();
        int count =  1;
        System.out.println(s);
        // if(s.equals("1")) {
        //     return "11";
        // }

        for(int i = 0; i < s.length(); i++) {
            //System.out.println("at index i " + i);
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                count++;
            }
            else {
                str.append(count);
                str.append(s.charAt(i));
                count = 1;
                System.out.println(str.toString());
            }
        }
        return str.toString();
    }
}

        // String last = "";
        // if(n == 1) {
        //  return "1";
        // }
        // else if(n==2) {
        //  return "11";
        // }
        // else {
        //  String previous = "11";
        //  for(int i = 3; i < n; i++) {
        //      String current = "";
        //      int count = 1;
        //      for(int j = 0; j < previous.length()-1; j++) {
        //          if(previous.charAt(j) == previous.charAt(j+1)) {
        //              // System.out.println("in if");
        //              count++;
        //          }
        //          else {
        //              // System.out.println("in else");
        //              current += count+previous.charAt(j);
        //              count = 1;
        //          }
        //      }
        //      previous = current;
        //      current = "";
        //      last = current;
        //  }
        //  return last;
        // }