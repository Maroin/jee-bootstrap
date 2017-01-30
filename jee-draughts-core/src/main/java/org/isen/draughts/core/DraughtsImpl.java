package org.isen.draughts.core;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.isen.draughts.core.ChipType.EMPTY;

/**
 * Created by maroin on 03/09/2014.
 */
public class DraughtsImpl implements Draughts {


    private List<List<DraughtCell>> board = new ArrayList<>(10);

    private void initEmptyGrid(){
        for (int i = 0; i < 10; i++) {

            ArrayList<DraughtCell> row = new ArrayList<>(10);

            for (int j = 0; j < 10; j++) {
                CellColor color  = CellColor.BLACK;
                if((i*10 + j)%2 == 0){
                    color = CellColor.WHITE;
                }
                DraughtCell draughtCell = new DraughtCell(null, EMPTY,color);
                row.add(draughtCell);
            }
            board.add(row);
        }
    }
    public DraughtsImpl(){
        initEmptyGrid();

        for (int j = 0; j < 4; j++) {
            for (int i = j%2; i < 10; i+=2) {
                DraughtCell cell  = board.get(i).get(j);
                cell.setPlayer(Player.WHITE);
                cell.setChipType(ChipType.CHIP);

            }
        }

        for (int j = 6; j < 10; j++) {
                for (int i = j%2; i < 10; i+=2) {
                    DraughtCell cell  = board.get(i).get(j);
                    cell.setPlayer(Player.BLACK);
                    cell.setChipType(ChipType.CHIP);
            }

        }


    }
    @Override
    public void play(Point point, Point point1, Player colour) {

        DraughtCell initialDC = getDraughtCell(point);
        DraughtCell destDC = getDraughtCell(point1);




        if (initialDC.getChipType() != EMPTY){
            /*
            il y a un pion à ma position initiale
             */

            /*
            Vérification des voisins pour l'obligation de manger
            */
            ArrayList<Point> toColor = checkAround(point);



        } else {
            System.out.println("Please select a chip ");
        }

    }

    @Override
    public ArrayList<Point> checkAround(Point point) {
        /*
            1   2
              o
            3   4
            Chip is in the middle,
         */
        DraughtCell initialDC = getDraughtCell(point);
        Player initialPlayer = initialDC.getPlayer();

        ArrayList<Point> destinations = new ArrayList<>();

        DraughtCell upRightDC = nextDC(point,1);
        DraughtCell upLeftDC = nextDC(point,2);
        DraughtCell downLeftDC = nextDC(point,3);
        DraughtCell downRightDC = nextDC(point,4);



        if (upRightDC !=null){

            if (upRightDC.getChipType() == EMPTY){
                /*
                haute droite libre!
                 */
                destinations.add(nextPoint(point,1));
                System.out.println("Libre Haut Droite");
            }

            if (initialPlayer == upRightDC.getPlayer()){
                /*
                voisin même couleur, Haut Droite pas possible
                 */
                System.out.println("voisin");

            } else {

                upRightDC = nextDC(nextPoint(point,1),1);
                /*
                voisin ennemi ! espace vide après ?
                 */
                if (upRightDC!=null){
                    if (upRightDC.getChipType() == EMPTY){
                        /*
                        on peut manger l'ennemi
                         */
                        destinations.add(nextPoint(point,1));
                    }
                }
            }

        }
        if (upLeftDC !=null){
            if (upLeftDC.getChipType() == EMPTY){
                /*
                haute gauche libre!
                 */
                destinations.add(nextPoint(point,2));
                System.out.println("Libre Haut Gauche");
            }
            if (initialPlayer == upLeftDC.getPlayer()){

            } else {


                                /*
                voisin ennemi ! espace vide après ?

                 */

            }
        }
        if (downLeftDC !=null){
            if (downLeftDC.getChipType() == EMPTY){
                /*
                bas gauche libre!
                 */
                destinations.add(nextPoint(point,3));
                System.out.println("Libre Bas Gauche");
            }
            if (initialPlayer == downLeftDC.getPlayer()){

            } else {
                                /*
                voisin ennemi ! espace vide après ?

                 */
            }
        }
        if (downRightDC !=null){
            if (downRightDC.getChipType() == EMPTY){
                /*
                bas gauche libre!
                 */
                destinations.add(nextPoint(point,4));
                System.out.println("Libre Bas Droite");
            }
            if (initialPlayer == downRightDC.getPlayer()){

            } else {
                                /*
                voisin ennemi ! espace vide après ?

                 */
            }
        }


        return (destinations);
    }


    private DraughtCell nextDC(Point point, int d){

        switch (d){
            case 1:
                if ((0 <= (point.x+1) && (point.x+1) <10) && ((point.y+1)>=0 && (point.y+1)<10 )) {
                    return (getDraughtCell(new Point(point.x + 1, point.y + 1)));
                }
            case 2:
                if (((point.x-1) >= 0 && (point.x-1) <10) && ((point.y+1)>=0 && (point.y+1)<10 )) {
                    return (getDraughtCell(new Point(point.x - 1, point.y + 1)));
                }
            case 3:
                if ((0 <= (point.x-1) && (point.x-1) <10) && ((point.y-1)>=0 && (point.y-1)<10 )) {
                    return (getDraughtCell(new Point(point.x - 1, point.y - 1)));
                }
            case 4:
                if ((0 <= (point.x+1) && (point.x+1) <10) && ((point.y-1)>=0 && (point.y-1)<10 )) {
                    return (getDraughtCell(new Point(point.x + 1, point.y - 1)));
                }
            default:
                return null;
        }

    }
    private Point nextPoint(Point point, int d){

        switch (d){
            case 1:
                return (new Point(point.x+1,point.y+1));
            case 2:
                return (new Point(point.x-1,point.y+1));
            case 3:
                return (new Point(point.x-1,point.y-1));
            case 4:
                return (new Point(point.x+1,point.y-1));
            default:
                return null;
        }

    }


    @Override
    public boolean getColour() {
        return false;
    }

    @Override
    public ArrayList<Player> getBoard() {
        return null;
    }

    @Override
    public DraughtCell getDraughtCell(Point point) {
        /*
        on vérifie que le point demander est bien dans le tableau
         */
        if (0 <= point.x || point.x <10 && point.y>=0 || point.y<10 ){
            return board.get(point.x).get(point.y);
        }
        else {
            System.out.println(" Out of the board");
            return null;
        }

    }
}