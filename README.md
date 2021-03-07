# thridHomework

一、介绍
该代码实现的是一个文字图书管理系统，功能有：增加、删除、查找、借阅、归还、遍历、退出。
二、Bookgather泛型类，A为泛型接口
    T get(int n);  得到对应下标的元素
    void addBook(T t);  增加
    T addI(int n,T t);  增加对应位置元素
    void deleteBook(T t);  删除
    void clear();  清除
    T set(int n,T t);  设置修改对应位置元素
    int find(T t);  找到相等元素下标
    boolean findBook(T t); 判断是否存在t
三、语言，环境
java、IDEA
