package flightreservationgui.entity;

/**
 * The Passenger class represents a passenger in a flight reservation system. It
 * holds the passenger details relevant in our context.
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class Passenger extends Person
{

    /**
     * Creates a new passanger given by his or hers forename, lastname, and an
     * email address.
     *
     * @param foreName is the first name of the passenger
     * @param lastName is the surname of the passenger
     * @param emailAddress is the email adress of the passenger
     */
    public Passenger(String foreName, String lastName, String emailAddress)
    {
        super(foreName, lastName, emailAddress);
    }

    /**
     * Creates a string from the passengers fields.
     *
     * @return a string of the passengers fields.
     */
    @Override
    public String toString()
    {
        return getFirstName() + " " + getLastName();
    }

    /**
     * returns an error message since the passenger is not an employee.
     *
     * @return a String errror message.
     */
    @Override
    public String getEmployeeID()
    {
        return "Passengers do not have an employee ID.";
    }

    /**
     * Return an error message since the passenger doesnt have a certificate.
     *
     * @return The certificate number
     */
    @Override
    public String getCertificateNumber()
    {
        return "Passengers do not have a certificate number.";
    }

}
