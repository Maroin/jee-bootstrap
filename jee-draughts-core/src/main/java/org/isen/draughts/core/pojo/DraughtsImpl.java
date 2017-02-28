package org.isen.draughts.core.pojo;

import org.isen.draughts.core.enums.CellColor;
import org.isen.draughts.core.enums.ChipType;
import org.isen.draughts.core.enums.Player;

import java.awt.*;
import java.util.*;

/**
 * Created by charles on 27/02/17.
 */
public class DraughtsImpl implements Draughts {

    public final static int COLUMNS_NUMBER = 8;

    java.util.List<java.util.List<DraughtCell>> board = new ArrayList<>(COLUMNS_NUMBER);

    public void initEmptyGrid(){
        for (int i = 0; i < 10; i++) {

            ArrayList<DraughtCell> row = new ArrayList<>(10);

            for (int j = 0; j < 10; j++) {
                CellColor color  = CellColor.BLACK;
                if((i*10 + j)%2 == 0){
                    color = CellColor.WHITE;
                }
                DraughtCell draughtCell = new DraughtCell(null, ChipType.EMPTY,color);
                row.add(draughtCell);
            }
            board.add(row);
        }
    }

    
    public DraughtsImpl(){
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


    public void play(Point point, Point point1, Player colour) {



    }
    public ArrayList<Point> checkAround(Point point) {
        return null;
    }

    public boolean getColour() {
        return false;
    }

    @Override
    public java.util.List<Point> getAllowedMoves(Point origin, Player player) {
        return null;
    }

    @Override
    public Player getWinner() {
        return null;
    }

    public ArrayList<Player> getBoard() {
        return null;
    }


    public DraughtCell getDraughtCell(Point point) {


        return board.get(point.x).get(point.y);
    }

    @Override
    public int getColumnsNumber() {
        return board.size();
    }

    @Override
    public int getRowsNumber() {
        return board.size();
    }
}
