package org.isen.draughts.core.pojo;

import org.isen.draughts.core.enums.Player;

import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by isen on 09/01/2017.
 */
public interface Draughts {



    Long getId();

    void play(Point point, Point point1, Player colour);

    ArrayList<Point> checkAround(Point point);



    boolean getColour();

    ArrayList<Player> getBoard();

    java.util.List<java.util.List<DraughtCell>> board = new ArrayList<>(10);

    /*
    return the type of Cell at a position
     */
    DraughtCell getDraughtCell(Point point);
}
