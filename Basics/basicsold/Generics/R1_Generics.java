package basicsold.Generics;

public class R1_Generics {

    public static void main(String[] args) {

        Box<String> bStr=new Box<>();
        bStr.setItem("stringBox");
        System.out.println(bStr.get());


        Box<Integer> integer=new Box<>();
        integer.setItem(5);
        System.out.println(integer.get());


        //double parameter
        Demo<String,Integer> demo=new Demo<>();
        demo.setFirst("sumit");;
        demo.setSecond(2);

        System.out.println(demo.getFirst());
        System.out.println(demo.getSecond());
    }

}

class Box<T>{

  private T item;

  public T get(){
      return item;
  }

  public void setItem(T itemType){
      this.item=itemType;
  }

}


class Demo<T,V>{
private T first;
    private V second;

    public void setFirst(T first){
        this.first=first;
    }
    public T getFirst(){
        return first;
    }

    public void setSecond(V second){
        this.second=second;
    }
    public V getSecond(){
        return second;
    }
}
