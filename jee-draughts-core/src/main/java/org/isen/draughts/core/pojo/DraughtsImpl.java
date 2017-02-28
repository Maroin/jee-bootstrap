package org.isen.draughts.core.pojo;

import org.isen.draughts.core.enums.CellColor;
import org.isen.draughts.core.enums.ChipType;
import org.isen.draughts.core.enums.Player;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.isen.draughts.core.enums.ChipType.EMPTY;

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
                DraughtCell draughtCell = new DraughtCell(null, EMPTY,color);
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

        List<Point> listOfPoints = new ArrayList<>();

        Point upRight = nextPoint(origin, 1);
        Point upLeft = nextPoint(origin, 2);
        Point downLeft = nextPoint(origin, 3);
        Point downRight = nextPoint(origin,4);

        if (getDraughtCell(upLeft).getChipType() == EMPTY){
            listOfPoints.add(upLeft);
        } else {
            if (getDraughtCell(upLeft).getPlayer() != player){
                if (getDraughtCell(nextPoint(upLeft,2)).getChipType() == EMPTY){
                    listOfPoints.add(nextPoint(upLeft,2));
                }
            }
        }
        if (getDraughtCell(upRight).getChipType() == EMPTY){
            listOfPoints.add(upRight);
        } else
            if (getDraughtCell(upLeft).getPlayer() != player){
                if (getDraughtCell(nextPoint(upRight,1)).getChipType() == EMPTY){
                    listOfPoints.add(nextPoint(upRight,1));
                }
        }
        if (getDraughtCell(downLeft).getPlayer() != player){
            if (getDraughtCell(nextPoint(downLeft,3)).getChipType() == EMPTY){
                listOfPoints.add(nextPoint(downLeft,3));
            }
        }

        if (getDraughtCell(downRight).getPlayer() != player){
            if (getDraughtCell(nextPoint(downRight,4)).getChipType() == EMPTY){
                listOfPoints.add(nextPoint(downRight,4));
            }
        }


        return listOfPoints;
    }
    private Point nextPoint(Point point, int d){

          switch (d){
          case 1:
                  return (new Point(point.x+1,point.y+1));
          case 2:
                  return (new Point(point.x-1,point.y+1));
          case 3:
                  return (new Point(point.x-1,point.y-1));
          case 4:
                  return (new Point(point.x+1,point.y-1));
          default:
                  return null;
      }

      }
    @Override
    public Player getWinner() {
        return null;
    }

    public ArrayList<Player> getBoard() {

     // ArrayList<Player> arrayList = new ArrayList<>();
     // for (int i = 0; i<board.size();i++){
     //
     //     List<DraughtCell> list = new ArrayList<>();
     //     list = board.get(i);
     //
     //     arrayList.
     //
     // }

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
