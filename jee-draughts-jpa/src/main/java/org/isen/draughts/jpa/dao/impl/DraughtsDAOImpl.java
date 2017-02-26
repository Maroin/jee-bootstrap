package org.isen.draughts.jpa.dao.impl;

import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;
import org.isen.draughts.jpa.pojo.DraughtsImpl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 * Created by maroin on 22/01/17.
 */
public class DraughtsDAOImpl implements DraughtsDAO {

    @Inject
    EntityManager em;

    @Inject
    UserTransaction ut;

    public DraughtsAdapter createNewGame(){

        DraughtsImpl game = new DraughtsImpl();

        return new DraughtsAdapter(this);
    };

    public DraughtsAdapter loadFromToken(String token) {
        DraughtsImpl game = (DraughtsImpl) em
                .createQuery("SELECT g FROM DraughtsGame g WHERE g.id = :token")
                .setParameter("token", token).getSingleResult();

        return new DraughtsAdapter(this);
    }
}
