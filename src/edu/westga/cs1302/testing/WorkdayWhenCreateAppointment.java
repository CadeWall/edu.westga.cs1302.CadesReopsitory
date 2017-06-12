package edu.westga.cs1302.testing;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.westga.cs1302.arrays.model.Appointment;
import edu.westga.cs1302.arrays.model.Workday;

/**
 * 
 * @author cadewall
 *
 */
public class WorkdayWhenCreateAppointment {
	private Appointment appointmentTester;
	private Workday dayTester;
	private Appointment newAppointment;
	
	
	/**
	 * actions to take place before  tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.dayTester = new Workday(6);
		this.appointmentTester = new Appointment("Cable install", 4);
		this.newAppointment = new Appointment("Cable uninstall", 1);
	}
	
	/**
	 * Tests Workday for the day number
	 * @throws Exception 
	 */
	@Test
	public void getWorkdayNumber() throws Exception{
		this.setUp();
		assertEquals(6, dayTester.getWorkDayNumber());
	}
	
	/**
	 * Tests that the Appointment object can be made
	 * @throws Exception
	 */
	@Test
	public void getAppointment() throws Exception{
		this.setUp();
		assertEquals(true, dayTester.addAppointment(9, appointmentTester));
	}
	
	@Test
	public void testDoubleBookingShouldReturnFalse(){
		dayTester.addAppointment(9, appointmentTester);
		dayTester.addAppointment(11, newAppointment);
		assertEquals(-1, dayTester.findSpace(appointmentTester));
	}

	@Test
	public void testUpperBoundry(){
		dayTester.addAppointment(19, appointmentTester);
		assertEquals(false, dayTester.validTime(19));
	}
	
	@Test
	public void testLowerBoundry(){
		dayTester.addAppointment(7, appointmentTester);
		assertEquals(false, dayTester.validTime(7));
	}
	
	@Test
	public void sunnyDayTest(){
		dayTester.addAppointment(10, appointmentTester);
		assertEquals(true, dayTester.validTime(10));
	}
	
	
}
