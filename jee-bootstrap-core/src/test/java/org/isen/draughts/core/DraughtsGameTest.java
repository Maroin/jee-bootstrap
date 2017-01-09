package org.isen.draughts.core;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;

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

        DraughtCell draughtCell = game.getDraughtCell(new Point(0,0));
        assertThat(draughtCell).isNotNull();




        assertThat(draughtCell.getChipType()).isEqualTo(ChipType.CHIP);
        assertThat(draughtCell.getPlayer()).isEqualTo(Player.WHITE);



    }

    @Test
    public void aPlayerCanMove() throws Exception {

        game.play(new Point(1,2), new Point(2,3), WHITE);



    }



}
