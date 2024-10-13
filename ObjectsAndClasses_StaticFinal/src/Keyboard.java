public class Keyboard {

    private final TypeOfKeyboard typeOfKeyboard;
    private final Backlight backlight;
    private final int weightOgKeyboard;


    public Keyboard(TypeOfKeyboard typeOfKeyboard, Backlight backlight, int weightOgKeyboard) {
        this.typeOfKeyboard = typeOfKeyboard;
        this.backlight = backlight;
        this.weightOgKeyboard = weightOgKeyboard;
    }
    public TypeOfKeyboard getTypeOfKeyboard() {
        return typeOfKeyboard;
    }
    public Backlight getBacklight() {
        return backlight;
    }
    public int getWeightOgKeyboard() {
        return weightOgKeyboard;
    }

    public String toString() {
        return "Клавиатура: " + "\n" +
                "Тип: " + typeOfKeyboard + "\n" +
                "Наличие подсветки: " + backlight + "\n" +
                "Вес клавиатуры: " + weightOgKeyboard + "\n";
    }
}
