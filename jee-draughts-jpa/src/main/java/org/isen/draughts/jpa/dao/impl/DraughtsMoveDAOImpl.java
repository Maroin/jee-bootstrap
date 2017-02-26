package org.isen.draughts.jpa.dao.impl;

import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtsMove;
import org.isen.draughts.jpa.dao.DraughtsMoveDAO;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by charles on 26/02/17.
 */
public class DraughtsMoveDAOImpl implements DraughtsMoveDAO {
    @Override
    public DraughtsMove createEntry(Player player, Point origine, Point dest) {
        return null;
    }

    @Override
    public List<DraughtsMove> getBlogEntries(Long gameId) {
        return null;
    }

    @Override
    public void saveEntry(DraughtsMove entry) {

    }

    @Override
    public void removeEntry(DraughtsMove entry) {

    }
}
