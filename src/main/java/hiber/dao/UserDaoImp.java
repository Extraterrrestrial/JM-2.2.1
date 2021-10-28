package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public User getUserOwnsCar(int series, String model) {
      Query query = sessionFactory.getCurrentSession()
              .createQuery("FROM User WHERE car.series = :series AND car.model = :model");
      query.setParameter("series",series);
      query.setParameter("model",model);
      return (User) query.getSingleResult();
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return sessionFactory.getCurrentSession().createQuery("from User").list();
   }

}
