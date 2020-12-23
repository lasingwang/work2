public class LinkedListDeque<T> {
    public class itemNode {
         public  itemNode head;
         public T item;
         public itemNode next;
         private itemNode(itemNode h, T i, itemNode n) {
             head = h;
             item = i;
             next = n;
         }
    }

    public itemNode sentBox;
    public int size = 0;
    public LinkedListDeque(T i) {
        sentBox = new itemNode(null,i, null);
        sentBox.next = new itemNode(sentBox,i, sentBox);
        sentBox.head = sentBox.next;
        size+=1;
    }
    public LinkedListDeque() {
        sentBox = new itemNode(null, null, null);
        sentBox.head = sentBox;
        sentBox.next = sentBox;
        size = 0;
    }
    public void addLast (T i) {
        itemNode Temp = new itemNode(sentBox.head,i,sentBox);
        sentBox.head.next =Temp;
        sentBox.head = Temp;
        size +=1;
    }
    public void addFirst (T i) {
        itemNode Temp = new itemNode(sentBox, i, sentBox.next);
        sentBox.next.head = Temp;
        sentBox.next =Temp;
        size +=1;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public T removeFirst() {
        T i = sentBox.next.item;
        sentBox.next = sentBox.next.next;
        sentBox.next.head = sentBox;
        size -= 1;
        return i;
    }
    public  T removeLast() {
        T i = sentBox.head.item;
        sentBox.head = sentBox.head.head;
        sentBox.head.next = sentBox;
        size -= 1;
        return i;
    }
    public T get (int index) {
        itemNode ssemp = sentBox;
        for (int i = 0; i <= index; i++) {
           ssemp = ssemp.next; //犯了错为什么？？？
        }
        return ssemp.item;
    }
    public T getRecursive(int index) {
        return gotR(index).item;
    }
    public itemNode gotR(int index) {
        itemNode temp = sentBox;
        if (index == 0) {
            return temp.next;
        }
        return gotR(index-1).next;
    }
    public void printDeque() {
        for (int j = 0; j < size; j++) {
            System.out.print(get(j));
            System.out.print(" ");
        }
    }

    /*public static void main(String[] args) {
        LinkedListDeque<String> ss = new LinkedListDeque<>("1st");
        ss.addLast("2nd");
        ss.addLast("3rd");
        ss.addFirst("new1st");
        ss.removeFirst();
        ss.removeFirst();
        ss.printDeque();
        System.out.println(ss.getRecursive(0));
        /*LinkedListDeque bb = new LinkedListDeque();
        if (bb != null) {
            System.out.println("FEIkong");
        }--*--

    }*/
}
//领悟拓扑图