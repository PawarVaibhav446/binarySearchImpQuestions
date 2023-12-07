import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchInsertPosition {
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

        int target = input.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }

        int ans = wheretoInsert(a, target, 0, n - 1);
        System.out.println(ans);
    }

    static int wheretoInsert(int[] a, int target, int start, int end){

        start = 0;
        end = a.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(a[mid] > target){
                end = mid - 1;
            }else if(a[mid] < target){
                start = mid + 1;
            }else{
                return mid;
            }
        }

        return start;
    }

}