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
    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
    public RAM getRAM() {
        return RAM;
    }

    public void setRAM(RAM RAM) {
        this.RAM = RAM;
    }
    public StorageOfInformation getStorageOfInformation() {
        return storageOfInformation;
    }

    public void setStorageOfInformation(StorageOfInformation storageOfInformation) {
        this.storageOfInformation = storageOfInformation;
    }
    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }


    public String toString() {
        return "Производитель: " + vendor + "\n" +
                "Имя: " + name + "\n" + "\n" +
                processor.toString() + "\n" +
                RAM.toString() + "\n" +
                screen.toString() + "\n" +
                storageOfInformation.toString() + "\n" +
                keyboard.toString() + "\n" +
                "Общий вес: " + calculateTotalWeight();
    }







}