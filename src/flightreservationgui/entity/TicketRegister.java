package flightreservationgui.entity;

import java.util.HashSet;
import java.util.Iterator;

/**
 * The TicketRegister class represents a ticket register in a flight reservation
 * system where you can add and remove passengers.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class TicketRegister
{

    private HashSet<Ticket> tickets;

    /**
     * Constructor for objects of class TicketRegister.
     */
    public TicketRegister()
    {
        this.tickets = new HashSet<>();
    }

    /**
     * Adds the given ticket to the ticket register.
     *
     * @param ticket The ticket to be added.
     */
    public void addTicket(Ticket ticket)
    {
        this.tickets.add(ticket);
    }

    /**
     * Removes the given ticket from the ticket register.
     *
     * @param ticket The ticket to be removed.
     */
    public void removeTicket(Ticket ticket)
    {
        this.tickets.remove(ticket);
    }

    /**
     * Returns the iterator of the Ticket Register class.
     *
     * @return The iterator of the Ticket Register class.
     */
    public Iterator<Ticket> getTicketRegIterator()
    {
        return this.tickets.iterator();
    }
}
