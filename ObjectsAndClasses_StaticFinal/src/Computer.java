public class Computer {

    private final String vendor;
    private final String name;
    public Processor processor;
    public RAM RAM;
    public StorageOfInformation storageOfInformation;
    public Screen screen;
    public Keyboard keyboard;
    public double totalWeight;


    public Computer(String vendor,
                    String name,
                    Processor processor,
                    RAM RAM,
                    StorageOfInformation storageOfInformation,
                    Screen screen,
                    Keyboard keyboard,
                    double totalWeight) {
        this.vendor = vendor;
        this.name = name;
        this.screen = screen;
        this.RAM = RAM;
        this.keyboard = keyboard;
        this.processor = processor;
        this.storageOfInformation = storageOfInformation;
        this.totalWeight = calculateTotalWeight ();
        }


    public int calculateTotalWeight() {
        return processor.getWeightProcessor() +
                RAM.getWeightOfRAM() + screen.getWeightOfScreen() +
                storageOfInformation.getWeightOfStorage() +
                keyboard.getWeightOgKeyboard();
    }

    public String getVendor() {
        return vendor;
    }
    public Computer setVendor (String vendor) {
        return new Computer(vendor, name,
                processor, RAM, storageOfInformation,
                screen, keyboard, totalWeight);
    }
    public String getName() {
        return name;
    }
    public Computer setName (String name) {
        return new Computer(vendor, name,
                processor, RAM, storageOfInformation,
                screen, keyboard, totalWeight);
    }

    public String toString() {
        return "Производитель ПК " + vendor + "\n" +
                "Имя ПК " + name + "\n" +
                processor + "\n" +
                RAM + "\n" + storageOfInformation + "\n" +
                screen + "\n" + keyboard + "\n" +
                "Общий вес " + totalWeight + "грамм";
    }







}