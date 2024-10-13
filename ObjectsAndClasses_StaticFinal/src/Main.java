import static java.math.BigInteger.TWO;

public class Main {
    public static void main(String[] args) {
        Processor processorPetya = new Processor(Frequency.THREE, NumberOfCores.TWO, Performance.CHINA, 99);
        RAM ramPetya = new RAM(TypeOfRAM.SRAM, VolumeOfRAM.TWO, 55);
        StorageOfInformation storageOfInformationPetya = new StorageOfInformation(TypeOfStorage.HDD,VolumeOfStorage.TWOGB,88);
        Screen screenPetya = new Screen(Diagonal.TWENTYFOUR, TypeOfScreen.VA, 7);
        Keyboard keyboardPetya = new Keyboard(TypeOfKeyboard.MEMBRANE, Backlight.YES, 11);

        Computer computePetya = new Computer("Китай", "ПК Пети",
                processorPetya, ramPetya, storageOfInformationPetya,screenPetya,
                keyboardPetya, 8);

        System.out.println(computePetya);




    }
}
