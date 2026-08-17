package basics.enums;

import java.util.EnumSet;

public class EnumSetWork {

    public static void main(String[] args) {

        enum Permission {
            READ,
            WRITE,
            DELETE
        }

        EnumSet<Permission> perms =
                EnumSet.of(Permission.READ, Permission.WRITE);

        System.out.println(perms);
    }
}
