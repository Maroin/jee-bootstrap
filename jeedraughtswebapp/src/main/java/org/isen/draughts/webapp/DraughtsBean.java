package org.isen.draughts.webapp;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.core.pojo.DraughtsMove;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;
import org.isen.draughts.webapp.wrappers.PlayeColourWrapper;

import static org.isen.draughts.core.enums.Player.WHITE;

@Named("game")
@RequestScoped
public class DraughtsBean implements Serializable {


    DraughtsAdapter game ;

    @Inject
    DraughtsDAO dao;


    public List<DraughtsColumn> getColumns() {
        List<DraughtsColumn> cols = new ArrayList<>();
        for (int i = 0; i < game.getColumnsNumber(); i++) {
            cols.add(new DraughtsColumn(i, game));
        }
        return cols;
    }
    public List<DraughtsMoveColumn> getAllowedMoves() {
        List<Point> moves= game.getAllowedMoves();

        List<DraughtsMoveColumn> cols = new ArrayList<>();
        for (int i = 0; i < game.getColumnsNumber(); i++) {
            cols.add(new DraughtsMoveColumn(i, moves,game));
        }
        return cols;
    }
    public int getPrePlayX(){
        return game.getGame().getTryX();
    }
    public int getPrePlayY(){
        return game.getGame().getTryY();
    }



    public void play(int prex,int prey,int postx,int posty) {

        this.game.play(new Point(prex,prey), new Point(postx,posty), this.game.getCurrentTurn());

    }
    public void prePlay(int x, int y){
        this.game.prePlay(y,x);
    }
    public String getCurrentPlayer(){
        return this.game.getCurrentTurn().toString();
    }

    public void reset() {


    }

    public PlayeColourWrapper getWinner() {
       /* if (game.getWinner() != null) {
            return new PlayeColourWrapper(game.getWinner());
        } else {
            return null;
        }*/
        return null;
    }

    public Draughts getGame() {
        return game;
    }

    public void createNewGame() {
        game = dao.createNewGame();

    }

    public void loadFromToken(String token) {
        game = dao.loadFromToken(token);

    }

    public String getToken() {
        return game.getToken();
    }
}
