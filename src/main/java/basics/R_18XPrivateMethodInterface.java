package basics;

public class R_18XPrivateMethodInterface implements  Random{

    public static void main(String[] args) {

        R_18XPrivateMethodInterface r1=new R_18XPrivateMethodInterface();

        System.out.println(r1.sum(2, 3));
        System.out.println(r1.mul(2, 3));


       Random r2= new R_18XPrivateMethodInterface();
        System.out.println(r2.sum(2, 3));

        //-----------Separating-------------
        //5
        //-----------Separating-------------
        //6
        //-----------Separating-------------
        //5

    }



}


interface  Random{

    //Acts more like a helper method within interface
    private void decorate(){
        System.out.println("-----------Separating-------------");
    }

    default int sum(int a,int b){
        decorate();
        return a+b;
    }

    default int mul(int a,int b){
        decorate();
        return a*b;
    }


}
