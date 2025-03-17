public class Customer implements Runnable{
    private TicketPool ticketPool;
    private int customerRetrievalRate;
    private int quantity;


    // Constructor method to initialize Customer object
    public Customer(TicketPool ticketPool, int customerRetrievalRate, int quantity){
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
        this.quantity = quantity;

    }

    // Executes the customer's ticket purchasing behavior
    @Override
    public void run() {
        // Loop through the number of tickets the customer wants to buy
        for (int i = 0; i < quantity; i++) {
            Ticket ticket = ticketPool.buyTicket(); // Buy a ticket from the ticket pool
            System.out.println("Ticket bought by " + Thread.currentThread().getName() + ": " + ticket);

            try {
                Thread.sleep(customerRetrievalRate * 1000); // Convert seconds to milliseconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

}
