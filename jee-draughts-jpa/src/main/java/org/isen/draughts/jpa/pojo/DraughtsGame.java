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
public class DraughtsGame {

    public static final String ALL_GAME_ENTRIES = "ALL_GAME_ENTRIES";

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="game")
    private List<DraughtsMoveImpl> moves =new ArrayList<>();

    public DraughtsGame() {
    }



    public List<DraughtsMoveImpl> getMoves() {
        return moves;
    }

    public void setMoves(List<DraughtsMoveImpl> moves) {
        this.moves = moves;
    }
}