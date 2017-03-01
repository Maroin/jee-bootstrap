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
        Iterator<Point> it = points.iterator();
        while (it.hasNext() && !isOk){
            Point point = it.next();
            if(point.y == i && point.x == index){
                isOk = true;
            }
        }
    }
    public boolean getIsAllowed(){
        return isOk;
    }
}
