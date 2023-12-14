import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SmallestDivisorGivenAThreshold {

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

        int threshold = input.nextInt();

        int maxN = Integer.MIN_VALUE;
        int ans = 0;

        for(int i: a){
            maxN = Math.max(i, maxN);
        }

        int start = 1;
        int end = maxN;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(result(a, mid) > threshold){
                start = mid + 1;
            }else{
                ans = mid;
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
    
    static int result(int[] a, int divisor){
        int ans = 0;
        for(int i : a){
            ans += Math.ceil((double)(i) / (double) divisor);
        }

        return ans;
    }
}
