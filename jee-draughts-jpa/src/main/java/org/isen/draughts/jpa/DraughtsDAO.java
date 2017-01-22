package org.isen.draughts.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 * Created by maroin on 22/01/17.
 */
public class DraughtsDAO {

    @Inject
    EntityManager em;

    @Inject
    UserTransaction ut;

    public DraughtsAdapter createNewGame(){

        Game game = new Game();


        return new DraughtsAdapter(this, game);
    };
}
