package homework;

import java.util.*;

public class FirstHomework {
    public static void main(String[] args) {
        Scanner put = new Scanner(System.in);
        System.out.println("请输入一串数字");
        int z[] = read();
        System.out.println("请输入另一串数字");
        int a[] = read();
        System.out.println("合并过后的结果");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < z.length; i++) {
            list.add(z[i]);
        }
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        Collections.sort(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return 0;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            int temp = (int) list.get(i);
            System.out.println(temp);
        }
    }

    public static void fun(int x[]) {
        int k, i, temp;
        for (i = 0; i < x.length - 1; i++) {
            k = i;
            for (int j = i + 1; j < x.length; j++) {
                if (x[j] < x[k]) {
                    k = j;
                }
            }
            if (i != k) {
                temp = x[i];
                x[i] = x[k];
                x[k] = temp;
            }
        }
    }

    public static int[] read() {
        Scanner put = new Scanner(System.in);
        String shu = put.next().toString();
        String[] str = shu.split(",");
        int[] x = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            x[i] = Integer.parseInt(str[i]);
        }
        fun(x);
        System.out.println("排序后结果");
        for (int y : x) {
            System.out.println(y);
        }
        return x;
    }
}