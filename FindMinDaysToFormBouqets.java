class FindMinDaysToFormBouqets {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int minN = Integer.MAX_VALUE;
        int maxN = Integer.MIN_VALUE;
        int flowersReq = m * k;
        int ans = -1;

        if(flowersReq > bloomDay.length){
            return -1;
        }

        for(int i = 0;i < bloomDay.length;i++){
            maxN = Math.max(maxN, bloomDay[i]);
        }

        for(int i = 0;i < bloomDay.length;i++){
            minN = Math.min(minN, bloomDay[i]);
        }

        int start = minN;
        int end = maxN;

        while(start <= end){

            int mid = start + (end - start) / 2;

            if(countBouq(bloomDay, mid, k) < m){
                start = mid + 1;
            }else{
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

    public int countBouq(int[] a, int dayLimit, int k){

        int count = 0;
        int adjCount = 0;

        for(int day: a){
            if(day <= dayLimit){
                adjCount++;
                if(adjCount == k){
                    count++;
                    adjCount = 0;
                }
            }else{
                adjCount = 0;
            }
        }

        return count;
    }
}