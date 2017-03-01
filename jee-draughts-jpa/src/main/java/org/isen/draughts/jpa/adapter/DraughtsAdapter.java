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
import java.util.List;

/**
 * Created by maroin on 22/01/17.
 */
public class DraughtsAdapter implements Draughts{


    public Draughts getCoreGame() {
        return coreGame;
    }

    private Draughts coreGame;

    private List<Point> allowedMoves = new ArrayList<>();

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

        System.out.println("ctor");
        for (DraughtsMoveImpl turn : game.getMoves()) {

            System.out.println("Turn");

            System.out.println(new Point(turn.getOrigineX(),turn.getOrigineY()));

            System.out.println(new Point(turn.getDestX(),turn.getDestY()));

            System.out.println(turn.getPlayer());

            this.coreGame.play(new Point(turn.getOrigineX(),turn.getOrigineY()),
                    new Point(turn.getDestX(),turn.getDestY())
                    ,Player.valueOf(turn.getPlayer()));
        }
        prePlay(game.getTryX(),game.getTryY());

    }


    private void switchTurn() {
        game.setCurrentTurn(game.getCurrentTurn() == Player.BLACK ? Player.WHITE
                : Player.BLACK);
        prePlay(-1,-1);

    }
    public void prePlay(int x,int y) {
        game.setTryX(x);
        game.setTryY(y);
        if(x>0 && y>0)
        allowedMoves = coreGame.getAllowedMoves(new Point(x,y),getCurrentTurn());
        this.dao.saveEntry(this.game);

    }

    @Override
    public void initEmptyGrid() {

    }

    @Override
    public void play(Point point, Point point1, Player colour) {

        System.out.println("ok");
        System.out.println(point.toString() + point1.toString() +colour);
        coreGame.play(point,point1,colour);

        System.out.println("ok");
        this.game.getMoves().add(new DraughtsMoveImpl(colour,point,point1));

        System.out.println("ok");
        switchTurn();

        System.out.println("ok");

        dao.saveEntry(game);

        System.out.println("ok");

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
    public Player getWinner() {
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
        return this.coreGame.getColumnsNumber();
    }

    @Override
    public int getRowsNumber() {
        return this.coreGame.getRowsNumber();
    }
    public String getToken() {
        return game.getToken();
    }

    public Player getCurrentTurn() {
        return game.getCurrentTurn();
    }

    public List<Point> getAllowedMoves() {
        return allowedMoves;
    }

    public void setAllowedMoves(List<Point> allowedMoves) {
        this.allowedMoves = allowedMoves;
    }
}



