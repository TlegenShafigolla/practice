public class AppointmentBookingService {
    static class InvalidAppointmentException extends Exception {
        public InvalidAppointmentException(String message) {
            super(message);
        }
    }

    private static void bookAppointment(
            String patientName,
            int appointmentHour
    ) throws InvalidAppointmentException {
        if (patientName == null || patientName.isBlank()) {
            throw new InvalidAppointmentException("Patient name is invalid");
        }
        if (appointmentHour < 9 || appointmentHour > 18) {
            throw new InvalidAppointmentException("Appointment hour must be between 9 and 18");
        }
        System.out.println(
                "Appointment booked for "
                        + patientName
                        + " at "
                        + appointmentHour
                        + ":00"
        );
    }

    public static void main(String[] args) {
        String patientName = "Maria";
        int appointmentHour = 14;
        try {
            bookAppointment(patientName, appointmentHour);
        } catch (InvalidAppointmentException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
