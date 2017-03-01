package org.isen.draughts.webapp.wrappers;

import org.isen.draughts.core.enums.CellColor;
import org.isen.draughts.core.enums.ChipType;
import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtCell;

/**
 * Created by charles on 28/02/17.
 */
public class CellWrapper {

    private Player player;
    private ChipType chipType;
    private CellColor cellColor;
    private int index;

    public int getIndex() {
        return index;
    }

    public CellWrapper(DraughtCell draughtCell, int index) {
        this.player = draughtCell.getPlayer();
        this.chipType = draughtCell.getChipType();
        this.cellColor = draughtCell.getCellColor();
        this.index = index;
    }

    public String getCssCellColor() {
        if(CellColor.BLACK == cellColor) {
            return "black";
        } else if(CellColor.WHITE ==cellColor) {
            return "red";
        } else {
            return "";
        }
    }

    public String getCssChipType() {
        if(ChipType.CHIP == chipType) {
            return "chip";
        } else if(ChipType.DRAFT ==chipType) {
            return "draft";
        } else {
            return null;
        }
    }

    public String getCssPlayer() {
        if(Player.BLACK == player) {
            return "black";
        } else if(Player.WHITE ==player) {
            return "white";
        } else {
            return null;
        }
    }
}
