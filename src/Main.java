public class Main {

    public static void main(String[] args) {
        Meal m = new Meal(10, 34.9, 20, 30.4, 42.4);
        Calculator c = new Calculator(m);
        System.out.println("cu: " + c.halfPieceCarbUnit());
        System.out.println("fpu: " + c.halfPieceFatProteinUnit());
        System.out.println("normal bolus: " + c.calculateBolusNormal());
        System.out.println("Bolussquared: " + c.calculateBolusSquare());
        System.out.println("bsquaredTime: " + c.calculateSquareBolusTime());
    }
}
