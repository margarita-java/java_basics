public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40, 5,2);
        basket.add("Water", 20, 2,1.3);
        basket.print("Milk, Water");

        System.out.println("Общий вес товаров в корзине ");
        System.out.println(basket.getTotalWeight());
    }
}
