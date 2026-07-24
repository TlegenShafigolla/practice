import java.util.ArrayList;
import java.util.List;

public class DoctorSearch {

    static class Doctor {

        private final long id;
        private final String name;
        private final boolean active;

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

    private static Doctor findDoctorById(
            List<Doctor> doctors,
            long doctorId
    ) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == doctorId) {
                return doctor;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();

        doctors.add(new Doctor(1L, "John", true));
        doctors.add(new Doctor(2L, "Jane", false));
        doctors.add(new Doctor(3L, "James", true));

        long doctorId = 2L;

        Doctor doctor = findDoctorById(doctors, doctorId);

        if (doctor != null) {
            System.out.println("Doctor found: " + doctor.getName());
        } else {
            System.out.println("Doctor not found");
        }
    }
}