import java.math.BigDecimal;

public class Ticket {
    private int ticketId;
    private String eventName;
    private String hallNumber;
    private BigDecimal ticketPrice;


    // Constructor method to create a new Ticket object
    public Ticket(int ticketId, String eventName, String hallNumber, BigDecimal ticketPrice) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.hallNumber = hallNumber;
        this.ticketPrice = ticketPrice;
    }

    // Convert the ticket details to a string representation
    @Override
    public String toString() {
        return "Ticket{" +
                "Ticket Id=" + ticketId +
                ", Event Name='" + eventName + '\'' +
                ", Hall Number='" + hallNumber + '\'' +
                ", Ticket price=" + ticketPrice +
                '}';
    }
}
