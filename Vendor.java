import java.math.BigDecimal;


// Implements the Runnable interface to allow multithreaded behavior
public class Vendor implements Runnable {
    private TicketPool ticketPool;
    private int totalTickets;
    private int ticketReleaseRate;


    // Constructor method to initialize Vendor object
    public Vendor(TicketPool ticketPool, int totalTickets, int ticketReleaseRate) {
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }


    // Runs the vendor's process of releasing tickets
    @Override
    public void run() {
        for (int i = 1; i <= totalTickets; i++) {
            // Create a new ticket with a unique ID, event details, and price
            Ticket ticket = new Ticket(i, "Event Simple", "Hall-01", new BigDecimal("1000"));
            ticketPool.addTickets(ticket); // Add the ticket to the ticket pool

            System.out.println("Vendor-" + (i) + " released: " + ticket + "\n");
        }


            // Wait for the specified release rate before releasing the next ticket
            try {
                Thread.sleep(ticketReleaseRate * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }

    }

}