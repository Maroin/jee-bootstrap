package org.isen.draughts.jpa.pojo;

import org.isen.draughts.core.enums.Player;

import javax.persistence.*;
import java.awt.*;

/**
 * Created by charles on 26/02/17.
 */
@Entity(name = "DraughtsMove")
public class DraughtsMoveImpl {

    @Id
    @GeneratedValue
    private Long id;

    private Player player;

    private Point origine;

    private Point dest;


    @ManyToOne
    private DraughtsGame game;

    public DraughtsMoveImpl() {
    }


    public DraughtsGame getGame() {
        return game;
    }

    public void setGame(DraughtsGame game) {
        this.game = game;
    }


    public DraughtsMoveImpl(Player player, Point origine, Point dest) {
        this.player = player;
        this.origine = origine;
        this.dest = dest;
    }

    public DraughtsMoveImpl(Point point, Point point1, Player colour) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Point getOrigine() {
        return origine;
    }

    public void setOrigine(Point origine) {
        this.origine = origine;
    }

    public Point getDest() {
        return dest;
    }

    public void setDest(Point dest) {
        this.dest = dest;
    }
}
