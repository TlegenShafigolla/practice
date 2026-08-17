import java.util.ArrayList;
import java.util.List;

public class DoctorAvailabilityChecker {
    static class Doctor {
        private final String name;
        private final String specialization;
        private final boolean active;

        Doctor(String name, String specialization, boolean active) {
            this.name = name;
            this.specialization = specialization;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public String getSpecialization() {
            return specialization;
        }

        public boolean isActive() {
            return active;
        }
    }

    private static boolean hasActiveDoctorBySpecialization(
            List<Doctor> doctors,
            String specialization
    ) {
        return doctors.stream().anyMatch(doc -> doc.isActive() && doc.getSpecialization().equals(specialization));
    }

    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alex", "Cardiologist", true));
        doctors.add(new Doctor("Maria", "Neurologist", false));
        doctors.add(new Doctor("John", "Cardiologist", true));
        doctors.add(new Doctor("Anna", "Therapist", true));

        String specialization = "Surgeon";

        if (hasActiveDoctorBySpecialization(doctors, specialization)) {
            System.out.println("Active doctor found");
        } else {
            System.out.println("No active doctor found");
        }
    }
}
