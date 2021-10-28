package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getUserOwnsCar(int series, String model);
    List<User> listUsers();
}
