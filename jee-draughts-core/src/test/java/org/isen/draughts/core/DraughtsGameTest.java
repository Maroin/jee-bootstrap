package org.isen.draughts.core;


import org.junit.Before;
import org.junit.Test;


import java.awt.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.isen.draughts.core.Player.BLACK;
import static org.isen.draughts.core.Player.WHITE;

/**
 * Created by charles&maroin on 10/01/2016.
 */
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
        assertThat(draughtCellEmpty).isNotNull();
        assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,3));
        assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,5));
        assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,7));
        assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,9));
        assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellEmpty.getPlayer()).isNull();

        /*
        1ERE LIGNE OU LES PIONS SONT BLANCS ET NOIR
         */

        DraughtCell whiteCell = game.getDraughtCell(new Point(0,0));
        assertThat(whiteCell).isNotNull();

        assertThat(whiteCell.getChipType()).isEqualTo(ChipType.CHIP);
        assertThat(whiteCell.getPlayer()).isEqualTo(WHITE);

        whiteCell = game.getDraughtCell(new Point(0,2));
        assertThat(whiteCell.getChipType()).isEqualTo(ChipType.CHIP);
        assertThat(whiteCell.getPlayer()).isEqualTo(WHITE);


        whiteCell = game.getDraughtCell(new Point(0,6));
        assertThat(whiteCell.getChipType()).isEqualTo(ChipType.CHIP);
        assertThat(whiteCell.getPlayer()).isEqualTo(BLACK);

        whiteCell = game.getDraughtCell(new Point(0,8));
        assertThat(whiteCell.getChipType()).isEqualTo(ChipType.CHIP);
        assertThat(whiteCell.getPlayer()).isEqualTo(BLACK);


        /*
        LIGNE DU MILIEUX VIDES
         */
        DraughtCell draughtCellMiddleEmpty = game.getDraughtCell(new Point(0,4));
        assertThat(draughtCellMiddleEmpty).isNotNull();
        assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(1,4));
        assertThat(draughtCellMiddleEmpty).isNotNull();
        assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(2,4));
        assertThat(draughtCellMiddleEmpty).isNotNull();
        assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(3,4));
        assertThat(draughtCellMiddleEmpty).isNotNull();
        assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(4,4));
        assertThat(draughtCellMiddleEmpty).isNotNull();
        assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

    }

    @Test
    public void aPlayerCanMove() throws Exception {

        game.play(new Point(1,3), new Point(0,4), WHITE);

        ArrayList<Point> dest =game.checkAround(new Point(1,3));

        Point point1 = new Point(0,4);
        Point point2 = new Point(2,4);
        assertThat(dest).isNotNull();
        assertThat(dest.contains(point2));
        assertThat(dest.contains(point1));



    }



}
