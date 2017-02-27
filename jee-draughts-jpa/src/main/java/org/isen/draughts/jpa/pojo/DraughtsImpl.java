package org.isen.draughts.jpa.pojo;

import org.isen.draughts.core.enums.CellColor;
import org.isen.draughts.core.enums.ChipType;
import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtCell;
import org.isen.draughts.core.pojo.Draughts;

import javax.persistence.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maroin on 03/09/2014.
 */
@NamedQueries({
        @NamedQuery(name = "ALL_GAME_ENTRIES", query = "FROM DraughtsGame")})
@Entity(name = "DraughtsGame")
public class DraughtsImpl implements Draughts {

    public static final String ALL_GAME_ENTRIES = "ALL_GAME_ENTRIES";

    @Id
    @GeneratedValue
    private Long id;

    private String player1;

    private String player2;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="game")
    private List<DraughtsMoveImpl> moves;

    public DraughtsImpl() {
    }

    public DraughtsImpl(String player1, String player2, List<DraughtsMoveImpl> moves) {
        this.player1 = player1;
        this.player2 = player2;
        this.moves = moves;
    }

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
    public DraughtsImpl(String player1, String player2){
        this.player1 = player1;
        this.player2 = player2;
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

    public List<DraughtsMoveImpl> getMoves() {
        return moves;
    }

    public void setMoves(List<DraughtsMoveImpl> moves) {
        this.moves = moves;
    }
}