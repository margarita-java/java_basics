public class Screen {

    private final Diagonal diagonal;
    private final TypeOfScreen typeOfScreen;
    private final int weightOfScreen;


    public Screen(Diagonal diagonal, TypeOfScreen typeOfScreen, int weightOfScreen) {
        this.diagonal = diagonal;
        this.typeOfScreen = typeOfScreen;
        this.weightOfScreen = weightOfScreen;
    }

    public Diagonal getDiagonal() {
        return diagonal;
    }

    public TypeOfScreen getTypeOfScreen() {
        return typeOfScreen;
    }

    public int getWeightOfScreen() {
        return weightOfScreen;
    }

    public String toString() {
        return "Экран: " + "\n" +
                "Диагональ: " + diagonal + "\n" +
                "Тип: " + typeOfScreen + "\n" +
                "Вес экрана: " + weightOfScreen + "\n";
    }
}