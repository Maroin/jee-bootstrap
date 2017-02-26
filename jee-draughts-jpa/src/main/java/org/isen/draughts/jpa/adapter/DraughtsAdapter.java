package org.isen.draughts.jpa.adapter;


import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.jpa.dao.impl.DraughtsDAOImpl;
import org.isen.draughts.jpa.pojo.DraughtsImpl;

/**
 * Created by maroin on 22/01/17.
 */
public class DraughtsAdapter {


    private Draughts coreGame;

    private DraughtsDAOImpl dao;


    public DraughtsAdapter(DraughtsDAOImpl draughtsDAO) {
        this.dao = dao;
        this.coreGame = new DraughtsImpl();

    }


/*
    @Override
    public void play(Point point, Point point1, Player colour) {

    }

    @Override
    public ArrayList<Point> checkAround(Point point) {
        return (new ArrayList<>());
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

*/

}
