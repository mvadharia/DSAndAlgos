package utils.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FastReader {
    BufferedReader br;
    StringTokenizer st;
    private PrintWriter out;

    public FastReader() {
        br = new BufferedReader(
                new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    long[] nextlongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    }

    Long[] nextLongArr(int n) {
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++)
            a[i] = nextLong();
        return a;
    }

    int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    Integer[] nextIntegerArray(int n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    double[] nextDoubles(int n) {
        double[] res = new double[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    private void printLine(Object... objects) {
        boolean isFirst = true;
        for (Object o : objects) {
            if (!isFirst) {
                out.print(" ");
            } else {
                isFirst = false;
            }
            out.print(o.toString());
        }
        out.println();
    }
}