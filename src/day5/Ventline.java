package day5;

import java.util.ArrayList;

public class Ventline {
    public final Coordinate start;
    public final Coordinate end;
    public ArrayList<Coordinate> points;

    public Ventline(Coordinate start, Coordinate end) {
        if (((start.y == end.y) && (start.x > end.x)) || ((start.y > end.y) && (start.x == end.x))){
            Coordinate cont = start;
            start = end;
            end = cont;
        }
        this.start = start;
        this.end = end;
        this.points = calcPoints();
    }

    @Override
    public String toString() {
        return "Ventline{" + "start=" + start + ", end=" + end + ", points=" + points + '}';
    }

    private ArrayList<Coordinate> calcPoints(){
        ArrayList<Coordinate> points = new ArrayList<>();
        int xvalue = start.x;
        int yvalue = start.y;
        if (start.x==end.x) {
            points.add(start);
            while(yvalue < end.y){
                yvalue++;
                points.add(new Coordinate(xvalue, yvalue));
            }
        }
        else if (start.y==end.y){
            points.add(start);
            while(xvalue < end.x){
                xvalue++;
                points.add(new Coordinate(xvalue, yvalue));
            }
        }
        return points;
    }
}
