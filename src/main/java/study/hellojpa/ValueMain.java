package study.hellojpa;

public class ValueMain {

    public static void main(String[] args) {

        int a = 10;
        int b = a;

         b = 20;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        b = 10;

        System.out.println("a == b : " + (a == b));
    }
}
