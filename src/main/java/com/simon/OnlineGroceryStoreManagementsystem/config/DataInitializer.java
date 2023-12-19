package com.simon.OnlineGroceryStoreManagementsystem.config;
import com.simon.OnlineGroceryStoreManagementsystem.dao.RoleDao;
import com.simon.OnlineGroceryStoreManagementsystem.model.Role;
import com.simon.OnlineGroceryStoreManagementsystem.model.User;
import com.simon.OnlineGroceryStoreManagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private UserService userService;
    private RoleDao roleDao;

    @Autowired
    public DataInitializer(UserService userService, RoleDao roleDao) {
        this.userService = userService;
        this.roleDao = roleDao;
    }

    @Override
    public void run(String... args) throws Exception {
        // Insert roles
        Role roleSeeker = new Role("ROLE_JOB_SEEKER");
        Role roleEmployer = new Role("ROLE_EMPLOYEER");
        Role roleOperation = new Role("ROLE_OPERATIONS_MANAGER");
        roleDao.save(roleSeeker);
        roleDao.save(roleEmployer);
        roleDao.save(roleOperation);

        // Insert users
        if (userService.findByUserName("kenny") == null) {
            User user1 = new User("Kenny", "Nyirumulinga", "kenntyfabrice8@gmail.com", "kenny", "$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K", "0782088965");
            user1.addRole(roleSeeker);
            userService.save(user1);
        }

        if (userService.findByUserName("willy") == null) {
            User user2 = new User("Hirwa", "Willy", "munezerowilly6@gmail.com", "willy", "$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K", "0782088900");
            user2.addRole(roleEmployer);
            user2.addRole(roleOperation);
            userService.save(user2);
        }

        if (userService.findByUserName("susan") == null) {
            User user3 = new User("Susan", "Adams", "susan@gmail.com", "susan", "$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K", "0782088911");
            user3.addRole(roleOperation);
            userService.save(user3);
        }
    }
}
