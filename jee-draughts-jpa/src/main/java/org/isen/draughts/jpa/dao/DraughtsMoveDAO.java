package org.isen.draughts.jpa.dao;

import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtsMove;

import java.awt.Point;
import java.util.List;

/**
 * Created by charles on 26/02/17.
 */
public interface DraughtsMoveDAO {
    DraughtsMove createEntry(Player player, Point origine,Point dest);

    List<DraughtsMove> getBlogEntries(Long gameId);

    void saveEntry(DraughtsMove entry);

    void removeEntry(DraughtsMove entry);
}
