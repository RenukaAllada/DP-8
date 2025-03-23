class Sample{
    /*******************PROBLEM-1****************/

    //TC:0(n*n)
//SC:0(1)
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if(nums==null || nums.length==0){
                return 0;
            }
            int count=0,n=nums.length;
            for(int i=0;i<n-2;i++){
                int diff=nums[i+1]-nums[i];
                for(int j=i+1;j<n-1;j++){
                    if(nums[j+1]-nums[j]==diff){
                        count++;
                    }else{
                        break;
                    }
                }
            }
            return count;
        }
    }

    //TC:0(n)
//SC:0(n)
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if(nums==null || nums.length==0){
                return 0;
            }
            int count=0,n=nums.length;
            int[] dp=new int[n];
            for(int i=n-3;i>=0;i--){
                if(nums[i+1]-nums[i]==nums[i+2]-nums[i+1]){
                    dp[i]=1+dp[i+1];
                }
                count=count+dp[i];
            }
            return count;
        }
    }

    //TC:0(n)
//SC:0(n)
    class Solution {
        public int numberOfArithmeticSlices(int[] nums) {
            if(nums==null || nums.length==0){
                return 0;
            }
            int count=0,n=nums.length;
            int[] dp=new int[n];
            for(int i=2;i<n;i++){
                if(nums[i-1]-nums[i-2]==nums[i]-nums[i-1]){
                    dp[i]=1+dp[i-1];
                }
                count=count+dp[i];
            }
            return count;
        }
    }

    /*******************PROBLEM-2****************/
    //TC:0(N*M)
//SC:0(1)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if(triangle.size()==0 || triangle==null){
                return 0;
            }
            int n=triangle.size();
            if(n==1){
                return triangle.get(0).get(0);
            }

            for(int i=n-2;i>=0;i--){
                int size=triangle.get(i).size();
                for(int j=0;j<size;j++){
                    int min=Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                    triangle.get(i).set(j,triangle.get(i).get(j)+min);
                }
            }
            return triangle.get(0).get(0);
        }
    }

    //TC:0(N*M)
//SC:0(1)
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if(triangle.size()==0 || triangle==null){
                return 0;
            }
            int n=triangle.size();
            if(n==1){
                return triangle.get(0).get(0);
            }

            for(int i=1;i<n;i++){
                int size=triangle.get(i).size();
                for(int j=0;j<size;j++){
                    if(j==0){
                        triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
                    }else if(j==size-1){
                        triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                    }else{
                        int min=Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1));
                        triangle.get(i).set(j,triangle.get(i).get(j)+min);
                    }

                }
            }
            int min=Integer.MAX_VALUE;
            for(int i=0;i<triangle.get(n-1).size();i++){
                min=Math.min(min,triangle.get(n-1).get(i));
            }
            return min;
        }
    }
}