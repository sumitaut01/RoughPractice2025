package basics.apimanager_model.repository;

import basics.apimanager_model.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
User.java
   ↓
creates User objects
   ↓
UserRepository
   ↓
stores User objects in List

 */

public class UserRepository {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User findById(int id) {

        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }



    public boolean deleteById(int id) {

        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }


    public boolean updateUser(int id, String name, String email, int age, String role) {

        User user = findById(id);

        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            user.setAge(age);
            user.setRole(role);

            return true;
        }

        return false;
    }

    public List<User> findByRole(String role) {

        List<User> result = new ArrayList<>();

        for (User user : users) {
            if (user.getRole().equalsIgnoreCase(role)) {
                result.add(user);
            }
        }

        return result;
    }

    public List<User> findByRoleByStream(String role) {

        return users.stream()
                .filter(user -> user.getRole().equalsIgnoreCase(role))
                .toList();
    }


    public List<User> findByAge(int age) {

        return users.stream()
                .filter(user -> user.getAge() == age)
                .toList();
    }
}