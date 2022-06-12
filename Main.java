import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        public int n; 
        public int m;
        public int []bit;
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            int []arr = new int[n + 1];
            bit = new int[n + 1];
            for (int i = 1; i <= m; i++) {
                char ch = in.next().charAt(0);
                if (ch == 'F') {
                    int pos = in.nextInt();
                    if (arr[pos] == 1) {
                        arr[pos] = 0;
                        update(pos, -1);
                    } else {
                        arr[pos] = 1;
                        update(pos, 1);
                    }
                } else {
                    int a = in.nextInt(), b = in.nextInt();
                    int res = sum(b) - sum(a - 1);
                    out.println(res);
                }
            }
        }
        public int sum(int i) {
            int value = 0;
            while (i > 0) {
                value += bit[i];
                i -= (i & -i);
            }
            return value;
        }
        public void update(int i, int value) {
            while (i <= n) {
                bit[i] += value;
                i += (i & -i);
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

