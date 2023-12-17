import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BookAllocation {
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
        int N = input.nextInt();
        int M = input.nextInt();
        int[] A = new int[N];

        for(int i = 0;i < N;i++){
            A[i] = input.nextInt();
        }

        if(M > N){
            System.out.println(-1);
        }
        
        int sum = 0;
        int maxN = Integer.MIN_VALUE;
        for(int i = 0;i < N;i++){
            sum += A[i];
            maxN = Math.max(maxN, A[i]);
        }
        
        
        int start = maxN;
        int end = sum;
        int ans = 0;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            int cntStud = countNoOfStud(A, mid);
            
            if(cntStud > M){
                start = mid  + 1;
            }else{
                ans = mid;
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static int countNoOfStud(int[] a, int pages){
        int student = 1;
        int pagesStudent = 0;
        
        for(int i = 0;i < a.length;i++){
            if(pagesStudent + a[i] <= pages){
                pagesStudent += a[i];
            }else{
                student++;
                pagesStudent = a[i];
            }
        }
        
        return student;
    }

    
}
