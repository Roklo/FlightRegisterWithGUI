package flightreservationgui.entity;

/**
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class Pilot extends Person
{

    private String certificateNumber;
    private String employeeID;

    /**
     * Creates a new pilot given by his or her forename, lastname, and an email
     * address.
     *
     * @param foreName is the Pilots first name.
     * @param lastName is the Pilots surname.
     * @param emailAddress is the Pilots email adress.
     * @param certificateNumber is the Pilots certificate number.
     * @param employeeID The employee ID
     */
    public Pilot(String foreName, String lastName, String emailAddress,
            String certificateNumber, String employeeID)
    {
        super(foreName, lastName, emailAddress);
        this.certificateNumber = certificateNumber;
        this.employeeID = employeeID;
    }

    /**
     * Gets the Pilot's employee ID.
     *
     * @return the employeeID field.
     */
    @Override
    public String getEmployeeID()
    {
        return this.employeeID;
    }

    /**
     * Gets the Pilot's certificate number
     *
     * @return the certificate number field.
     */
    @Override
    public String getCertificateNumber()
    {
        return this.certificateNumber;
    }

    /**
     *
     * @return The details of the pilot
     */
    @Override
    public String toString()
    {
        return getFirstName() + " " + getLastName();
    }

}
