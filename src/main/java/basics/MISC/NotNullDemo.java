package basics.MISC;

import org.jetbrains.annotations.NotNull;

public class NotNullDemo {
    @NotNull
    private String name;

    public NotNullDemo(@NotNull String name){
        this.name=name;
    }


    public static void main(String[] args) {
        //its a warning from intellij only. Compilation will still happen
        NotNullDemo u=new NotNullDemo(null);//Parameter 1 to this constructor is marked "@NotNull" but null could be passed.


        NotNullDemo u2=new NotNullDemo("Sumit");
        u2.name=null;//again we will get just warning. No compilation error


    }
}