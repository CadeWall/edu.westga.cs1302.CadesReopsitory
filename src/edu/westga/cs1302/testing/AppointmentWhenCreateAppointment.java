package edu.westga.cs1302.testing;

import static org.junit.Assert.*;
import org.junit.Test;
import edu.westga.cs1302.arrays.model.Appointment;
/**
 * This class tests for the creation of an Appointment object
 * 
 * @author Cade Wall
 *@version 6/11/17
 */

public class AppointmentWhenCreateAppointment {
	/**
	 * Tests two parameter constructor for the creation of its variables 
	 * and the creation of an Appointment object
	 */
	@Test	
	public void testTwoParameterConstructorForCreationOfDescriptionAndDuration(){
		Appointment todaysAppointment = new Appointment("fever and sneezing", 2);
		assertEquals("Appointment with fever and sneezing that lasts 2 hour(s)", todaysAppointment.toString());
	}
	
}
