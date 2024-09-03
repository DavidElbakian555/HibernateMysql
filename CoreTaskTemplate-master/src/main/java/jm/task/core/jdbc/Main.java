package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
            private static final UserService userService = new UserServiceImpl();

            private static final User user1 = new User("David", "Elbakian", (byte) 39);
            private static final User user2 = new User("Jim", "Carey", (byte) 65);
            private static final User user3 = new User("John", "Wick", (byte) 59);
            private static final User user4 = new User("Leo", "DiCaprio", (byte) 46);


            public static void main(String[] args) {

                // 1 Создание таблицы User(ов)
                userService.createUsersTable();
                System.out.println("Создание таблицы User(ов)");

                // 2 Добавление 4 User(ов) в таблицу с данными на свой выбор.
                // После каждого добавления должен быть вывод в консоль
                // (User с именем – name добавлен в базу данных )
                userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
                System.out.println("User с user1 – name добавлен в базу данных ");

                userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
                System.out.println("User с user2 – name добавлен в базу данных ");

                userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
                System.out.println("User с user3 – name добавлен в базу данных ");

                userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
                System.out.println("User с user4 – name добавлен в базу данных ");

                // 3 Получение всех User из базы и вывод в консоль
                // ( должен быть переопределен toString в классе User)
                userService.getAllUsers();
                System.out.println(userService.getAllUsers().toString());

                // 4 Очистка таблицы User(ов)
                userService.cleanUsersTable();

                // 5 Удаление таблицы
                userService.dropUsersTable();



                UserDao userDao = new UserDaoHibernateImpl();
                userDao.createUsersTable();


                List<User> users = userDao.getAllUsers();
                users.forEach(user -> System.out.println(user.getName() + " " + user.getLastName()));

                userDao.cleanUsersTable();
                userDao.dropUsersTable();
            }
}


