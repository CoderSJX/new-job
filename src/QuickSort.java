public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        int[] results = quickSort(arr, 0, arr.length - 1);
        for (int result : results) {
            System.out.println(result);
        }
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if(left>=right)return arr;

        int partition=partition(arr,left,right);
        quickSort(arr,left,partition-1);
        quickSort(arr,partition+1,right);
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int lo=left,hi=right;
        int v=arr[left];
        int i=lo,j=hi+1;

        while(i<=j){
            while(arr[++i]<v&&i<hi);
            while(arr[--j]>v&&j>lo);
            if(i>=j)break;
            swap(arr,i,j);
        }
        swap(arr,left,j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


}
