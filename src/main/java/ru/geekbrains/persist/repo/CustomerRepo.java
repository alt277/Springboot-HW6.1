package ru.geekbrains.persist.repo;


import org.springframework.stereotype.Repository;
import ru.geekbrains.persist.entity.Customer;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CustomerRepo {

    @PersistenceContext
    private EntityManager  em;
    public void update(Integer id, String firstName,String familyName) {
        em.createQuery("update Customer c set c.firstName =:firstName ,c.familyName =:familyName   where c.id=: id");
    }

}
