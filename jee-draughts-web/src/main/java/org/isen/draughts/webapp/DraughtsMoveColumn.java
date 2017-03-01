package org.isen.draughts.webapp;

import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.webapp.wrappers.AllowedCellWrapper;
import org.isen.draughts.webapp.wrappers.CellWrapper;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by charles on 01/03/17.
 */
public class DraughtsMoveColumn {

    private int index;
    private List<Point> points;
    private Draughts game;
    List<CellWrapper> cells;

    public DraughtsMoveColumn(int i, List<Point> points,Draughts game) {
        this.index = i;
        this.points = points;
        this.game = game;
    }

    public List<AllowedCellWrapper> getCells() {
        List<AllowedCellWrapper> cells = new ArrayList<>();
        for (int i = 0; i < game.getRowsNumber(); i++) {
            cells.add(new AllowedCellWrapper(index, i, points));
        }
        return cells;
    }

    public int getIndex() {
        return index;
    }
}
