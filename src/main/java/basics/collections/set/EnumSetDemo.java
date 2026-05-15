package basics.collections.set;

import java.util.EnumSet;

public class EnumSetDemo {

    public static void main(String[] args) {


        enum Permission {
            READ, WRITE, EXECUTE
        }

        EnumSet<Permission> userPerms = EnumSet.of(Permission.READ, Permission.WRITE);

        if (userPerms.contains(Permission.WRITE)) {
            System.out.println("User can write");
        }
    }

}

