import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;
    private static final Logger queryLogger = LogManager.getLogger("QueryLogger");
    private static final Logger errorLogger = LogManager.getLogger("ErrorLogger");



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            // Проверка на случай, если команда введена без параметров
            if (tokens.length < 1) {
                System.out.println(COMMAND_ERROR);
                errorLogger.warn("Command entered without parameters");
                continue;
            }
            try {

                if (tokens[0].equals("add")) {
                    if (tokens.length < 2) {
                        System.out.println("Error: Missing customer data for 'add' command.");
                        continue;
                    }
                    executor.addCustomer(tokens[1]);
                    queryLogger.info("Added new customer: " + tokens[1]);

                } else if (tokens[0].equals("list")) {
                    executor.listCustomers();
                    queryLogger.info("Listed customers");

                } else if (tokens[0].equals("remove")) {
                    if (tokens.length < 2) {
                        System.out.println("Error: Missing customer name for 'remove' command.");
                        errorLogger.warn("Missing customer name for 'remove' command");
                        continue;
                    }
                    executor.removeCustomer(tokens[1]);
                    queryLogger.info("Removed customer: " + tokens[1]);

                } else if (tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                    queryLogger.info("Customer count requested");

                } else if (tokens[0].equals("help")) {
                    System.out.println(helpText);

                } else {
                    System.out.println(COMMAND_ERROR);
                    errorLogger.warn("Invalid command entered: " + command);
                }
            } catch (CustomerStorage.InvalidDataFormatException |
                     CustomerStorage.InvalidEmailFormatException |
                     CustomerStorage.InvalidPhoneFormatException e) {
                System.out.println("Error: " + e.getMessage());
                errorLogger.error("Exception occurred: " + e.getMessage(), e);
            }
        }
    }
}
