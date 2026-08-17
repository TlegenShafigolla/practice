import java.util.ArrayList;
import java.util.List;

public class DoctorInactiveChecker {
    static class Doctor {
        private final String name;
        private final boolean active;

        public Doctor(String name, boolean active) {
            this.name = name;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public boolean isActive() {
            return active;
        }
    }

    private static boolean hasNoInactiveDoctors(
            List<Doctor> doctors
    ) {
        return doctors.stream()
                .noneMatch(doctor -> !doctor.isActive());
    }

    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alex", true));
        doctors.add(new Doctor("Maria", false));
        doctors.add(new Doctor("John", true));
        doctors.add(new Doctor("Anna", true));

        if (!hasNoInactiveDoctors(doctors)) {
            System.out.println("No inactive doctors");
        }else  {
            System.out.println("Inactive doctor exists");
        }
    }
}
