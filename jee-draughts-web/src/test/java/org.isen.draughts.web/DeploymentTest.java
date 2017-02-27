package org.isen.draughts.web;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by isen on 26/02/2017.
 */
public class DeploymentTest extends JettyHarness {

    @Test
    public void itCanBrowseIndex() throws Exception {

        String index = get(getBaseUri());
        System.out.println(index);
        assertTrue(index.contains("Hello"));
    }
}
