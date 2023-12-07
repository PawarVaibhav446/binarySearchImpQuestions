/*
 LowerBound: The lower bound is the smallest index, ind, where arr[ind] >= target. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ImplementLowerBound {
    
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

        int ans = lowerBound(a, target, 0, n - 1);
        System.out.println(ans);
    }

    static int lowerBound(int[] a, int target, int start, int end){

        start = 0;
        end = a.length - 1;
        int ans = a.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            /*
             Case 1 – If arr[mid] >= x: This condition means that the index mid may be an answer. 
             So, we will update the ‘ans’ variable with mid and search in the left half if there is any smaller index that satisfies the same condition. 
             Here, we are eliminating the right half.
             
             Case 2 – If arr[mid] < x: In this case, mid cannot be our answer and we need to find some bigger element. 
             So, we will eliminate the left half and search in the right half for the answer.
             */
            
            if(a[mid] >= target){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
}
