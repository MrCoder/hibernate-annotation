package com.pdvision.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SivaLabs
 *
 */

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<Client> getAllUsers()
    {
        return this.userRepository.getAllUsers();
    }

    public Integer createUser(Client client)
    {
        return this.userRepository.createUser(client);
    }
}