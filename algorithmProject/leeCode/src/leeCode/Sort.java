package leeCode;

public class Sort {
    public static void insertSort(int[] array){
        int n = array.length;
        for (int i = 0; i < n; i++) {
            // 寻找元素 arr[i] 合适的插入位置
            for( int j = i ; j > 0 ; j -- )
                if( array[j] < array[j-1])
                    swap( array, j , j-1 );
//                else
//                    break;
        }
    }
    public static void maoPaoSort(int[] array){
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for( int j = 0 ; j < n-i-1 ; j++ )
                if( array[j] > array[j+1])
                    swap( array, j , j+1 );

        }
    }

    //核心代码---结束
    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{2,9,8,1,6,3};
        insertSort(ints);
        for (int i :ints){
            System.out.println(i);
        }

    }
}
