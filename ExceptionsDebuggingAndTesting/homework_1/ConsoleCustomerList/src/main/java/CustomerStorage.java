import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        // Проверка количества компонентов
        if (components.length != 4) {
            throw new InvalidDataFormatException(
                    "Некорректный формат данных. Ожидалось 4 компонента: имя, фамилия, email, телефон."
            );
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        String email = components[INDEX_EMAIL];
        String phone = components[INDEX_PHONE];

        // Проверка формата email
        if (!email.matches("^.+@.+\\..+$")) { // Регулярное выражение для email
            throw new InvalidEmailFormatException("Некорректный формат email: " + email);
        }

        // Проверка формата номера телефона
        if (!phone.matches("^\\+?\\d{10,15}$")) { // Регулярное выражение для телефона
            throw new InvalidPhoneFormatException("Некорректный формат номера телефона: " + phone);
        }

        // Если все проверки пройдены, добавляем клиента
        storage.put(name, new Customer(name, phone, email));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    // Исключение для некорректного количества компонентов в строке данных
    public class InvalidDataFormatException extends RuntimeException {
        public InvalidDataFormatException(String message) {
            super(message); // Передаём сообщение об ошибке в конструктор RuntimeException
        }
    }

    // Исключение для неправильного формата email
    public class InvalidEmailFormatException extends RuntimeException {
        public InvalidEmailFormatException(String message) {
            super(message);
        }
    }

    // Исключение для неверного формата номера телефона
    public class InvalidPhoneFormatException extends RuntimeException {
        public InvalidPhoneFormatException(String message) {
            super(message);
        }
    }
}

