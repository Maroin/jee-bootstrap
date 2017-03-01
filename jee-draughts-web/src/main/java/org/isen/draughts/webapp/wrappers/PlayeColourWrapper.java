package org.isen.draughts.webapp.wrappers;


import org.isen.draughts.core.enums.Player;

public class PlayeColourWrapper {

    private Player cell;

    public PlayeColourWrapper(Player colour) {
        this.cell = colour;
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
