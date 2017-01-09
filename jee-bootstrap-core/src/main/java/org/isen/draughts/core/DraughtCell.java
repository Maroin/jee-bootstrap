package org.isen.draughts.core;

/**
 * Created by isen on 09/01/2017.
 */
public class DraughtCell {

    private Player player;
    private ChipType chipType;

    DraughtCell(){

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
}
