package com.cy.redisdemo;

public class TestComparable {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setUsername("zhan");
        s1.setAge(20);

        Student s2 = new Student();
        s2.setUsername("lishi");
        s2.setAge(30);
        Comparable max = getMax(s1, s2);
        System.out.println(max);


    }

    public static Comparable getMax(Comparable c1,Comparable c2){
        int result = c1.compareTo(c2);

        if(result>0){
            return c1;
        }else {
            return c2;
        }
    }

}
