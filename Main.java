import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration config;

        // Welcome message
        System.out.println("|--------------------------------------------------------------------------------------------|");
        System.out.println("|                      Welcome to Real-Time Event Ticketing System                           |");
        System.out.println("|--------------------------------------------------------------------------------------------|");

        // Prompt the user to decide whether to load settings from a file or configure manually.
        String choice = "";
        while (true) {
            System.out.println("\nDo you want to load settings from file? (yes/no): ");
            choice = scanner.nextLine().trim().toLowerCase();  // convert to lowercase

            if (choice.equals("yes") || choice.equals("no")) {
                break;  // Exit the loop if valid input is entered
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }

        // Handle configuration loading based on the user's choice
        if (choice.equals("yes")) {
            try {
                // Load configuration settings from a file
                config = Configuration.loadFromFile("config.json");
                System.out.println("\nSettings loaded successfully!\n");
            } catch (IOException e) {
                // If the loading fails, fallback to manual input
                System.out.println("\nError loading settings. Defaulting to manual input.\n");
                config = getConfigurationFromUser(scanner);
            }
        } else {
            // Manually input configuration settings
            config = getConfigurationFromUser(scanner);
            try {
                // Save the manually entered settings to a file for future use
                Configuration.saveToFile(config, "config.json");
                System.out.println("\nSettings saved successfully!\n");
            } catch (IOException e) {
                // Handle potential errors during file saving
                System.out.println("\nError saving settings: " + e.getMessage() + " ");
            }
        }

        // Create TicketPool using the loaded configuration
        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());

        // Initialize and start Vendor threads
        Vendor[] vendors = new Vendor[6]; // Create 6 vendors
        for (int i = 0; i < vendors.length; i++) {
            vendors[i] = new Vendor(ticketPool, config.getTotalTickets(), config.getTicketReleaseRate());
            Thread vendorThread = new Thread(vendors[i], "Vendor-" + (i + 1));
            vendorThread.start(); // Start the vendor thread
        }

        // Initialize and start Customer threads
        Customer[] customers = new Customer[10];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(ticketPool, config.getCustomerRetrievalRate(), 5);
            Thread customerThread = new Thread(customers[i], "Customer-" + (i + 1));
            customerThread.start(); // Start the customer thread
        }

        scanner.close(); // Close the Scanner to release system resources
    }

    private static Configuration getConfigurationFromUser(Scanner scanner) {
        System.out.print("\nEnter Total Number of Tickets:\n ");
        int totalTickets = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Ticket Release Rate:\n ");
        int ticketReleaseRate = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Customer Retrieval Rate:\n ");
        int customerRetrievalRate = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Maximum Ticket Capacity:\n ");
        int maxTicketCapacity = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        // Return the Configuration object with the user-defined settings
        return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);


    }
}
