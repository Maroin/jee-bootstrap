package org.isen.draughts.jpa.dao.impl;

import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;
import org.isen.draughts.jpa.pojo.DraughtsGame;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
    public DraughtsAdapter createNewGame(String player1, String player2){

        return new DraughtsAdapter(this,new DraughtsGame());
    };


    public DraughtsAdapter loadFromToken(String token) {
        DraughtsGame game = (DraughtsGame) em
                .createQuery("SELECT g FROM DraughtsGame g WHERE g.id = :token")
                .setParameter("token", token).getSingleResult();

        return  null;
    }

    @Override
    @PostConstruct
    public List<Draughts> getGames() {
        return em.createNamedQuery(DraughtsGame.ALL_GAME_ENTRIES)
                .getResultList();
    }

    @Override
    @PostConstruct
    public void saveEntry(DraughtsGame entry) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entry);
        tx.commit();
    }

    @Override
    public void removeEntry(DraughtsGame entry) {

    }
}
