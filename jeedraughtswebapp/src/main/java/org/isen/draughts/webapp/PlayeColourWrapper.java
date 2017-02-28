package org.isen.draughts.webapp;


import org.isen.draughts.core.enums.Player;

public class PlayeColourWrapper {

    private Player cell;

    public PlayeColourWrapper(Player cell) {
        this.cell = cell;
    }

    public String getCssColor() {
        if(Player.BLACK == cell) {
            return "black";
        } else if(Player.WHITE ==cell) {
            return "yellow";
        } else {
            return "";
        }
    }

}
