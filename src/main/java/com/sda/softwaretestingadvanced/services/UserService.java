package com.sda.softwaretestingadvanced.services;
import com.sda.softwaretestingadvanced.exceptions.ServiceUnavailableException;
import com.sda.softwaretestingadvanced.models.User;

/**
 * Service to handle user related operations
 */

public interface UserService {
    /**
     *
     *
     * @Author Ott Pikk
     */
    User getUserForRemoteServer() throws ServiceUnavailableException;
}
