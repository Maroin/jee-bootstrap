package org.isen.draughts.core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maroin on 03/09/2014.
 */
public class DraughtsImpl implements Draughts {


    private List<List<DraughtCell>> board = new ArrayList<>(10);

    private void initEmptyGrid(){
        for (int i = 0; i < 10; i++) {

            ArrayList<DraughtCell> row = new ArrayList<>(10);

            for (int j = 0; j < 10; j++) {
                CellColor color  = CellColor.BLACK;
                if((i*10 + j)%2 == 0){
                    color = CellColor.WHITE;
                }
                DraughtCell draughtCell = new DraughtCell(null,ChipType.EMPTY,color);
                row.add(draughtCell);
            }
            board.add(row);
        }
    }
    DraughtsImpl(){
        initEmptyGrid();

        for (int j = 0; j < 4; j++) {
            for (int i = j%2; i < 10; i+=2) {
                DraughtCell cell  = board.get(i).get(j);
                cell.setPlayer(Player.WHITE);
                cell.setChipType(ChipType.CHIP);

            }
        }

        for (int j = 6; j < 10; j++) {
                for (int i = j%2; i < 10; i+=2) {
                    DraughtCell cell  = board.get(i).get(j);
                    cell.setPlayer(Player.BLACK);
                    cell.setChipType(ChipType.CHIP);

            }

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