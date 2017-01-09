package org.isen.draughts.core;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by isen on 09/01/2017.
 */
public interface Draughts {


    void play(Point point, Point point1, Player colour);

    boolean getColour();

    ArrayList<Player> getBoard();

    DraughtCell getDraughtCell(Point point);
}
