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

    public CellWrapper(DraughtCell draughtCell) {
        this.player = draughtCell.getPlayer();
        this.chipType = draughtCell.getChipType();
        this.cellColor = draughtCell.getCellColor();
    }

    public String getCssCellColor() {
        if(CellColor.BLACK == cellColor) {
            return "black";
        } else if(CellColor.WHITE ==cellColor) {
            return "yellow";
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
            return "";
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
