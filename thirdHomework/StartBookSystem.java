package thirdHomework;

import java.util.Scanner;

public class StartBookSystem {
    public static void main(String[] args) {
        String n = null;
        Main manager = new Main();
        manager.init();
        do {//控制是否退出

            manager.menu();
            System.out.println("回主菜单？y(是)/其他(结束)");

            /* System.out.println("this is Main's Scanner");*/
            Scanner input = new Scanner(System.in);

            n = input.next();
        }while ("y".equalsIgnoreCase(n));
    }
}
