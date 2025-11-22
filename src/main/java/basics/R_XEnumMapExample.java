package basics;
import java.util.EnumMap;
import java.util.Map;

public class R_XEnumMapExample {

    enum UserRole {
        ADMIN,
        MODERATOR,
        MEMBER,
        GUEST
    }

    public static void main(String[] args) {
        // 1. Create an EnumMap
        // You must specify the enum class in the constructor.
        EnumMap<UserRole, String> roleDescriptions = new EnumMap<>(UserRole.class);

        // 2. Add key-value pairs using the put() method
        roleDescriptions.put(UserRole.ADMIN, "Full access to all features.");
        roleDescriptions.put(UserRole.MODERATOR, "Can manage user content.");
        roleDescriptions.put(UserRole.MEMBER, "Standard user privileges.");
        roleDescriptions.put(UserRole.GUEST, "Read-only access.");

        // 3. Access values using the get() method
        String adminDescription = roleDescriptions.get(UserRole.ADMIN);
        System.out.println("ADMIN role description: " + adminDescription);

        // 4. Iterate over the EnumMap
        // Notice the iteration order is the same as the enum declaration order.
        System.out.println("\nAll user roles and their descriptions:");
        for (Map.Entry<UserRole, String> entry : roleDescriptions.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

//ADMIN role description: Full access to all features.
//
//All user roles and their descriptions:
//ADMIN: Full access to all features.
//MODERATOR: Can manage user content.
//MEMBER: Standard user privileges.
//GUEST: Read-only access.