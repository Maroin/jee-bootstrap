package org.isen.draughts.core;

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

    void setPlayer(Player player) {
        this.player = player;
    }

    ChipType getChipType() {
        return chipType;
    }

    void setChipType(ChipType chipType) {
        this.chipType = chipType;
    }

    public CellColor getCellColor() {
        return cellColor;
    }

    public void setCellColor(CellColor cellColor) {
        this.cellColor = cellColor;
    }
}
