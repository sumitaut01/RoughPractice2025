package basics.RoughAll;

public class RoughWork {

    public static void main(String[] args) {

        //Holding Interface Reference
        myWorker worker=new WokerImplementor();
        worker.worker1();
        worker.worker2();


        ///new
        new WokerImplementor().worker1();
        new WokerImplementor().worker1();


    }
}



interface  myWorker{

 void worker1();
   void worker2();
}


class WokerImplementor implements  myWorker{


    @Override
    public void worker1() {
        System.out.println("Worker 1 called");
    }

    @Override
    public void worker2() {
        System.out.println("Worker 2 called");
    }


}