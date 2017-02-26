package org.isen.draughts.jpa.dao.impl;

import com.google.inject.Inject;
import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtsMove;
import org.isen.draughts.jpa.dao.DraughtsMoveDAO;
import org.isen.draughts.jpa.pojo.DraughtsMoveImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by charles on 26/02/17.
 */
public class DraughtsMoveDAOImpl implements DraughtsMoveDAO {

    @Inject
    EntityManager em;

    @Override
    public DraughtsMove createEntry(Player player, Point origine, Point dest) {
        return new DraughtsMoveImpl(player,origine,dest);
    }

    @Override
    public List<DraughtsMove> getMoves(Long gameId) {
        return null;
    }

    @Override
    public void saveEntry(DraughtsMove entry) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entry);
        tx.commit();

    }

    @Override
    public void removeEntry(DraughtsMove entry) {
        //em.remove(entry);
    }
}
