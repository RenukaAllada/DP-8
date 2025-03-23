class Sample{
    /*******************PROBLEM-1****************/

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