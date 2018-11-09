package hu.bme.aut.adatvez.webshop.dao;

import hu.bme.aut.adatvez.webshop.model.Termek;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TermekRepositoryImpl implements TermekRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Termek> findAllThatOrderedAtLeastTwice() {
        return entityManager
                .createQuery(" select t from Termek t where t.megrendelestetels.size >= 2", Termek.class).getResultList();
    }

    @Override
    public void epitoElemekPluszTizSzazalek() {

    }
}
