import java.io.FileOutputStream;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        FileOutputStream writer = new FileOutputStream("res/numbers.txt");

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        for (int number = 1; number < 1000; number++) {
            int regionCode = 199;
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        String carNumber = firstLetter + padNumber(number, 3) +
                            secondLetter + thirdLetter + padNumber(regionCode, 2);
                        writer.write(carNumber.getBytes());
                        writer.write('\n');
                    }
                }
            }
        }

        writer.flush();
        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {

        StringBuilder sb = new StringBuilder(numberLength);
        int padSize = numberLength - numDigits(number);

        for (int i = 0; i < padSize; i++) {
            sb.append('0');
        }
        sb.append(number);
        return sb.toString();
    }

    private static int numDigits(int number) {
        if (number == 0) return 1;
        int digits = 0;
        while (number != 0) {
            number /= 10;
            digits++;
        }
        return digits;

        /*String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }

        return numberStr;*/
    }
}
