import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PeakElement {

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


        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }

        if(nums.length == 1){
            System.out.println(0);
        } 
 
        if(nums[0] > nums[1]){
            System.out.println(0);
        }
 
        if(nums[nums.length - 1] > nums[nums.length - 2]){
            System.out.println(n - 1);
        }
 
 
        int start = 1;
        int end = nums.length - 2;
 
        while(start <= end){
            int mid = start + (end - start) / 2;
 
            if(nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]){
                System.out.println(mid);
                break;
            }else if(nums[mid] > nums[mid - 1]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

    }
}
