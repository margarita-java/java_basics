public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40, 5,8);

        System.out.println("Общий вес товаров в корзине ");
        System.out.println(basket.getTotalWeight());
    }
}
