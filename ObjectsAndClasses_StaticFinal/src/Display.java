public class Display {
    private final double diagonal;
    private final TypeOfDisplay type;
    private final double weight;

    public Display(double diagonal, TypeOfDisplay type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }


    public double getDiagonal() {
        return diagonal;
    }
    public TypeOfDisplay getType() {
        return type;
    }
    public double getWeight() {
        return weight;
    }
}
