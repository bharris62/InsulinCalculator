/**
 * Created by BHarris on 3/6/17.
 */
public class Bolus {
    double bolusNow;
    double bolusExtended;
    int hours;

    public Bolus(Meal meal){
        Calculator c = new Calculator(meal);
        this.bolusNow = c.calculateBolusNormal();
        this.bolusExtended = c.calculateBolusSquare();
        this.hours = c.calculateSquareBolusTime();
    }

    public Bolus(){}

    public void setBolusNow(double bolusNow) {
        this.bolusNow = bolusNow;
    }

    public void setBolusExtended(double bolusExtended) {
        this.bolusExtended = bolusExtended;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getBolusNow() {
        return bolusNow;
    }

    public double getBolusExtended() {
        return bolusExtended;
    }

    public int getHours() {
        return hours;
    }
}
