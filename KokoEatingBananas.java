import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KokoEatingBananas {
    
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

        int Hours = input.nextInt();

        int[] a = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
            max = Math.max(a[i], max);
        }

        int start = 1;
        int end = max;
        int ans = 0;

        while (start <= end) {
            
            int mid = start + (end - start) / 2;
            int noOfHours = 0;

            for (int i = 0; i < a.length; i++) {
                noOfHours += Math.ceil((double)a[i] / (double)mid);
            }

            if(noOfHours <= Hours){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
