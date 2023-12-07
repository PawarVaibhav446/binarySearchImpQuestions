import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class binarySeachRecursive {

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

        int ans = binarySearchRS(a, target, 0, n - 1);
        System.out.println(ans);

    }

    static int binarySearchRS(int[] a, int target, int start, int end){

        if(start > end){
            return - 1;
        }
        
        int mid = start + (end - start) / 2;

        if(a[mid] == target){
            return mid;
        }

        if(a[mid] > target){
            return binarySearchRS(a, target, start, mid - 1);
        }else{
            return binarySearchRS(a, target, mid + 1, end);
        }
    }
}
