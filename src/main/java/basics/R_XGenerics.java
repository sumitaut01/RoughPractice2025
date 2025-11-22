package basics;

public class R_XGenerics {

    public static void main(String[] args) {

        Gen<String> st=new Gen<>();
        st.setData("sumit");
        System.out.println(st.getData());//sumit


        Gen<Integer> sts=new Gen<>();
        sts.setData(4);
        System.out.println(sts.getData());//4

    }

}


class Gen<T>{

    private  T data;


    public void setData(T data){
        this.data=data;
    }
    public T getData(){
       return data;
    }

}
