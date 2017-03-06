/**
 * Created by BHarris on 3/3/17.
 */
public class Meal {
    private int id;
    private double insulinRatio;
    private double carb;
    private double protein;
    private double fat;
    private double correctionFactor;

    public Meal(int id, double insulinRatio, double correctionFactor, double carb, double protein, double fat) {
        this.id = id;
        this.insulinRatio = insulinRatio;
        this.correctionFactor = correctionFactor;
        this.carb = carb;
        this.protein = protein;
        this.fat = fat;
    }
    public Meal(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getInsulinRatio() {
        return insulinRatio;
    }

    public void setInsulinRatio(double insulinRatio) {
        this.insulinRatio = insulinRatio;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCorrectionFactor() {
        return correctionFactor;
    }

    public void setCorrectionFactor(double correctionFactor) {
        this.correctionFactor = correctionFactor;
    }
}
