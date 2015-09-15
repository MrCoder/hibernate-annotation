package com.pdvision.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author SivaLabs
 *
 */

@Transactional
@Repository
public class UserRepository
{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Client> getAllUsers()
    {
        return this.hibernateTemplate.loadAll(Client.class);
    }

    public Integer createUser(Client client)
    {
        Client mergeClient = this.hibernateTemplate.merge(client);
        return mergeClient.getId();
    }
}