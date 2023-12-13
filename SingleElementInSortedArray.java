import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SingleElementInSortedArray {
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

        int ans = -1;

        if (nums.length == 1){
            ans = nums[0];
        }

        if(nums[0] != nums[1]){
           ans =  nums[0];
        }

        if(nums[nums.length - 1] != nums[nums.length - 2]){
            ans =  nums[nums.length - 1];
        }

        int start = 1;
        int end = nums.length - 2;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                ans = nums[mid];
            }

            if(mid % 2 == 1 && nums[mid - 1] == nums[mid] || mid % 2 == 0 && nums[mid] == nums[mid + 1]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        System.out.println(ans);

    }
}
