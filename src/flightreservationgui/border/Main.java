/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationgui.border;

import flightreservationgui.border.TestFiller;

/**
 *
 * @author Håkon Haram, Robin Thorholm, Bjørnar Tenfjord, Erlend Knudsen
 * @version 1.0 (14.02.2017)
 */
public class Main
{

    private static TestFiller filler;

    private static final boolean DEBUG = true;

    /**
     * @param args the command line arguments.
     */
    public static void main(String[] args)
    {
       // filler = new TestFiller();
        if (DEBUG == true)
        {

            filler.startFillingRegister();

        }
        else
        {
            ApplicationUI appUI = new ApplicationUI();
            appUI.start();
        }
        /*
        System.out.println("test");
        SeatRegister seatReg = new SeatRegister(4, 4);
        Seat getSeat = seatReg.getSeatById("3B"); 
        
        Flight newflight = new  Flight("#F242", "ALE", 
                "OSL", 13, 30, 14, 30, 1, 1, 2017, 31, 1, 2017, 5, 6);
        newflight.getFlightTime();
         */

    }

}
