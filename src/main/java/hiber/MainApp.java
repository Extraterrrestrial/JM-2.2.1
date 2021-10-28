package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      Car car = new Car(5,"BMW");
      userService.add(new User("User5", "Lastname5", "user5@gmail.ru",car));
      userService.add(new User("User6", "Lastname6", "user6@gmail.ru",new Car(5,"Chevrolet")));
      userService.add(new User("User7", "Lastname7", "user7@gmail.ru",new Car(8,"KIA")));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car = " + user.getCar().getModel());
         }

         System.out.println();
      }
      userService.getUserOwnsCar(5, "BMW");
      context.close();
   }
}
