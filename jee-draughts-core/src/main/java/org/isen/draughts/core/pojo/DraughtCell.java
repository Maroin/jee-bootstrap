package org.isen.draughts.core.pojo;

import org.isen.draughts.core.enums.CellColor;
import org.isen.draughts.core.enums.ChipType;
import org.isen.draughts.core.enums.Player;

/**
 * Created by isen on 09/01/2017.
 */
public class DraughtCell {

    private Player player;
    private ChipType chipType;
    private CellColor cellColor;

    DraughtCell(){

    }

    public DraughtCell(Player player, ChipType chipType, CellColor cellColor) {
        this.player = player;
        this.chipType = chipType;
        this.cellColor = cellColor;
    }

    public DraughtCell(CellColor cellColor) {
        this.cellColor = cellColor;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ChipType getChipType() {
        return chipType;
    }

    public void setChipType(ChipType chipType) {
        this.chipType = chipType;
    }

    public CellColor getCellColor() {
        return cellColor;
    }

    public void setCellColor(CellColor cellColor) {
        this.cellColor = cellColor;
    }
}
