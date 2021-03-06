import java.util.*;
import java.math.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Collatz {
    public static class CollatzCheckParallel implements Runnable {
        public int lower;
        public int upper;

        CollatzCheckParallel(int lower, int upper) {
            this.lower = lower;
            this.upper = upper;
        }

        @Override
        public void run() {
            for(int i = lower; i <= upper; ++i) {
                Collatz.CollatzCheck(i, new HashSet<BigInteger>());
            }
        }
    }

    public static boolean CollatzCheck(int aNum, Set<BigInteger> visited) {
        BigInteger b = new BigInteger(new Integer(aNum).toString());
        return CollatzCheck(b, visited);
    }

    public static boolean CollatzCheck(BigInteger aNum, Set<BigInteger> visited) {
        if(aNum.equals(BigInteger.ONE)) {
            return true;
        } else if(visited.contains(aNum)) {
            return false;
        }
        visited.add(aNum);

        if(aNum.getLowestSetBit() == 1) {
            return CollatzCheck(new BigInteger("3").multiply(aNum).add(BigInteger.ONE), visited);
        } else {
            return CollatzCheck(aNum.shiftRight(1), visited);
        }
    }

    static int N = 10000000;
    static int RANGESIZE = 10000000;
    static int NTHREADS = 4;

    static void parseArgs(String[] args) {
        if(args.length >=1) {
            N = Integer.parseInt(args[0]);
        }
        if(args.length >=2) {
            RANGESIZE = Integer.parseInt(args[1]);
        }
        if(args.length >=3) {
            NTHREADS = Integer.parseInt(args[2]);
        }
    }

    public static ExecutorService execute() {
        List<Thread> threads = new ArrayList<Thread>();
        ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
        for(int i = 0; i < (N/RANGESIZE); ++i) {
            Runnable worker = new CollatzCheckParallel(i * RANGESIZE+1, (i+1)*RANGESIZE);
            executor.execute(worker);
        }
        executor.shutdown();
        return executor;
    }

    public static void main(String[] args) {
        long lDateTime = new Date().getTime();
        parseArgs(args);

        ExecutorService executor = execute();
        try {
            while(!executor.awaitTermination(1, TimeUnit.SECONDS)) {

            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finish all threads");
        long fDateTime = new Date().getTime();
        System.out.println("time in milliseconds for checking to " + N + " is "
                   + (fDateTime - lDateTime) + " ("
                   + N / (fDateTime - lDateTime) + " per ms)");
    }
}
