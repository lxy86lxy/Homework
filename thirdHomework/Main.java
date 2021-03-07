package thirdHomework;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Scanner;

public class Main {
    public Scanner put;
    Bookgather<Book> book=new Bookgather<>();//存入图书对象
    Bookgather<Integer> count=new Bookgather<>();//存入图书数量
    public Main() {
        put = new Scanner(System.in);
    }

    public void init() {
        Book book1 = new Book("三国演义", 01, "罗贯中");
        Book book2 = new Book("《偷影子的人》", 02, "马克·李维");
        Book book3 = new Book("《肖申克的救赎》", 03, "施蒂芬·埃德温·金");
        Book book4 = new Book("《小王子》",04,"安托万·德·圣-埃克苏佩里");
        Book book5 = new Book("《Java开发实战经典》",05,"李兴华");
        Book book6 = new Book("《Android编程权威指南》",06,"王明发");

        book.addBook(book1);
        count.addBook(1);
        book.addBook(book2);
        count.addBook(5);
        book.addBook(book3);
        count.addBook(3);
        book.addBook(book4);
        count.addBook(7);
        book.addBook(book5);
        count.addBook(9);
        book.addBook(book6);
        count.addBook(10);

    }

    public void menu() {//界面选择
        System.out.println("-------欢迎进入星星图书管理系统--------");
        System.out.println("请根据提示选择:");
        System.out.println("1.增加图书\t\t2.删除图书\t\t3.借阅图书\n4.归还图书\t\t5.查找图书\t\t6.书籍目录\t\t\n" + "0.退出系统");
        int a = put.nextInt();

        switch (a) {

            case 1:
                add();
                break;
            case 2:
                delete();
                break;
            case 3:
                checkOut();
                break;
            case 4:
                returnBook();
                break;
            case 5:
                findBook();
                break;
            case 6:
                showBook();
                break;
            case 0:
                System.exit(0);
            default:
        }
    }

    public Book fun(){
        String name, author;
        int id;
        System.out.println("请输入图书的书名，序号，作者");
        name = put.next();
        id = put.nextInt();
        author= put.next();
        Book fun = new Book(name, id, author);
        return fun;
    }


    public  void checkOut() {
        Book check = fun();
        int in = book.find(check);
        int m = count.get(in);
        if (m>0) {
            System.out.println(check.getName()+"成功借出");
            count.set(in, m - 1);
        }else{
            System.out.println(check.getName()+"目前没有剩余本数");
        }
    }

    public void findBook(){
        Book find=fun();
        if (book.findBook(find)){
            System.out.println(find.getName()+"成功找到！");
        }else {
            System.out.println("查找失败！");
        }
    }


    public  void delete() {
        Book delete1 =fun();
        int in=book.find(delete1);
        book.deleteBook(delete1);

        count.lateBook(in);
    }


    public void add() {//增加
      Book add=fun();
      System.out.println("存入的数量:");
        int m = put.nextInt();
      if (!book.findBook(add)) {
          book.addBook(add);
          count.addBook(m);
      }else{
          int index=book.find(add);
          count.addI(index,m);
      }
    }

    public void returnBook() {//归还图书
        Book re=fun();
        int in=book.find(re);
        int m=count.get(in);
        count.set(in,m+1);
    }

    public void showBook() {//输出图书
        for (int i = 0; i < book.size(); i++) {
            Book x=book.get(i);
            Integer y=count.get(i);
                if (y>0) {
                    System.out.println("名称：" + x.getName() +
                            "\t\t\t序列号：" + x.getId() + "\t\t作者：" + x.getAuthor() + "\t\t状态：在馆内" + "\t\t剩余:" + y);
                }
                else{
                    System.out.println("名称：" + x.getName() +
                            "\t\t\t序列号：" + x.getId() + "\t\t作者：" + x.getAuthor() +"次" + "\t\t状态：已借出"+"\t\t剩余: 0");
            }
        }
    }
}
