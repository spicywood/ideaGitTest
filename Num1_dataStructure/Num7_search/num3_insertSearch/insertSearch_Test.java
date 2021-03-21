package Num1_dataStructure.Num7_search.num3_insertSearch;

public class insertSearch_Test {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        //System.out.println(Arrays.toString(arr));
        int index = insertValueSearch(arr, 0, arr.length - 1, 80);
        System.out.println(index);
    }

    public static int insertValueSearch(int[] arr,int left,int right,int findValue){
        if (left > right || findValue < arr[0] || findValue > arr[arr.length-1]){
            return -1;
        }

        int mid = left + (right - left) * (findValue - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if (findValue > midValue){
            insertValueSearch(arr,mid + 1,right,findValue);
        } else if (findValue < midValue){
            insertValueSearch(arr,left,mid - 1,findValue);
        } else {
            return mid;
        }
        return -1;
    }
}
