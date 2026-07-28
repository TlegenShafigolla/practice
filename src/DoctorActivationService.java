import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorActivationService {
    static class Doctor {
        private final long id;
        private final String name;
        private boolean active;

        Doctor(long id, String name, boolean active) {
            this.id = id;
            this.name = name;
            this.active = active;

        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }

    }

    static class DoctorNotFoundException extends RuntimeException {
        DoctorNotFoundException(String message) {
            super(message);
        }
    }

    private static Optional<Doctor> findDoctorById(
            List<Doctor> doctors,
            long doctorId
    ) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == doctorId) {
                return Optional.of(doctor);
            }
        }
        return Optional.empty();
    }

    private static void activateDoctor(
            List<Doctor> doctors,
            long doctorId
    ) {
        Doctor doctor = findDoctorById(doctors, doctorId).orElseThrow(
                () -> new DoctorNotFoundException("Doctor with id " + doctorId + " not found")
        );
        if (doctor.isActive()) {
            System.out.println("Doctor is already active");
            return;
        }
        doctor.setActive(true);
        System.out.println("Doctor " + doctor.getName() + " activated");

    }

    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(1, "Alex", true));
        doctors.add(new Doctor(2, "Maria", false));
        doctors.add(new Doctor(3, "John", true));

        activateDoctor(doctors, 2L);
        activateDoctor(doctors, 1L);
        try {
            activateDoctor(doctors, 10L);
        } catch (DoctorNotFoundException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        activateDoctor(doctors, 3L);
    }
}
