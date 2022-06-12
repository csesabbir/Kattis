import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        PrintWriter out = new PrintWriter (System.out);
        int tc = 0;
        while (in.hasNext()) {
            int n = in.nextInt();
            long []arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            tc += 1;
            out.println("Case " + tc + ":");
            int m = in.nextInt();
            for (int k = 0; k < m; k++) {
                long value = in.nextLong();
                long vv = 0L;
                long min = Long.MAX_VALUE;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        long res = Math.abs(value - (arr[i] + arr[j]));
                        if (min > res) {
                            min = res;
                            vv = arr[i] + arr[j];
                        }
                    }
                }
                out.println("Closest sum to " + value + " is " + vv + ".");
            }
        }
        out.flush();
    }
}