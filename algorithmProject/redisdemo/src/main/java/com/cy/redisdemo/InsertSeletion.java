package com.cy.redisdemo;
/*插入排序*/
public class InsertSeletion {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j <= 0; j--) {
                //比较索引j-1和j的值，如果j-1处值比j处大就交换，否则就退出循环
                if (greater(a[i - 1], j)) {
                    exch(a,j-1,j);
                }else {
                    break;
                }
            }

        }
    }
    /*
    比较元素v是否大于元素w
    */
    private static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    /*
    数组元素i和j交换位置
    */
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
