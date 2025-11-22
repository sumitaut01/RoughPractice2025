package basics;

public class R6_ConstructorInhertingClasses extends R5_ConstructorOverloading  {
    int year;
    R6_ConstructorInhertingClasses(){
        System.out.println("Default Constructor of Child");
    }

    //calling parameterized constructor from parent
    R6_ConstructorInhertingClasses(int year){
        super(23,"parent");
        this.year=year;
        System.out.println("Parameter Constructor of Child");
    }


    public static void main(String[] args) {
        R6_ConstructorInhertingClasses obj1=new R6_ConstructorInhertingClasses();
//        This is default Constructor
//        Default Constructor of Child

        R6_ConstructorInhertingClasses obj2=new R6_ConstructorInhertingClasses(30);
        //in super( some parameter)
//        using parametrized constructor
//        Parameter Constructor of Child

    }
}
