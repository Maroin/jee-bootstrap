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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String player;

    private int origineX;

    private int origineY;

    private int destX;

    private int destY;


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
        this.player = player.toString();
        this.origineX = origine.x;
        this.origineY = origine.y;

        this.destX = dest.x;
        this.destY = dest.y;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getOrigineX() {
        return origineX;
    }

    public void setOrigineX(int origineX) {
        this.origineX = origineX;
    }

    public int getOrigineY() {
        return origineY;
    }

    public void setOrigineY(int origineY) {
        this.origineY = origineY;
    }

    public int getDestX() {
        return destX;
    }

    public void setDestX(int destX) {
        this.destX = destX;
    }

    public int getDestY() {
        return destY;
    }

    public void setDestY(int destY) {
        this.destY = destY;
    }
}
