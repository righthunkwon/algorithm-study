package baek;

public class Pro_2448_별찍기 {
    public static void main(String[] args) {
        //triangle();
    }

    public static void triangle(int N) {
        if(N==1) {
        printStar(3, 1);
        printStar(0, 2);}
    }

    public static void printStar(int su, int count) {
        int cnt=count;
        while (cnt > 0) {
            printSpace(su + 2);
            System.out.print("*");
            printSpace(su + 3);
            cnt--;
        }
        System.out.println();
        cnt=count;
        while (cnt > 0) {
            printSpace(su + 1);
            System.out.print("* *");
            printSpace(su + 2);
            cnt--;
        }
        System.out.println();
         cnt=count;
        while (cnt > 0) {
            printSpace(su);
            System.out.print("*****");
            printSpace(su+1);
            cnt--;
        }
        System.out.println();

    }

    public static void printSpace(int su) {
        for (int i = 0; i < su; i++) {
            System.out.print(" ");
        }
    }

}

