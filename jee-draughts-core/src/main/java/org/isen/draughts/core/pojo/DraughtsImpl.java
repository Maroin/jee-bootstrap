package org.isen.draughts.core.pojo;

import org.isen.draughts.core.enums.CellColor;
import org.isen.draughts.core.enums.ChipType;
import org.isen.draughts.core.enums.Player;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.isen.draughts.core.enums.ChipType.CHIP;
import static org.isen.draughts.core.enums.ChipType.EMPTY;
import static org.isen.draughts.core.enums.Player.BLACK;
import static org.isen.draughts.core.enums.Player.WHITE;

/**
 * Created by charles on 27/02/17.
 */
public class DraughtsImpl implements Draughts {

    public final static int COLUMNS_NUMBER = 10;

    java.util.List<java.util.List<DraughtCell>> board = new ArrayList<>(COLUMNS_NUMBER);

    CellColor color  = CellColor.WHITE;
    public void initEmptyGrid(){
        for (int i = 0; i < COLUMNS_NUMBER; i++) {

            ArrayList<DraughtCell> row = new ArrayList<>(COLUMNS_NUMBER);

            for (int j = 0; j < COLUMNS_NUMBER; j++) {
                DraughtCell draughtCell = new DraughtCell(null, EMPTY,color);
                if(j != 9){
                    if(color == CellColor.BLACK){
                        color = CellColor.WHITE;
                    }else{

                        color = CellColor.BLACK;
                    }
                }
                row.add(draughtCell);
            }
            board.add(row);
        }
    }


    public DraughtsImpl(){
        initEmptyGrid();

        for (int j = 0; j < 4; j++) {
            for (int i = j%2; i < COLUMNS_NUMBER; i+=2) {
                DraughtCell cell  = board.get(i).get(j);
                cell.setPlayer(WHITE);
                cell.setChipType(ChipType.CHIP);

            }
        }

        for (int j = 6; j < COLUMNS_NUMBER; j++) {
            for (int i = j%2; i < COLUMNS_NUMBER; i+=2) {
                DraughtCell cell  = board.get(i).get(j);
                cell.setPlayer(Player.BLACK);
                cell.setChipType(ChipType.CHIP);

            }

        }


    }


    public void play(Point point, Point point1, Player colour) {

        /*
        White begins
         */

        if (point != null && point1!=null) {

            if (getDraughtCell(point) != null && getDraughtCell(point1)!=null)  {


                if (getDraughtCell(point).getPlayer() == WHITE) {
                /*
                chip belongs to the white
                 */

                    List<Point> pointList = getAllowedMoves(point, colour);


                    if (pointList.size() != 0) {
                        System.out.println("There is possibilities");

                        if (pointList.contains(point1)) {
                        /*
                        there is a list of possibilities and among them, point1 is
                        so the player can move his chip on Point1
                         */
                            System.out.println("Destination x: "+point1.x+" y: "+point1.y+" contained");

                            for (List<DraughtCell> boardA : board) {
                                for (DraughtCell draughtCells : boardA) {

                                    if (draughtCells == getDraughtCell(point)) {
                                    /*
                                    empty the initial position
                                     */
                                        System.out.println("Emptying initial white ");


                                        draughtCells.setChipType(EMPTY);
                                    }

                                   // if (draughtCells == getDraughtCell(new Point) ) {
                                   // /*
                                   // remove this draughtCell
                                   //  */
                                   //
                                   //     System.out.println("Empty middle spot ");
                                   //
                                   //     draughtCells.setChipType(EMPTY);
                                   // }

                                    if (draughtCells == getDraughtCell(point1)) {
                                    /*
                                    fill the new position
                                     */
                                        System.out.println("Filling for a white destination ");

                                        draughtCells.setCellColor(CellColor.WHITE);
                                        draughtCells.setPlayer(colour);
                                        draughtCells.setChipType(CHIP);
                                    }


                                }
                            }

                        }
                    } else {
                    /*
                    select another Point
                     */
                    }
                }


                if (getDraughtCell(point).getPlayer() == BLACK) {
                /*
                chip belongs to the black
                 */
                    List<Point> pointList = getAllowedMoves(point, colour);

                    if (pointList.size() != 0) {
                        if (pointList.contains(point1)) {
                        /*
                        there is a list of possibilities and among them, point1 is
                        so the player can move his chip on Point1
                         */
                            for (List<DraughtCell> boardA : board) {
                                for (DraughtCell draughtCells : boardA) {

                                    if (draughtCells == getDraughtCell(point)) {
                                        draughtCells.setChipType(EMPTY);
                                        System.out.println("Emptying initial black ");

                                    }
                                    //if (draughtCells == getDraughtCell(point1)) {
                                    ///*
                                    //remove this draughtCell
                                    // */
                                    //    draughtCells.setChipType(EMPTY);
                                    //}

                                    if (draughtCells == getDraughtCell(point1)) {
                                    /*
                                    fill the new position
                                     */
                                        System.out.println("Filling for a  black destination ");

                                        draughtCells.setCellColor(CellColor.BLACK);
                                        draughtCells.setPlayer(colour);
                                        draughtCells.setChipType(CHIP);
                                    }
                                }
                            }

                        }
                    } else {
                    /*
                    select another Point
                     */
                    }
                }
            }


        }
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
        /*
        upRight or upLeft empty add to the list
        upR, upL, dL, dR not empty and nextPoint empty, add to the list.
         */
        System.out.println("Player +"+player.toString()+ '\n'+
                "Originally from => x :"+origin.x + " y :"+origin.y);

        if (upLeft !=null){

            if (getDraughtCell(upLeft)!=null){

                if (getDraughtCell(upLeft).getChipType() == EMPTY){

                    System.out.println("upLeft chip is empty ");

                    listOfPoints.add(upLeft);
                } else {
                    if (getDraughtCell(upLeft).getPlayer() != player){

                        System.out.println("upLeft chip is ennemy ");

                        if (nextPoint(upLeft,2)!=null){
                            if (getDraughtCell(nextPoint(upLeft,2))!=null) {
                                if (getDraughtCell(nextPoint(upLeft,2)).getChipType()!=null ) {
                                    if (getDraughtCell(nextPoint(upLeft, 2)).getChipType() == EMPTY) {
                                        System.out.println("You can eat it");


                                        listOfPoints.add(nextPoint(upLeft, 2));
                                        System.out.println("notTrue");
                                    }
                                }
                                }
                            }
                        } else {
                        System.out.println("Neighbor");

                    }
                    }
                }
        }

        if (upRight !=null) {

            if (getDraughtCell(upRight) != null) {

                System.out.println("Player +"+player.toString());
                System.out.println("upRight =  x : "+upRight.x+" y : " + upRight.y);

                if (getDraughtCell(upRight).getChipType() == EMPTY) {

                    System.out.println("upRight chip is empty ");

                    listOfPoints.add(upRight);
                } else if (getDraughtCell(upRight).getPlayer() != player) {

                    System.out.println("upRight chip is ennemy ");

                    if (getDraughtCell(nextPoint(upRight, 1)).getChipType() == EMPTY) {
                        System.out.println("You can eat it");

                        listOfPoints.add(nextPoint(upRight, 1));
                    }
                } else {
                    System.out.println("Neighbor");

                }
            }
        }


        if (downLeft !=null) {


            if (getDraughtCell(downLeft) != null) {


                System.out.println("Player +" + player.toString());
                System.out.println("downLeft =  x : " + downLeft.x + " y : " + downLeft.y);

                if (getDraughtCell(downLeft).getChipType() == EMPTY) {

                    System.out.println("downLeft chip is empty ");

                    listOfPoints.add(downLeft);
                }else {
                    if (getDraughtCell(downLeft).getPlayer() != null) {


                        if (getDraughtCell(downLeft).getPlayer() != player) {

                            System.out.println("downLet chip is ennemy " + getDraughtCell(downLeft).getPlayer() + "  " +
                                    getDraughtCell(downLeft).getChipType() + "    " + getDraughtCell(downLeft).getCellColor());

                            if (getDraughtCell(nextPoint(downLeft, 3)).getChipType() == EMPTY) {
                                System.out.println("You can eat it");

                                listOfPoints.add(nextPoint(downLeft, 3));
                            }
                        } else {
                            System.out.println("Neighbor");
                        }
                }

            }

            }
        }

        if (downRight!=null){
            if (getDraughtCell(downRight)!=null) {

                System.out.println("Player +" + player.toString());
                System.out.println("downRight =  x : " + downRight.x + " y : " + downRight.y);
                if (getDraughtCell(downRight).getChipType() == EMPTY) {

                    System.out.println("downRight chip is empty ");

                    listOfPoints.add(downRight);
                } else {

                    if (getDraughtCell(downRight).getPlayer() != null) {

                        if (getDraughtCell(downRight).getPlayer() != player) {

                            System.out.println("downRight chip is ennemy ");

                            if (getDraughtCell(nextPoint(downRight, 4)).getChipType() == EMPTY) {
                                System.out.println("You can eat it");

                                listOfPoints.add(nextPoint(downRight, 4));
                            }
                        } else {
                            System.out.println("Neighbor");

                        }
                    }
                }
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

        if (0 <= point.x && point.x <10 && point.y>=0 && point.y<10 ){
            return board.get(point.x).get(point.y);
        } else {
            return null;
        }
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
