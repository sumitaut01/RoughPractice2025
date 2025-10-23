package basics.accesstypes.package2;

import basics.accesstypes.package1.R1_Class;

public class R1_ClassNew {


    public static void main(String[] args) {

        R1_Class c=new R1_Class();
        System.out.println(c.data); //public field //10
      //  System.out.println(c.data2); //default field   //data2' is not public in 'basics.accesstypes.package1.R1_Class'. Cannot be accessed from outside package
    }
}
