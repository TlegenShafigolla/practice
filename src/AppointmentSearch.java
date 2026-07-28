import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentSearch {
    static class Appointment {
        private final long id;
        private final String patientName;
        private final boolean cancelled;

        Appointment(long id, String patientName, boolean cancelled) {
            this.id = id;
            this.patientName = patientName;
            this.cancelled = cancelled;
        }

        public long getId() {
            return id;
        }

        public String getPatientName() {
            return patientName;
        }

        public boolean isCancelled() {
            return cancelled;
        }
    }

    private static Optional<Appointment> findAppointmentById(
            List<Appointment> appointments,
            long appointmentId
    ) {
        for (Appointment appointment : appointments) {
            if (appointment.getId() == appointmentId) {
                return Optional.of(appointment);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1L, "Alex", false));
        appointments.add(new Appointment(2L, "Maria", true));
        appointments.add(new Appointment(3L, "John", false));

        long appointmentId = 1L;

        Appointment appointment = findAppointmentById(appointments, appointmentId).orElseThrow(
                () -> new IllegalArgumentException(
                        "Appointment with id " + appointmentId + " not found"
                )
        );
        if (appointment.isCancelled()) {
            System.out.println("Appointment with id " + appointmentId + " is cancelled");
        } else {
            System.out.println("Appointment found for: " + appointment.getPatientName());
        }
    }
}
