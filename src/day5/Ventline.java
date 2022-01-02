package day5;

import java.util.ArrayList;

public class Ventline {
    public final Coordinate start;
    public final Coordinate end;
    public ArrayList<Coordinate> points;

    public Ventline(Coordinate start, Coordinate end) {
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
        points.add(start);

        int x_signum = Integer.signum(end.x-start.x);
        int y_signum = Integer.signum(end.y-start.y);

        int xvalue = start.x;
        int yvalue = start.y;

        while (xvalue != end.x || yvalue != end.y){
            if (xvalue != end.x){
                xvalue = xvalue + x_signum*1;
            }
            if (yvalue != end.y){
                yvalue = yvalue + y_signum*1;
            }
            points.add(new Coordinate(xvalue, yvalue));
        }

        return points;
    }
}
