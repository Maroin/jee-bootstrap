package org.isen.draughts.jpa.dao.impl;

import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.core.pojo.DraughtsMove;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;
import org.isen.draughts.jpa.pojo.DraughtsImpl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created by maroin on 22/01/17.
 */
public class DraughtsDAOImpl implements DraughtsDAO {

    @Inject
    EntityManager em;

    //@Inject
    //UserTransaction ut;

    @Override
    public Draughts createNewGame(String player1,String player2){

        DraughtsImpl game = new DraughtsImpl(player1, player2);

        return game;
    };


    public DraughtsAdapter loadFromToken(String token) {
        DraughtsImpl game = (DraughtsImpl) em
                .createQuery("SELECT g FROM DraughtsGame g WHERE g.id = :token")
                .setParameter("token", token).getSingleResult();

        return new DraughtsAdapter(this);
    }

    @Override
    public List<Draughts> getGames() {
        return em.createNamedQuery(DraughtsImpl.ALL_GAME_ENTRIES)
                .getResultList();
    }

    @Override
    public void saveEntry(Draughts entry) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entry);
        tx.commit();
    }

    @Override
    public void removeEntry(Draughts entry) {

    }
}
