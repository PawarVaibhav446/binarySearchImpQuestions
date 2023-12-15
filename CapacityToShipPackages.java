class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        
        int weightsSum = 0;
        for(int i = 0;i < weights.length;i++){
            weightsSum += weights[i];
        }

        int start = 1;
        int end = weightsSum;
        int ans = 0;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(doesItFill(weights, mid) <= days && doesItFill(weights, mid) != -1){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public int doesItFill(int[] a, int value){

        int daysReq = 1;
        int currentCapacity = 0;
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] > value) {
                return -1; 
            }
            
            if (currentCapacity + a[i] > value) {
                daysReq++;
                currentCapacity = 0;
            }
            
            currentCapacity += a[i];
        }

        return daysReq;
    }
}
