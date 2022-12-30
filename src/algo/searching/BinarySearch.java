package algo.searching;

public class BinarySearch {

    private BinarySearch(){}

    static int binarySearch(int[] arr, int low, int high,int target){
        if(high<low)throw new IllegalArgumentException();
        int mid=(low+high)>>1;
        while(low<=high){
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }

    static int lowerBound(int[] arr, int low, int high, int target){
        if(high<low)throw new IllegalArgumentException();
        int mid=(low+high)>>1;
        while(low<=high){
            if(arr[mid]==target){
                return mid;//can be changed to high=mid if we don't want to include target
            }else if(arr[mid]>target){
                high=mid;
            }else {
                low = mid;
            }
        }
        return low;
    }

    static int upperBound(int[] arr, int low, int high, int target){
        int ans=lowerBound(arr,low,high,target);
        return ans==arr.length-1?arr.length-1:ans+1;
    }

}
