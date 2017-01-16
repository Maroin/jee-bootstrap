package org.isen.draughts.web;

import com.sun.xml.internal.ws.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by isen on 16/01/2017.
 */

@WebServlet(urlPatterns = "/hello")
public class GameServlet extends HttpServlet {

    private static final long serialVersionUID = 4590295895653754427L;

    private String getHtml(){
        return "<html>" +
                "+ <body>Servlet version" +
                "+ <h1>Hello World!</h1>" +
                "+ </body></html>";
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException{

        PrintWriter out = resp.getWriter();
        out.print(getHtml());


    }

}
