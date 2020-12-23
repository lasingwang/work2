public class ArrayDeque<T> {
    T [] array;
    int size;
    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
    }
    public void resize(int i) {
        T[] temp = (T[]) new Object[i];
        System.arraycopy(array,0,temp,0,size);
        array = temp;
    }

    public void addFirst(T i){
       if (size == array.length) {
           resize(size+1);
       }
       System.arraycopy(array,0,array,1,size);
       array[0] = i;
       size +=1;
    }

    public void addLast(T i) {
        if (size == array.length) {
            resize(size+1);
        }
        array[size] = i;
        size += 1;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
            System.out.print(" ");
        }
    }

    public T removeFirst() {
        System.arraycopy(array,1,array,0,size-1);
        T temp = array[0];
        array[size-1] = null;
        size -= 1;
        return temp;
    }

    public T removeLast() {
        T temp = array[size-1];
        array[size-1] = null;
        size -= 1 ;
        return temp;
    }

    public T get (int index) {
        return array[index];
    }

   /* public static void main(String[] args) {
        ArrayDeque<Integer> ss = new ArrayDeque<>();
        ss.addLast(1);
        ss.addFirst(0);
        ss.addLast(2);
        ss.removeLast();
        ss.printDeque();
        System.out.print(ss.get(2));
    }*/
}
