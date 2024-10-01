public class Computer {

    private final String vendor;
    private final String name;
    public Processor processor;
    public RAM RAM;
    public StorageOfInformation storageOfInformation;
    public Display display;
    public Keyboard keyboard;
    public double totalWeight;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }
    public Computer (String vendor, String name, double totalWeight) {
        this.vendor = vendor;
        this.name = name;
    }

    public Computer(String vendor,
                    String name,
                    Processor processor,
                    RAM RAM,
                    StorageOfInformation storageOfInformation,
                    Display display,
                    Keyboard keyboard,
                    double totalWeight) {
        this.vendor = vendor;
        this.name = name;
        this.display = new Display(display.getDiagonal(), display.getType(), display.getWeight());
        this.RAM = new RAM(RAM.getType(), RAM.getVolume(), RAM.getWeight());
        this.keyboard = new Keyboard(keyboard.getType(), keyboard.isBacklight(), keyboard.getWeight());
        this.processor = new Processor(processor.getFrequency(), processor.getNumberOfCores(), processor.getPerformance(), processor.getWeight());
        this.storageOfInformation = new StorageOfInformation(storageOfInformation.getType(), storageOfInformation.getAmountOfRAM(), storageOfInformation.getWeight());
        this.totalWeight = getTotalWeight();
        }


    public String getVendor() {
        return vendor;
    }

    public Computer setVendor(String vendor) {
        return new Computer(vendor, name, processor,
                RAM, storageOfInformation, display,
                keyboard, totalWeight);

    }
    public String getName() {
        return name;
    }

    public Computer setName(String name) {
        return new Computer(vendor, name, processor,
                RAM, storageOfInformation, display,
                keyboard, totalWeight);

    }
    public Processor getProcessor() {
        return processor;
    }

    public Computer setProcessor(Processor processor) {
        return new Computer(vendor, name, processor,
                RAM, storageOfInformation, display,
                keyboard, totalWeight);

    }
    public RAM getRAM() {
        return RAM;
    }
    public Computer setRAM (RAM RAM) {
        return new Computer(vendor, name, processor,
                RAM, storageOfInformation, display,
                keyboard, totalWeight);
    }
    public StorageOfInformation getStorageOfInformation() {
        return storageOfInformation;
    }
    public Computer setStorageOfInformation (StorageOfInformation storageOfInformation) {
        return new Computer(vendor, name, processor,
                RAM, storageOfInformation, display,
                keyboard, totalWeight);
    }
    public Display getDisplay() {
        return display;
    }
    public Computer setDisplay (Display display) {
        return new Computer(vendor, name, processor,
                RAM, storageOfInformation, display,
                keyboard, totalWeight);
    }
    public Keyboard getKeyboard() {
        return keyboard;
    }
    public Computer setKeyboard (Keyboard keyboard) {
        return new Computer(vendor, name, processor,
                RAM, storageOfInformation, display,
                keyboard, totalWeight);
    }

    public double getTotalWeight() {
        return processor.getWeight() + RAM.getWeight() + storageOfInformation.getWeight() + display.getWeight() + keyboard.getWeight();
    }

    public String toString() {
        return "Данные о компьютере: " + "\n " + "Производитель " + vendor +
                "\n " + "Название " + name + "\n " + "Процессор " + processor +
                "\n " + "Оперативная память" + RAM +
                "\n " + "Накопитель информации" + storageOfInformation +
                "\n " + "Экран" + display +
                "\n " + "Клавиатура" + keyboard;
    }





}