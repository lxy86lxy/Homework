package thirdHomework;

interface A<T>{
    T get(int n);
    void addBook(T t);
    T addI(int n,T t);
    void deleteBook(T t);
    void clear();
    T set(int n,T t);
    int find(T t);
    boolean findBook(T t);
}
