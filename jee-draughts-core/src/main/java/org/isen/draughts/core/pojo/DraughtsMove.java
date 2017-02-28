package org.isen.draughts.core.pojo;

import org.isen.draughts.core.enums.Player;

import java.awt.*;

/**
 * Created by charles on 26/02/17.
 */
public interface DraughtsMove {
    Player getPlayer();
    void setPlayer(Player player);

    Point getOrigine();
    void setOrigine(Point point);

    Point getDest();
    void setDest(Point point);

}
