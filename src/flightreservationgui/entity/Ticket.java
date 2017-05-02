package flightreservationgui.entity;

/**
 * Creates a ticket for the passenger with all information regarding his/her
 * flight.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class Ticket
{

    private final Passenger passenger;
    private final Flight flight;
    private final Seat seat;
    private final String flightID;
    private final int ticketID;
    private int price;

    /**
     * Creates a ticket with information about passengers name, flight
     * information, seat number and flightID
     *
     * @param passenger The given passenger
     * @param flight The given flight
     * @param seat The given seat
     * @param flightID The given flight ID
     * @param ticketID The given ticket ID
     * @param price The given price
     */
    public Ticket(Passenger passenger, Flight flight, Seat seat,
            String flightID, int ticketID, int price)
    {
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.ticketID = ticketID;
        this.flightID = flightID;
        this.price = price;
    }

    /**
     * Returns the ticket ID.
     *
     * @return The ticketID.
     */
    public int getTicketID()
    {
        return ticketID;
    }

    /**
     * Returns the seat object.
     *
     * @return The seat object.
     */
    public Seat getSeat()
    {
        return seat;
    }

    /**
     * Returns the passenger object.
     *
     * @return The passenger object.
     */
    public Passenger getPassenger()
    {
        return passenger;
    }

    /**
     * Returns the flight object.
     *
     * @return The flight object.
     */
    public Flight getFlight()
    {
        return flight;
    }

    /**
     * Returns the flightID of the flight.
     *
     * @return The flightID.
     */
    public String getFlightID()
    {
        return flightID;
    }

    /**
     * Returns the price of the ticket.
     *
     * @return The price.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Sets the price of the ticket.
     *
     * @param price The price of the ticket.
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
}
