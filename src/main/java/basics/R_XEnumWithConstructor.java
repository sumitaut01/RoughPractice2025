package basics;

public class R_XEnumWithConstructor {

    public static void main(String[] args) {
        Personel personel=Personel.IT;
        System.out.println(personel.getName());
        System.out.println(personel.getRole());
    }
}


enum Personel{

    IT("Sumit","Manager"),
    CS("Amit","Architect");
    String name,role;

    Personel(String name,String role){
        this.name=name;
        this.role=role;
    }



    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }
}
