package org.isen.draughts.jpa.pojo;

import org.isen.draughts.core.enums.CellColor;
import org.isen.draughts.core.enums.ChipType;
import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtCell;
import org.isen.draughts.core.pojo.Draughts;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maroin on 03/09/2014.
 */

@Entity(name = "DraughtsGame")
public class DraughtsImpl implements Draughts {

    @Id
    @GeneratedValue
    private Long id;

    private String player1;

    private String player2;

    private void initEmptyGrid(){
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void play(Point point, Point point1, Player colour) {



    }

    @Override
    public ArrayList<Point> checkAround(Point point) {
        return null;
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