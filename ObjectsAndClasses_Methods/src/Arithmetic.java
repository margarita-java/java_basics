public class Arithmetic {
    int theFirstNumber;
    int theSecondNumber;
    public Arithmetic (int theFirstNumber, int theSecondNumber) {
        this.theFirstNumber = theFirstNumber;
        this.theSecondNumber = theSecondNumber;
    }
    public int sum () {
        return theFirstNumber + theSecondNumber;
    }
    public int multiplication () {
        return theFirstNumber * theSecondNumber;
    }
    public String maxMin () {
        if (theFirstNumber > theSecondNumber)
            return "Максимальное из двух чисед = " + theFirstNumber;
        else if (theFirstNumber < theSecondNumber)
            return "Минимальное из двух чисел = " + theFirstNumber;
        else
            return "Числа равны";
    }
}
