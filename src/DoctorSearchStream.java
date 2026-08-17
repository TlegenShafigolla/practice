import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorSearchStream {
    static class Doctor {
        private long id;
        private String name;
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
    }

    private static Optional<Doctor> findActiveDoctorById(
            List<Doctor> doctors,
            long doctorId
    ) {
        return doctors.stream()
                .filter(doc -> doc.getId() == doctorId)
                .filter(Doctor::isActive)
                .findFirst();
    }

    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(1L, "Alex", true));
        doctors.add(new Doctor(2L, "Maria", true));
        doctors.add(new Doctor(3L, "John", false));
        long doctorId = 3L;
        Optional<Doctor> doctorOptional = findActiveDoctorById(doctors, doctorId);

        doctorOptional.ifPresentOrElse(doc -> System.out.println("Doctor found: " + doc.getName()), () -> System.out.println("No doctor found or inactive"));
    }
}
