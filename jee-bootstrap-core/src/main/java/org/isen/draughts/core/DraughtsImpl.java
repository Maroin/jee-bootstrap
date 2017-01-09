package org.isen.draughts.core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maroin on 03/09/2014.
 */
public class DraughtsImpl implements Draughts {


    private List<List<DraughtCell>> board = new ArrayList<>(10);


    DraughtsImpl(){

        for (int i = 0; i < 10; i++) {

            ArrayList<DraughtCell> row = new ArrayList<>(10);

            for (int j=0;j<10;j++){
                DraughtCell draughtCell = new DraughtCell();

                draughtCell.setChipType(ChipType.EMPTY);
                draughtCell.setPlayer(null);

                row.add(draughtCell);
            }

            for (int j=0;j<10;j+=2){
                if (i < 4){
                    DraughtCell draughtCell = row.get(j);

                    draughtCell.setChipType(ChipType.CHIP);
                    draughtCell.setPlayer(Player.WHITE);
                }
                if (i > 5){
                    DraughtCell draughtCell = row.get(j);

                    draughtCell.setChipType(ChipType.CHIP);
                    draughtCell.setPlayer(Player.BLACK);
                }

            }

            board.add(row);
        }
    }
    @Override
    public void play(Point point, Point point1, Player colour) {

    }

    @Override
    public boolean getColour() {
        return false;
    }

    @Override
    public ArrayList<Player> getBoard() {
        return null;
    }

    @Override
    public DraughtCell getDraughtCell(Point point) {


        return board.get(point.x).get(point.y);
    }
}