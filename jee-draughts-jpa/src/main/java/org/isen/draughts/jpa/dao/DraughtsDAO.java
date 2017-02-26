package org.isen.draughts.jpa.dao;

import org.isen.draughts.jpa.adapter.DraughtsAdapter;

/**
 * Created by charles on 26/02/17.
 */
public interface DraughtsDAO {

    DraughtsAdapter createNewGame(String player1,String player2);

    DraughtsAdapter loadFromToken(String token);
}
