package com.sda.softwaretestingadvanced.services.implementations;

import com.sda.softwaretestingadvanced.exceptions.ServiceUnavailableException;
import com.sda.softwaretestingadvanced.models.User;
import com.sda.softwaretestingadvanced.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of User Service
 *
 * @author Ott Pikk
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User getUserForRemoteServer() throws ServiceUnavailableException {
        try {
            ResponseEntity<User> userResponseEntity = restTemplate.getForEntity("https://www.google.com/user", User.class);
            return userResponseEntity.getBody();
        } catch (HttpServerErrorException httpServerErrorException) {
            throw new ServiceUnavailableException("Server unavailable!");
        }
    }
}
