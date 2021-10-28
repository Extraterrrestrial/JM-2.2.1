package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   User getUserOwnsCar(int series, String model);
   List<User> listUsers();
}
