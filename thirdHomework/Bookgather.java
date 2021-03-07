package thirdHomework;

public class Bookgather<E> implements A<E>{
    private Object[] array;
    private static final int len = 5;//长度
    private int size;//操作中数组的长度
    private int stratlen;//数组开辟的长度

    public Bookgather() {
        this.stratlen = len;
        array = new Object[stratlen];
    }

    public Bookgather(int stratlen) {//自定义开始的数组长度
        if (stratlen > 0) {
            this.stratlen = stratlen;
            array = new Object[stratlen];
        }
    }

    public int size() {
        return size;
    }

    @Override
    public E get(int indexOf) {//返回对应位置的值
        if (indexOf < 0 || indexOf >= size) {
            try {
                throw new Exception("i is abnormal");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return (E) array[indexOf];
    }

    @Override
    public void addBook(E t) {//增加元素
        if (size < stratlen) {
            array[size] = t;
        } else {
            Object[] a = new Object[stratlen * 3];
            for (int i = 0; i < size(); i++) {
                a[i] = array[i];
            }
            a[size] = t;
            stratlen = stratlen * 3;
            array = a;
        }
        size++;
    }

    @Override
    public E addI(int index, E t) {//自定义增加在某个位置
        E newObject = (E) array[index];
        if (index < 0 || index >= size) {
            try {
                throw new Exception("i is abnormal");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (size + 1 < stratlen) {
            int y = 0;
            for (int i = size - 1; i >= index; i--) {
                array[size - y] = array[i];
                y++;
            }
            array[index] = t;
            size++;
        } else {
            Object[] a = new Object[stratlen * 3];
            for (int i = 0; i < size(); i++) {
                a[i] = array[i];
            }
            stratlen = stratlen * 3;
            array = a;
            int y = 0;
            for (int i = size - 1; i >= index; i--) {
                array[size - y] = array[i];
                y++;
            }
            array[index] = t;
            size++;
        }
        return newObject;
    }

    @Override
    public void deleteBook(E t) {
        int x = find(t);
        if(x!=-1){
            lateBook(x);
        }
    }

    public void lateBook(int indexOf) {//删除元素
        if (indexOf < 0 || indexOf >= size) {
            try {
                throw new Exception("i is abnormal");
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            if (indexOf == size - 1) {
                array[indexOf] = null;
            } else {
                for (int i = indexOf; i < size; i++) {
                    array[i] = array[i + 1];

                }
                array[size - 1] = null;
            }
            size--;
        }
    }

    @Override
    public void clear() {//清空所有的元素
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public E set(int n, E t) {
        E a = (E) array[n];
        if (n < 0 || n >= size) {
            try {
                throw new Exception("i is abnormal");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        array[n]=t;
        return a;
    }

    @Override
    public int find(E t) {//查找该元素是否存在于数组中
        int j = -1;
        for (int i = 0; i < size; i++) {
            if (t.equals((E)array[i])) {
                j = i;
                System.out.println();
                break;
            }
        }
        return j;
    }

    @Override
    public boolean findBook(E t){//判断所导入对象是否存在于数组中
        for (int i = 0; i < size; i++) {
            if (t.equals((E)array[i])){
                return true;
            }
        }
        return false;
    }

}
