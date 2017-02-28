package org.isen.draughts.jaxrs;

import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.isen.draughts.core.enums.Player;
import org.isen.draughts.core.pojo.DraughtCell;
import org.isen.draughts.jpa.adapter.DraughtsAdapter;

@Provider
@Produces({"application/json","*/*"})
public class Puissance4GameBodyWriter implements
        MessageBodyWriter<DraughtsAdapter> {

    @Context
    UriInfo info;


    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return type.equals(DraughtsAdapter.class);
    }



    @Override
    public long getSize(DraughtsAdapter t, Class<?> type,
            Type genericType, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(DraughtsAdapter game, Class<?> type,
            Type genericType, Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException,
            WebApplicationException {

        JsonFactory factory = new JsonFactory();
        JsonGenerator jg = factory.createGenerator(entityStream, JsonEncoding.UTF8);

        jg.writeStartObject();

        Player winner = game.getWinner();
        jg.writeStringField("winner", winner != null ? winner.toString() : "");
        jg.writeStringField("token", game.getToken());


        jg.writeFieldName("cols");
        jg.writeStartArray();

        for(int i=0; i < game.getColumnsNumber(); i ++) {
            jg.writeStartObject();

            jg.writeFieldName("playAction");
            jg.writeStartObject();
            jg.writeStringField("method", "POST");
            jg.writeStringField("url", info.getAbsolutePath()+"/" + i);
            jg.writeEndObject();


            jg.writeFieldName("cells");
            jg.writeStartArray();
            for(int j=0; j < game.getRowsNumber(); j ++) {
                DraughtCell cell = game.getDraughtCell(new Point(i,j));
                jg.writeString(cell != null ? cell.toString() : "");
            }
            jg.writeEndArray();
            jg.writeEndObject();
        }
        jg.writeEndArray();
        jg.writeEndObject();
        jg.flush();

    }
}
