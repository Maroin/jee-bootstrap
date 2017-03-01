package org.isen.draughts.jpa.dao.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;
import org.isen.draughts.jpa.pojo.DraughtsGame;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created by maroin on 22/01/17.
 */
public class DraughtsDAOImpl implements DraughtsDAO {

    @Inject
    EntityManager em;

    @Inject
    UserTransaction ut;

    @Override
    public DraughtsAdapter createNewGame(){
        DraughtsGame game = new DraughtsGame();
        game.setToken(RandomStringUtils.randomAlphanumeric(10).toLowerCase());
        try {
            ut.begin();
            em.persist(game);
            ut.commit();

        } catch (NotSupportedException | SystemException | SecurityException
                | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException e) {
            return null;
        }
        return new DraughtsAdapter(this,game);
    };


    public DraughtsAdapter loadFromToken(String token) {
        DraughtsGame game = (DraughtsGame) em
                .createQuery("SELECT g FROM DraughtsGame g WHERE g.token = :token")
                .setParameter("token", token).getSingleResult();

        return new DraughtsAdapter(this, game);
    }

    @Override
    public List<Draughts> getGames() {
        return em.createQuery("SELECT * FROM DraughtsGame")
                .getResultList();
    }

    @Override
    public void saveEntry(DraughtsGame entry) {
        try {
            ut.begin();
            em.merge(entry);
            ut.commit();


        } catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();



        }
    }

    @Override
    public void removeEntry(DraughtsGame entry) {

    }
}
