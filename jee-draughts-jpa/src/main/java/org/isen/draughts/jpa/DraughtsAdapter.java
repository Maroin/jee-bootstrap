package org.isen.draughts.jpa;

import org.isen.draughts.core.DraughtCell;
import org.isen.draughts.core.Draughts;
import org.isen.draughts.core.DraughtsImpl;
import org.isen.draughts.core.Player;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by maroin on 22/01/17.
 */
public class DraughtsAdapter implements Draughts {

    private Game game;

    private Draughts coreGame;

    private DraughtsDAO dao;


    public DraughtsAdapter(DraughtsDAO draughtsDAO, Game game) {
        this.dao = dao;
        this.game = game;
        this.coreGame = new DraughtsImpl();






    }


    @Override
    public void play(Point point, Point point1, Player colour) {

    }

    @Override
    public boolean getColour() {
        return false;
    }

    @Override
    public ArrayList<Player> getBoard() {
        return null;
    }

    @Override
    public DraughtCell getDraughtCell(Point point) {
        return null;
    }
}
