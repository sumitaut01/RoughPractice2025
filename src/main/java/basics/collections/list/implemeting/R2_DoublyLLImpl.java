package basics.collections.list.implemeting;

public class R2_DoublyLLImpl {
    public static void main(String[] args) {

    }
}


//BluePrint
class DoublyNode {
    int data;
    DoublyNode prev, next;

    DoublyNode(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
