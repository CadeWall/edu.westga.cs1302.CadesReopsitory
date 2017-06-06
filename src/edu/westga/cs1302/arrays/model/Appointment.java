package edu.westga.cs1302.arrays.model;

/**
 * Record details of a diary appointment.
 * 
 * @author David J. Barnes and Michael Kolling
 * MODIFIED BY:
 * 
 * @version 2008.03.30
 * MODIFIED ON:
 */
public class Appointment {
    // The reason for the appointment.
    private String description;
    // The length (in hours) of the appointment.
    private int duration;

    /**
     * Create an appointment with a given duration.
     * @param description The reason for the appointment.
     * @param duration The length of the appointment in hours.
     */
    public Appointment(String description, int duration) {
        this.description = description;
        this.duration = duration;
    }

    /**
     * Returns the description of the appointment
     * 
     * @precondition	None
     * @return 			The description of the appointment.
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Returns the duration of the appointment
     * 
     * @precondition	None
     * @return 			The duration (in hours) of the appointment.
     */
    public int getDuration() {
        return this.duration;
    }
    
    /**
     * Returns a String representation of the Appointment
     * @return	A String representation of the Appointment listing who it is
     * 	with and how long it lasts
     */
    public String toString() {
    	return "Appointment with " + this.description + " that lasts " + this.duration + " hour(s)";
    }
}
