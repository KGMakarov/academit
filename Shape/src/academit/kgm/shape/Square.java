package academit.kgm.shape;

/**
 * Created by ROCKfeller on 22.05.2016.
 */
public class Square implements Shape {
    private double sideLength;

    public Square (double sideLength){
        this.sideLength = sideLength;
    }

    public double getWidth (){
        return sideLength;
    }
    public double getHeight(){
        return sideLength;
    }
    public double getArea(){
        return sideLength * sideLength;
    }
}
