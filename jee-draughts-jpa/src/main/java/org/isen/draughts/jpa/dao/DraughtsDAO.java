package org.isen.draughts.jpa.dao;

import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.pojo.DraughtsGame;

import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by charles on 26/02/17.
 */

@SessionScoped
public interface DraughtsDAO {

    DraughtsAdapter createNewGame();

    DraughtsAdapter loadFromToken(String token);

    List<Draughts> getGames();

    void saveEntry(DraughtsGame sentry);

    void removeEntry(DraughtsGame entry);
}
