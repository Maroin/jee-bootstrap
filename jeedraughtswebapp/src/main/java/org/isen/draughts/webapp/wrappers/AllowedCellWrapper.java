package org.isen.draughts.webapp.wrappers;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by charles on 01/03/17.
 */
public class AllowedCellWrapper {
    private boolean isOk = false;
    public AllowedCellWrapper(int i, int index, List<Point> points) {
        points.forEach(point -> {
            if(point.x == i && point.y == index){
                isOk = true;
                return;
            }
        });
    }
    public boolean getIsAllowed(){
        return isOk;
    }
}
