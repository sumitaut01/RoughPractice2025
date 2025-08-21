package basics.collections.list.implemeting;

public class R1_SinglyListImpl {

    public static void main(String[] args) {
        SinglyBPImpl singlyBPImpl =new SinglyBPImpl();
        singlyBPImpl.insert(12);
        singlyBPImpl.insert(2);
        singlyBPImpl.insert(5);
        singlyBPImpl.insert(12);
        singlyBPImpl.insert(17);
        singlyBPImpl.print();
    }
}


//BluePrint
class SinglyBP{
    int data;
    SinglyBP next;

    public  SinglyBP(int data) {
        this.data = data;
        this.next=null;
    }
}


class SinglyBPImpl{
    SinglyBP head;
    public void insert(int data){
        SinglyBP newNode =new SinglyBP(data);
        if(head==null){
          head= newNode;
          return;
        }
        SinglyBP temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    public void print(){
        if(head==null){
            System.out.println("no data to print");
            return;
        }
        SinglyBP temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}


