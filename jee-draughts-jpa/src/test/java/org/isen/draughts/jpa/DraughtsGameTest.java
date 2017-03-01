package org.isen.draughts.jpa;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.isen.draughts.core.enums.ChipType;
import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtCell;
import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.core.pojo.DraughtsImpl;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;
import org.isen.draughts.jpa.guice.GuiceRunner;
import org.isen.draughts.jpa.guice.H2DBModule;
import org.isen.draughts.jpa.guice.Modules;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.isen.draughts.core.enums.ChipType.*;
import static org.isen.draughts.core.enums.Player.BLACK;
import static org.isen.draughts.core.enums.Player.WHITE;

/**
 * Created by charles&maroin on 10/01/2016.
 */
@RunWith(GuiceRunner.class)
@Modules({ H2DBModule.class,JPAModule.class })
public class DraughtsGameTest {

    private Draughts game;


    @Before
    public void doBefore() throws Exception {

        game = new DraughtsImpl();

    }
    @Inject
    EntityManager em;

    @Inject
    DraughtsDAO dao;

    @Test
    public void daoIsInjected() throws Exception {
        assertThat(dao).isNotNull();
    }

    @Test
    public void emIsInjected() throws Exception {
        assertThat(em).isNotNull();
    }

    @Test
    public void iCanCreateAGameEntry() throws Exception {

        DraughtsAdapter game = dao.createNewGame();
        assertThat(game).isNotNull();

        String token = game.getToken();
        assertThat(game.getToken()).isNotNull();
        em.clear();
        game = dao.loadFromToken(token);
        assertThat(game).isNotNull();
    }


    @Test
    public void iCanCreateAndRetrieveAGameEntry() throws Exception {
        String token = "Token";
        DraughtsAdapter entry = dao.createNewGame();
        entry.getGame().setToken(token);
        // On le sauvegarde
        dao.saveEntry(entry.getGame());
        // On le récupère

        DraughtsAdapter DraughtsSaved = dao.loadFromToken(token);

        assertThat(DraughtsSaved).isNotNull();
        assertThat(DraughtsSaved.getToken()).isEqualTo(token);
    }
    @Test
    public void adapterManagesTurns() throws Exception {
        DraughtsAdapter game = dao.createNewGame();
        assertThat(game.getCurrentTurn()).isNotNull();
        assertThat(game.getCurrentTurn()).isEqualTo(Player.WHITE);
        game.play(new Point(3,3),new Point(4,4),game.getCurrentTurn());
        game = dao.loadFromToken(game.getToken());
        assertThat(game.getCurrentTurn()).isEqualTo(Player.BLACK);
        game.play(new Point(6,6),new Point(5,5),game.getCurrentTurn());
        game = dao.loadFromToken(game.getToken());
        assertThat(game.getCurrentTurn()).isEqualTo(Player.WHITE);

    }


}
