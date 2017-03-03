/**
 * Created by BHarris on 3/3/17.
 */
public class Calculator {
    Meal meal;
    public Calculator(Meal meal) {
        this.meal = meal;
    }

    public double correctionFactorPercent(){
        return 1/meal.getCorrectionFactor();
    }

    public double carbUnit() {
        return meal.getCarb() / 10.0;
    }

    public double fatProteinUnit(){
        return ((4 * meal.getProtein()) + (9 * meal.getFat())) / 100;
    }

    public double halfPieceCarbUnit(){
        double cu = carbUnit();
        double cuTemp = (cu * 100) % 100.0;
        double cuDecimal = cuTemp / 100.0;
        double cuRounded = checkRounding(cu, cuDecimal);
        return cuRounded;
    }

    public double halfPieceFatProteinUnit(){
        double fu = fatProteinUnit();
        double fuTemp = (fu * 100) % 100.0;
        double fuDecimal = fuTemp / 100.0;
        double fuRounded = checkRounding(fu, fuDecimal);
        return fuRounded;
    }

    public double checkRounding(double unit, double unitDecimal){
        double rounded = 0;
        if(unitDecimal < .25) {
            rounded = unit - unitDecimal;
        }else if(unitDecimal >= .25 && unitDecimal <= .75 ){
            rounded = (unit - unitDecimal) + .5;
        }else{
            rounded = (unit - unitDecimal) + 1;
        }
        return rounded;
    }

    public double calculateDoseOfInsulin(){
        double cdi = (halfPieceCarbUnit() + halfPieceFatProteinUnit()) * (meal.getInsulinRatio() / 10);
        return cdi;
    }

    public double cuPerc(){
        double cuPerc = halfPieceCarbUnit() / (halfPieceCarbUnit() + halfPieceFatProteinUnit());
        return cuPerc;
    }

    public double calculateBolusNormal(){
        double bolusNormal;
        if (cuPerc() < .2) {
            bolusNormal = 0;
        } else if(cuPerc() > .2 && cuPerc() <= .8){
            bolusNormal = carbUnit() * (10/meal.getInsulinRatio()) * (1-correctionFactorPercent());
        } else  {
            bolusNormal = carbUnit() * (10/meal.getInsulinRatio());
        }

        return bolusNormal;
    }

    public double calculateBolusSquare(){
        double bolusSquared = 0;
        if (halfPieceFatProteinUnit() < 1.0) {
            bolusSquared = 0;
        }
        if (cuPerc() < .2) {
            bolusSquared += (halfPieceFatProteinUnit() * 10/meal.getInsulinRatio());
        } else if (cuPerc() >= .2 && cuPerc() <= .8) {
            bolusSquared += (halfPieceFatProteinUnit() * 10/meal.getInsulinRatio() * (1 + correctionFactorPercent()));
        } else if (cuPerc() > .8) {
            bolusSquared = 0;
        }

        return bolusSquared;
    }

    public int calculateSquareBolusTime() {
        int time = 0;
        if (halfPieceFatProteinUnit() < 1 || cuPerc() > .8) {
            time = 0;
        } else if (halfPieceFatProteinUnit() >= 1 && halfPieceFatProteinUnit() < 2.0) {
            time = 3;
        } else if (halfPieceFatProteinUnit() >= 2 && halfPieceFatProteinUnit() < 3.0){
            time = 4;
        } else if (halfPieceFatProteinUnit() >= 3 && halfPieceFatProteinUnit() < 4.0){
            time = 5;
        } else if (halfPieceFatProteinUnit() >= 4){
            time=8;
        }

        return time;
    }

}
