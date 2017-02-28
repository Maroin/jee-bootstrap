package org.isen.draughts.web;


import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by maroin on 22/01/17.
 */
@Named("game")
@RequestScoped
public class DraughtsBean implements Serializable {

    DraughtsAdapter game;

    @Inject
    DraughtsDAO dao;

    void createNewGame(){
        game = dao.createNewGame();
    }


    public void loadFromToken(String token) {
        game = dao.loadFromToken(token);

    }


}
