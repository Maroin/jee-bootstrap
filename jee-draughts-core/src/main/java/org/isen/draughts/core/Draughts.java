package org.isen.draughts.core;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by isen on 09/01/2017.
 */
public interface Draughts {


    void play(Point point, Point point1, Player colour);

    ArrayList<Point> checkAround(Point point);

    boolean getColour();

    ArrayList<Player> getBoard();

    /*
    return the type of Cell at a position
     */
    DraughtCell getDraughtCell(Point point);
}
