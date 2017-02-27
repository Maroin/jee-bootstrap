package org.isen.draughts.web;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JspTest extends JettyHarness {

    private static final String INDEX_URI = getBaseUri() + "/hello.jsp";

    @Test
    public void itCanGetTheIndexPage() throws Exception {
        String result = get(INDEX_URI);
        assertTrue(StringUtils.isNotEmpty(result));
        assertTrue(result.contains("Hello"));
    }

    @Test
    public void itCanParameterizeRequest() throws Exception {
        String result = get(INDEX_URI+"?name=John");
        assertTrue(result.contains("Hello John"));
    }
}
