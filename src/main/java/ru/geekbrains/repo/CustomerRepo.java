package ru.geekbrains.repo;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerRepo {

    @PersistenceContext
    private EntityManager em;

    public void update(Integer id, String firstName, String familyName) {
        em.createQuery("update Customer c set c.firstName =:firstName ,c.familyName =:familyName   where c.id=: id");
    }

}
