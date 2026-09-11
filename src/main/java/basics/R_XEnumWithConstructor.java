package basics;

public class R_XEnumWithConstructor {

    public static void main(String[] args) {
        Personnel personel= Personnel.IT;
        System.out.println(personel.getName());
        System.out.println(personel.getRole());
    }
}


enum Personnel {

    IT("Sumit","Manager"),
    CS("Amit","Architect");
    String name,role;

    Personnel(String name, String role){
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
