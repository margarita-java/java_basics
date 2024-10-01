
public class Main {
    public static void main(String[] args) {

        Processor processor1 = new Processor(1, 4,  "Китай", 1500);
        RAM RAM1 = new RAM("ЕЕ", 16, 600);
        StorageOfInformation storageOfInformation1 = new StorageOfInformation(TypeOfStorage.HDD, 8, 600);
        Display display1 = new Display(13, TypeOfDisplay.IPS, 400);
        Keyboard keyboard1 = new Keyboard("Офисная", false, 800);

        Computer computer1 = new Computer("Китай", "ПК1");
        computer1.setProcessor(processor1);
        computer1.setRAM(RAM1);
        computer1.setStorageOfInformation(storageOfInformation1);
        computer1.setDisplay(display1);
        computer1.setKeyboard(keyboard1);

        System.out.println(computer1.toString());



    }
}
