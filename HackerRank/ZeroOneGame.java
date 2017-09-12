import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int[] sequence = new int[n];
            for(int sequence_i=0; sequence_i < n; sequence_i++){
                sequence[sequence_i] = in.nextInt();
            }
            int turn = 0;
            if(sequence.length == 1) {
                System.out.println("Bob");
            }
            else {
                // If Alice wins, print 'Alice' on a new line; otherwise, print 'Bob'
                for(int i = 1; i < sequence.length-1; i++) {
                    // we have reach end of the list
                    if(sequence[i] == -1) {
                        if(turn == 0) {
                            System.out.println("Bob");
                        }
                        else {
                            System.out.println("Alice");
                        }
                        break;
                    }
                    if(sequence[i-1] == 0 && sequence[i+1] == 0 ) {
                        sequence[i] = -1;
                        turn ^= 1;
                        int j = i;
                        while(j < sequence.length) {
                            sequence[j] = sequence[j+1];
                            j++;
                        }
                        i=i-1;
                    }
                }
                if(turn == 0) {
                    System.out.println("Bob");
                }
                else {
                    System.out.println("Alice");
                }
            }

        }
    }
}