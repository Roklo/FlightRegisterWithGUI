package flightreservationgui.entity;

/**
 * The Seat class represents a seat in a flight reservation system. It holds the
 * seat details relevant in our context, such as the seat row, letter (column)
 * and if the seat is available (status). You also have the possibility to
 * change the status of the seat.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class Seat
{

    private final int seatRow;
    private final String seatLetter;
    private boolean available;

    /**
     * Creates a new seat object given by the letter and row number, and sets
     * the seat to be available.
     *
     * @param seatRow The seat row number.
     * @param seatLetter The seat letter (column).
     */
    public Seat(int seatRow, String seatLetter)
    {
        this.seatRow = seatRow;
        this.seatLetter = seatLetter;
        this.available = true;
    }
    
    @Override
    public String toString()
    {
        return getSeatId();
    }

    /**
     * Returns the seat ID given by the seat row and seat letter.
     *
     * @return The seat ID.
     */
    public String getSeatId()
    {
        return (seatRow + seatLetter);
    }

    /**
     * Returns the status of the availability of a seat; true if available,
     * false if not.
     *
     * @return The status of the seat. True if available, false otherwise.
     */
    public boolean isAvailable()
    {
        return this.available;
    }

    /**
     * Sets the seat to be unavailable.
     */
    public void setUnavailable()
    {
        this.available = false;
    }

    /**
     * Sets the seat to be available.
     */
    public void setAvailable()
    {
        this.available = true;
    }
}
