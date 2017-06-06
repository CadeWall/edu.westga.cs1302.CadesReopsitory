package edu.westga.cs1302.arrays.model;

/**
 * Maintain the appointments for one day in a diary.
 *
 * @author David J. Barnes and Michael Kolling
 * MODIFIED BY:
 *
 * @version 2008.03.30
 * MODIFIED ON:
 */
public class Workday {
    /**
     *  The first bookable hour in a day.
     */
    public static final int START_OF_DAY = 8;
    /**
     *  The last bookable hour in a day.
     */
    public static final int FINAL_APPOINTMENT_TIME = 18;
    /**
     * The number of bookable hours in a day.
     */
    public static final int MAX_APPOINTMENTS_PER_DAY =
                                FINAL_APPOINTMENT_TIME - START_OF_DAY + 1;

    // A day number within a particular year. (1-366)
    private int workDayNumber;
    // The current list of appointments for this day.
    private Appointment[] appointments;

    /**
     * Constructor for objects of class Day.
     *
     * @param dayNumber The number of this day in the year
     *
     * @precondition 	0 <= dayNumber <= 366
     */
    public Workday(int dayNumber) {
        this.workDayNumber = dayNumber;
        this.appointments = new Appointment[MAX_APPOINTMENTS_PER_DAY];
    }

    /**
     * Returns the number of this day in the year
     *
     * @precondition	None
     * @return 			The number of this day within the year (1 - 366).
     */
    public int getWorkDayNumber() {
        return this.workDayNumber;
    }

    /**
     * Try to find space for an appointment.
     * @param appointment The appointment to be accommodated
     *
     * @precondition	None
     *
     * @return The earliest time today that can accommodate
     *         the appointment. Return -1 if there is
     *         insufficient space.
     */
    public int findSpace(Appointment appointment) {
        int duration = appointment.getDuration();

        if (duration == 1) {
        	return this.findSingleTimeSlot(appointment);
        }

        int slot = 0;
        while (slot < MAX_APPOINTMENTS_PER_DAY && this.appointments[slot] == null) {
        	int time = START_OF_DAY + slot;
            // How many more slots are needed?
            int extraSlotsRequired = duration - 1;
            for (int nextSlot = slot + 1;
                        extraSlotsRequired > 0
                        && this.appointments[nextSlot] == null;
                            nextSlot++) {
                extraSlotsRequired--;
            }
            if (extraSlotsRequired == 0) {
                // A big enough space has been found.
                return time;
            }
        	slot++;
        }

        // Not enough space available.
        return -1;
    }

    /**
     * Locates and returns the first available time slot
     *
     * @param appointment	The appointment to be placed
     * @return				The first available time slot in the day
     */
	private int findSingleTimeSlot(Appointment appointment) {
		int slotTime = 0;
		while (slotTime < MAX_APPOINTMENTS_PER_DAY
				&& this.appointments[slotTime] == null) {
			slotTime++;
		}
        return START_OF_DAY + slotTime;
	}

	/**
     * Make an appointment.
     * @param 	time 			The hour at which the appointment starts.
     * @param 	appointment 	The appointment to be made.
     *
     * @precondition	appointment != null
     *
     * @return 	true if the appointment was successful,
     *         false otherwise.
     */
    public boolean addAppointment(int time, Appointment appointment) {
    	int startTime = time - START_OF_DAY;
        if (appointment == null
        		  || !this.validTime(time)
        		  || this.appointments[startTime] != null) {
        	return false;
        }

        if (this.appointments[startTime] == null) {
            int duration = appointment.getDuration();
            // Fill in all the slots for the full duration
            // of the appointment.
            for (int slotIncrement = 0; slotIncrement < duration; slotIncrement++) {
                this.appointments[startTime + slotIncrement] = appointment;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the appointment at the specified time
     *
     * @param 			time 	Which time of day.
     *
     * @precondition	START_OF_DAY <= time <= FINAL_APPOINTMENT_TIME
     *
     * @return 			The Appointment at the given time. null is returned
     *         				if either the time is invalid or there is no
     *         				Appointment at the given time.
     */
    public Appointment getAppointment(int time) {
        if (this.validTime(time)) {
            return this.appointments[time - START_OF_DAY];
        } else {
            return null;
        }
    }

    /**
     * Print a list of the day's appointments on standard output.
     *
     * @precondition	None
     * @postcondition	None
     */
    public void showAppointments() {
        System.out.println("=== Day " + this.workDayNumber + " ===");
        int time = START_OF_DAY;
        for (Appointment appointment : this.appointments) {
            System.out.print(time + ": ");
            if (appointment != null) {
                System.out.println(appointment.getDescription());
            } else {
                System.out.println();
            }
            time++;
        }
    }

    /**
     * Checks whether this is a valid appointment time or not
     *
     * @param	time	The possible time to be checked
     * @precondition	START_OF_DAY <= time <= FINAL_APPOINTMENT_TIME
     *
     * @return 			true if the time is between FINAL_APPOINTMENT_TIME and
     *         				END_OF_DAY, false otherwise.
     */
    public boolean validTime(int time) {
        return time >= START_OF_DAY && time <= FINAL_APPOINTMENT_TIME;
    }
}
