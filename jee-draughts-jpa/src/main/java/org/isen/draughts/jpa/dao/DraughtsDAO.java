package org.isen.draughts.jpa.dao;

import org.isen.draughts.jpa.adapter.DraughtsAdapter;

/**
 * Created by charles on 26/02/17.
 */
public interface DraughtsDAO {

    DraughtsAdapter createNewGame();

    DraughtsAdapter loadFromToken(String token);
}
