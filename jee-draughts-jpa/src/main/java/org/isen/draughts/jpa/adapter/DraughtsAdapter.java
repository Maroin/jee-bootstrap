package org.isen.draughts.jpa.adapter;


import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtCell;
import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.core.pojo.DraughtsImpl;
import org.isen.draughts.jpa.dao.impl.DraughtsDAOImpl;
import org.isen.draughts.jpa.pojo.DraughtsGame;
import org.isen.draughts.jpa.pojo.DraughtsMoveImpl;

import java.awt.*;
import java.util.*;

/**
 * Created by maroin on 22/01/17.
 */
public class DraughtsAdapter implements Draughts{


    public Draughts getCoreGame() {
        return coreGame;
    }

    private Draughts coreGame;

    public DraughtsGame getGame() {
        return game;
    }

    public void setGame(DraughtsGame game) {
        this.game = game;
    }

    private DraughtsGame game;

    private DraughtsDAOImpl dao;

    public DraughtsAdapter(DraughtsDAOImpl dao, DraughtsGame game) {
        this.dao = dao;
        this.game = game;
        this.coreGame = new DraughtsImpl();

        for (DraughtsMoveImpl turn : game.getMoves()) {
            this.coreGame.play(turn.getOrigine(), turn.getDest(),turn.getPlayer());
        }

    }


    private void switchTurn() {
     //   game.setCurrentTurn(game.getCurrentTurn() == ChipColour.RED ? ChipColour.YELLOW
     //           : ChipColour.RED);

    }

    @Override
    public void initEmptyGrid() {

    }

    @Override
    public void play(Point point, Point point1, Player colour) {
        coreGame.play(point,point1,colour);
        this.game.getMoves().add(new DraughtsMoveImpl(point,point1,colour));
        switchTurn();

        dao.saveEntry(game);

    }

    @Override
    public ArrayList<Point> checkAround(Point point) {
        return this.coreGame.checkAround(point);
    }

    @Override
    public boolean getColour() {
        return this.coreGame.getColour();
    }

    @Override
    public java.util.List<Point> getAllowedMoves(Point origin, Player player) {
        return null;
    }

    @Override
    public ArrayList<Player> getBoard() {
        return this.coreGame.getBoard();
    }

    @Override
    public DraughtCell getDraughtCell(Point point) {
        return this.coreGame.getDraughtCell(point);
    }

    @Override
    public int getColumnsNumber() {
        return 0;
    }

    @Override
    public int getRowsNumber() {
        return 0;
    }
}



