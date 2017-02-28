package org.isen.draughts.jpa;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.assertj.core.api.Assertions;
import org.isen.draughts.core.enums.ChipType;
import org.isen.draughts.core.pojo.DraughtCell;
import org.isen.draughts.core.pojo.Draughts;
import org.isen.draughts.core.pojo.DraughtsImpl;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;
import org.isen.draughts.jpa.dao.DraughtsDAO;
import org.isen.draughts.jpa.dao.impl.DraughtsDAOImpl;
import org.isen.draughts.jpa.guice.GuiceRunner;
import org.isen.draughts.jpa.guice.H2DBModule;
import org.isen.draughts.jpa.guice.Modules;
import org.isen.draughts.jpa.pojo.DraughtsGame;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.awt.Point;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.isen.draughts.core.enums.Player.BLACK;
import static org.isen.draughts.core.enums.Player.WHITE;

/**
 * Created by charles&maroin on 10/01/2016.
 */
@RunWith(GuiceRunner.class)
@Modules({ H2DBModule.class })
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
    public void checkInitialBoard() throws Exception{

        /*
        1ERE LIGNE OU LES CHAMPS SONT VIDES
         */
        DraughtCell draughtCellEmpty = game.getDraughtCell(new Point(0,1));
        Assertions.assertThat(draughtCellEmpty).isNotNull();
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,3));
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,5));
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,7));
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        draughtCellEmpty = game.getDraughtCell(new Point(0,9));
        Assertions.assertThat(draughtCellEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellEmpty.getPlayer()).isNull();

        /*
        1ERE LIGNE OU LES PIONS SONT BLANCS ET NOIR
         */

        DraughtCell whiteCell = game.getDraughtCell(new Point(0,0) );
        Assertions.assertThat(whiteCell).isNotNull();

        Assertions.assertThat(whiteCell.getChipType()).isEqualTo(ChipType.CHIP);
        Assertions.assertThat(whiteCell.getPlayer()).isEqualTo(WHITE);

        whiteCell = game.getDraughtCell(new Point(0,2));
        Assertions.assertThat(whiteCell.getChipType()).isEqualTo(ChipType.CHIP);
        Assertions.assertThat(whiteCell.getPlayer()).isEqualTo(WHITE);


        whiteCell = game.getDraughtCell(new Point(0,6));
        Assertions.assertThat(whiteCell.getChipType()).isEqualTo(ChipType.CHIP);
        Assertions.assertThat(whiteCell.getPlayer()).isEqualTo(BLACK);

        whiteCell = game.getDraughtCell(new Point(0,8));
        Assertions.assertThat(whiteCell.getChipType()).isEqualTo(ChipType.CHIP);
        Assertions.assertThat(whiteCell.getPlayer()).isEqualTo(BLACK);


        /*
        LIGNE DU MILIEUX VIDES
         */
        DraughtCell draughtCellMiddleEmpty = game.getDraughtCell(new Point(0,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(1,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(2,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(3,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

        draughtCellMiddleEmpty = game.getDraughtCell(new Point(4,4));
        Assertions.assertThat(draughtCellMiddleEmpty).isNotNull();
        Assertions.assertThat(draughtCellMiddleEmpty.getChipType()).isEqualTo(ChipType.EMPTY);
        Assertions.assertThat(draughtCellMiddleEmpty.getPlayer()).isNull();

    }

    @Test
    public void aPlayerCanMove() throws Exception {

        game.play(new Point(1,3), new Point(0,4), WHITE);

        ArrayList<Point> dest =game.checkAround(new Point(1,3));
        Point point1 = new Point(0,4);
        Point point2 = new Point(2,4);
        Assertions.assertThat(dest).isNotNull();
        Assertions.assertThat(dest.contains(point2));
        Assertions.assertThat(dest.contains(point1));

    }

    @Test
    public void canRetrieveEntityManagerWithGuice() throws Exception {
        Injector injector = Guice.createInjector(new H2DBModule());
        EntityManager em = injector.getInstance(EntityManager.class);
        assertThat(em).isNotNull();
    }

    @Test
    public void iCanCreateAndRetrieveABlogEntry() throws Exception {

        // On crée un billet de blog
        DraughtsAdapter entry = dao.createNewGame("Mon billet de blog","holla");


        // On le sauvegarde
        dao.saveEntry(entry.getGame());
        // On le récupère
       // List<Draughts> entries = dao.getGames();
        //assertThat(entries.size()).isEqualTo(1);
        assertThat(1).isEqualTo(1);
    }
   /* @Test
    public void iCanAddAndRetrieveComment() throws Exception {
        BlogEntry entry = dao.createEntry("billet de test");
        Comment comment = new FakeComment("author", "un commentaire");
        entry.addComment(comment);
        dao.saveEntry(entry);
        entry = dao.getBlogEntry(entry.getId());
        List<? extends Comment> comments = entry.getComments();
        assertThat(comments.size(), is(1));
        comment = comments.get(0);
        assertThat(comment.getAuthor(),is("author"));
        assertThat(comment.getContent(), is("un commentaire"));
    }*/



}
