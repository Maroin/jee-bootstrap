package org.isen.draughts.web;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ServletTest extends JettyHarness {



    @Test
    public void itCanAccesMainPage() throws Exception {
        String result = get(HELLO_SERVLET_URI);

        assertTrue(StringUtils.isNotEmpty(result));
        assertTrue(result.contains("Hello World"));

    }

    @Test
    public void itCanParameterizeTheMessage() throws Exception {
        String result = get(HELLO_SERVLET_URI + "?name=John");
        assertTrue(StringUtils.isNotEmpty(result));
        assertTrue(result.contains("John"));
    }

    @Test
    public void itCanRememberTheNameBetweenTwoCalls() throws Exception {
        String result = get(HELLO_SERVLET_URI);
        assertTrue(result.contains("World"));

        result = get(HELLO_SERVLET_URI + "?name=John");
        assertTrue(result.contains("John"));

        result = get(HELLO_SERVLET_URI);
        assertTrue(result.contains("John"));

    }
}
