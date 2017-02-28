package org.isen.draughts.webapp;

import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.webapp.wrappers.CellWrapper;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DraughtsColumn {

   private int index;
    private Draughts game;
    List<CellWrapper> cells;

    public DraughtsColumn(int i, Draughts game) {
        this.index = i;
        this.game = game;
    }

    public List<CellWrapper> getCells() {
        List<CellWrapper> cells = new ArrayList<>();
        for (int i = 0; i < game.getRowsNumber(); i++) {
            cells.add(new CellWrapper(game.getDraughtCell(new Point(index, i))));
        }
        return cells;
    }

    public int getIndex() {
        return index;
    }

}
