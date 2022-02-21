package leeCode;

public class Sort {
    public static void sort(int[] array){
        for(int i=1;i<array.length;i++){
            int j;
            int temp = array[i];
            for( j= i-1;j>0&&array[j] > temp;j--){
                array[j+1] = array[j];
            }
            array[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,3,8,5};
        sort(ints);
        for (int i :ints){
            System.out.println(i);
        }

    }
}
