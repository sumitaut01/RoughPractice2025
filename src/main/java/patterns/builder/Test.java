package patterns.builder;

public class Test {

    public static void main(String[] args) {

        User user = new User.Builder()
                .name("Sumit")
                .city("Pune")
                .email("sumit@test.com")
                .build();


        System.out.println(user);//User(name=Sumit, city=Pune, email=sumit@test.com)

    }
}
