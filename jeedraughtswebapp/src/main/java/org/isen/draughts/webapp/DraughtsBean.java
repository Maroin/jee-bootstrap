package org.isen.draughts.webapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;

@Named("game")
@RequestScoped
public class DraughtsBean implements Serializable {

    DraughtsAdapter game ;

    @Inject
    DraughtsDAO dao;


    public List<Puissance4Column> getColumns() {

        return null;
    }

    public void play(int col) {
        //game.play(game.getCurrentTurn(), col);

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
        game = dao.createNewGame("","");

    }

    public void loadFromToken(String token) {
        game = dao.loadFromToken(token);

    }

}
