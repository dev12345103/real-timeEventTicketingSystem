import java.util.Queue;
import java.util.LinkedList;


// Represents a thread-safe pool of tickets for an event
public class TicketPool {
    private final int maximumCapacity; // Maximum number of tickets allowed in the pool
    private final Queue<Ticket> tickets = new LinkedList<>(); // Queue to store tickets in the pool

    public TicketPool(int MaximumCapacity){
        this.maximumCapacity = MaximumCapacity;

    }

    // Add ticket method to add tickets which is used by vendors
    public synchronized void addTickets(Ticket ticket){
        // Wait until there is space in the pool
        while (tickets.size() >= maximumCapacity){
            try{
                wait(); //Wait if the pool is full
            } catch (InterruptedException e){
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
        this.tickets.add(ticket); // Add the ticket to the pool
        notifyAll(); // Notifying all waiting threads of vendors or customers
        System.out.println(Thread.currentThread().getName() + " has added a ticket to the pool, current size is " + tickets.size() + ".");
    }



    // Buy ticket to buy tickets which is used by customers
    public synchronized Ticket buyTicket(){
        // Wait until there is at least one ticket in the pool
        while (tickets.isEmpty()) {
            try {
                wait(); //Wait if the pool is empty
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        //Remove and return the first ticket from the pool
        Ticket ticket = tickets.poll();
        notifyAll(); //Notifying threads
        System.out.println(Thread.currentThread().getName() + " has bought a ticket from the ticket pool, current size is " + tickets.size() + ".");

        return ticket;
    }


}
