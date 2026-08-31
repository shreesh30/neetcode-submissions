class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] row=findRow(matrix, target);

        if(row.length==0) return false;

        return binarySearch(row, target);
    }

    public boolean binarySearch(int[] row, int target){
        int low=0,high=row.length-1;

        int mid;

        while(low<=high){
            mid=(low+high)/2;

            if(row[mid]<target){
                low=mid+1;
            }else if(row[mid]>target){
                high=mid-1;
            }else{
                return true;
            }
        }

        return false;
    }

    public int[] findRow(int[][] matrix, int target){
        int low=0,high=matrix.length-1;

        int mid;

        int[] result;

        while(low<=high){
            mid=(low+high)/2;
            result=matrix[mid];

            if(result[0]<=target && target<=result[result.length-1]){
                return result;
            }else{
                if(result[result.length-1]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }

        return new int[0];
    }
}
