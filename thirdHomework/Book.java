package thirdHomework;

public class Book {
    private String name;//书名
    private int id;//序列号
    private String author;//作者

    public Book(String name, int id, String author) {//构造函数
        this.name = name;
        this.id = id;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }
    public boolean equals(Object o){
        if (o==null){
            return true;
        }
        Book b=(Book)o;
        if (this.name.equals(b.name)&&this.id==b.id&&this.author.equals(b.author)){
            return true;
        }else {
            return false;
        }
    }
    public int hashCode(){
        return this.name.hashCode()*this.id;
    }
}
