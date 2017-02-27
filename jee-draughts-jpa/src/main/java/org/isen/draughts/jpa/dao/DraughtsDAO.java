package org.isen.draughts.jpa.dao;

import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.core.pojo.DraughtsMove;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;

import java.util.List;

/**
 * Created by charles on 26/02/17.
 */
public interface DraughtsDAO {

    Draughts createNewGame(String player1,String player2);

    DraughtsAdapter loadFromToken(String token);

    List<Draughts> getGames();

    void saveEntry(Draughts sentry);

    void removeEntry(Draughts entry);
}
