package basics;

import java.util.Date;

public class R_XAccess {
    int age;
    protected String name;
    private Date dob;

    private void methodOne(){
        System.out.println("private method");
    }

}


class R_XAccess_Child extends  R_XAccess{
    public void setData(){
        System.out.println(name);//coming from parent protected
        System.out.println(age);//from parent
        //methodone();//not accesible
    }
}
