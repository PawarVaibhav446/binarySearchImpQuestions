import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumInSortedRotatedArray{

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        
        FastReader input = new FastReader();
        int n = input.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }

        int minAns = Integer.MAX_VALUE;
        
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            
            int mid = start + (end - start) / 2;

            if(a[start] <= a[mid]){
                minAns = Math.min(minAns, a[start]);
                start = mid + 1;
            }else{
                minAns = Math.min(minAns, a[start]);
                end = mid - 1;
            }
        }

        System.out.println(minAns);
    }
}