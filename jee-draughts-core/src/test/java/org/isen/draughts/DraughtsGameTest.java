package org.isen.draughts;

import org.assertj.core.api.Assertions;
import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtCell;
import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.core.pojo.DraughtsImpl;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.isen.draughts.core.enums.ChipType.CHIP;
import static org.isen.draughts.core.enums.ChipType.EMPTY;
import static org.isen.draughts.core.enums.Player.BLACK;
import static org.isen.draughts.core.enums.Player.WHITE;

/**
 * Created by charles&maroin on 10/01/2016.
 */
//@RunWith(GuiceRunner.class)
//@Modules({ H2DBModule.class })
public class DraughtsGameTest {

    private Draughts game;


    @Before
    public void doBefore() throws Exception {

        game = new DraughtsImpl();

    }


    @Test
    public void checkInitialBoard() throws Exception{

        /*
        1ERE LIGNE OU LES CHAMPS SONT VIDES
         */
        DraughtCell draughtCellEmpty = game.getDraughtCell(new Point(0,1));
        Assertions.assertThat(draughtCellEmpty).isNotNull();
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,3));
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,5));
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,7));
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,9));
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        /*
        1ERE LIGNE OU LES PIONS SONT BLANCS ET NOIR
         */

        DraughtCell whiteCell = game.getDraughtCell(new Point(0,0) );
        Assertions.assertThat(whiteCell).isNotNull();

        Assertions.assertThat(whiteCell.getChipType()).isEqualTo(CHIP);
        Assertions.assertThat(whiteCell.getPlayer()).isEqualTo(WHITE);

        whiteCell = game.getDraughtCell(new Point(0,2));
        Assertions.assertThat(whiteCell.getChipType()).isEqualTo(CHIP);
        Assertions.assertThat(whiteCell.getPlayer()).isEqualTo(WHITE);


        whiteCell = game.getDraughtCell(new Point(0,6));
        Assertions.assertThat(whiteCell.getChipType()).isEqualTo(CHIP);
        Assertions.assertThat(whiteCell.getPlayer()).isEqualTo(BLACK);

        whiteCell = game.getDraughtCell(new Point(0,8));
        Assertions.assertThat(whiteCell.getChipType()).isEqualTo(CHIP);
        Assertions.assertThat(whiteCell.getPlayer()).isEqualTo(BLACK);


        /*
        LIGNE DU MILIEUX VIDES
         */
        DraughtCell draughtCellMiddleEmpty = game.getDraughtCell(new Point(0,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(1,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(2,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(3,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(4,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

    }

    @Test
    public void aPlayerCanMove() throws Exception {

        game.play(new Point(1,3), new Point(0,4), WHITE);

        List<Point> dest =game.getAllowedMoves(new Point(1,3), Player.WHITE);
        Point point1 = new Point(0,4);
        Point point2 = new Point(2,4);
        Assertions.assertThat(dest).isNotNull();
        Assertions.assertThat(dest.contains(point2));
        Assertions.assertThat(dest.contains(point1));

    }

  /*  @Test
    public void aPlayerAteOneChip () throws Exception{

        *//*
        A white chip eats a black chip
         *//*
        Point initialBlack = new Point(2,6);
        Point destBlack = new Point(1,5);
        Point initialWhite = new Point(1,3);
        Point middleWhite = new Point(0,4);


        Assertions.assertThat(game.getDraughtCell(initialBlack).getChipType()).isEqualTo(CHIP);

        Assertions.assertThat(game.getDraughtCell(initialBlack).getPlayer().equals(BLACK));

        Assertions.assertThat(game.getDraughtCell(destBlack).getChipType()).isEqualTo(EMPTY);

        *//*****************1ST PLAY WHITE MOVE******************//*
        game.play(initialWhite, middleWhite, WHITE);

         *//*****************2ND PLAY BLACK MOVE******************//*

        game.play(initialBlack, destBlack, BLACK);


         *//****************CHECK ALLOWED MOVES FOR MIDDLE WHITE******************//*;

        List<Point> dest =game.getAllowedMoves(middleWhite, Player.WHITE);

        *//****************3RD PLAY WHITE EAT******************//*


        Assertions.assertThat(dest).isNotNull();

        Assertions.assertThat(dest).contains(initialBlack);


        game.play(middleWhite, initialBlack, WHITE);

        Assertions.assertThat(game.getDraughtCell(initialBlack).getPlayer()).isEqualTo(WHITE);


        Assertions.assertThat(game.getDraughtCell(destBlack).getChipType()).isEqualTo(CHIP);


        Assertions.assertThat(game.getDraughtCell(initialWhite).getChipType()).isEqualTo(EMPTY);

    }
*/

}
