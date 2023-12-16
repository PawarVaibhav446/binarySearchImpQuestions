import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class AggresiveCows {
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
        int k = input.nextInt();

        int[] stalls = new int[n];
        for (int i = 0; i < n; i++) {
            stalls[i] = input.nextInt();
        }

        Arrays.sort(stalls);

        int limit = stalls[n - 1] - stalls[0];
        int start = 1;
        int end = limit;
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(weCanPlaceCows(stalls, mid, k)){
                start = mid + 1;
                ans = mid;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(ans);

    }

    static boolean weCanPlaceCows(int[] stalls, int dist, int cows){

        int cntCows = 1; 
        int lastCow = stalls[0];

        for(int i = 0;i < stalls.length;i++){
            if(stalls[i] - lastCow >= dist){
                cntCows++;
                lastCow = stalls[i];
            }
        }

        if(cntCows >= cows){
            return true;
        }else{
            return false;
        }
    }
}
