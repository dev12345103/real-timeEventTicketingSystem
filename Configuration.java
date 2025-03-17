import java.io.*;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;


// Represents the configuration settings for the ticketing system
public class Configuration implements Serializable {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;


    // Constructor method to initialize configuration settings
    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    // Getters for accessing configuration properties
    public int getTotalTickets(){
        return totalTickets;
    }
    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    // Saves the current Configuration settings to a JSON file
    public static void saveToFile(Configuration config, String fileName) throws IOException {
        if (config == null) {
            throw new IllegalArgumentException("Configuration cannot be null");
        }

        // Use Gson to convert the configuration object to JSON
        Gson gson = new GsonBuilder()
                .setPrettyPrinting() // Pretty prints JSON readability
                .create();

        try (Writer writer = new FileWriter(fileName)) {
            gson.toJson(config, writer); // Serialize configuration to JSON and save to file
        } catch (IOException e) {
            System.err.println("Error saving configuration: " + e.getMessage());
            throw e;
        }
    }

    // Load Configuration from JSON file
    public static Configuration loadFromFile(String fileName) throws IOException {
        Gson gson = new Gson();

        try (Reader reader = new FileReader(fileName)) {
            Configuration config = gson.fromJson(reader, Configuration.class);

            // Validate loaded configuration
            if (config == null) {
                throw new IOException("Failed to parse configuration file");
            }

            return config;
        } catch (IOException e) {
            System.err.println("Error loading configuration: " + e.getMessage());
            throw e;
        }


    }

    // Convert the configuration details to a string representation
    @Override
    public String toString() {
        return "Configuration{" +
                "totalTickets=" + totalTickets +
                ", ticketReleaseRate=" + ticketReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                '}';
    }
}
