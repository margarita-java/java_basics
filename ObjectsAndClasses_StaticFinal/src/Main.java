import static java.math.BigInteger.TWO;

public class Main {
    public static void main(String[] args) {

        Computer computerPetya = new Computer("China", "ПК Пети",
                new Processor(Frequency.THREE, NumberOfCores.TWO, Performance.CHINA, 88),
                new RAM(TypeOfRAM.SRAM, VolumeOfRAM.TWO,88),
                new StorageOfInformation(TypeOfStorage.HDD, VolumeOfStorage.TWOGB, 55),
                new Screen(Diagonal.TWENTYFOUR, TypeOfScreen.TN, 77),
                new Keyboard(TypeOfKeyboard.MEMBRANE, Backlight.YES, 66);

        System.out.println(computerPetya);






    }
}
