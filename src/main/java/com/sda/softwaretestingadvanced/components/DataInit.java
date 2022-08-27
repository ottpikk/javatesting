package com.sda.softwaretestingadvanced.components;

import com.sda.softwaretestingadvanced.exceptions.UserValidationException;
import com.sda.softwaretestingadvanced.models.User;
import com.sda.softwaretestingadvanced.models.UserType;
import com.sda.softwaretestingadvanced.utils.UserValidator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * To initialize data
 *
 * @author Ott Pikk
 */
@Component
public class DataInit {
    @PostConstruct
    public void initData() {
        User user = new User();
        user.setFirstName("Ott");
        user.setLastName("Pikk");
        user.setPassword("123456");
        user.setUserType(UserType.STANDARD);

        UserValidator userValidator = new UserValidator();

        try {
            if (userValidator.isAdmin(user)) {
                System.out.printf("User: %s is an Admin user", user.getFirstName());
            }
        } catch (UserValidationException userValidationException) {
            System.out.println(userValidationException.getLocalizedMessage());
        }
    }

}
