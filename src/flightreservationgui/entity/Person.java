/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationgui.entity;

/**
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tennfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public abstract class Person
{

    /**
     * Creates a new person given by his or hers forename, lastname, and an
     * email address.
     */
    private final String foreName;
    private final String lastName;
    private final String emailAddress;

    public Person(String foreName, String lastName, String emailAddress)
    {
        this.foreName = foreName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    /**
     * Returns the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirstName()
    {
        return this.foreName;
    }

    /**
     * Returns the last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Returns the email address of the person.
     *
     * @return The email address of the person.
     */
    public String getEmail()
    {
        return this.emailAddress;
    }

    public abstract String getEmployeeID();

    public abstract String getCertificateNumber();

}
