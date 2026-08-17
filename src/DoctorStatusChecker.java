import java.util.ArrayList;
import java.util.List;

public class DoctorStatusChecker {
    static class Doctor {
        private final String name;
        private final boolean active;

        Doctor(String name, boolean active) {
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

    private static boolean areAllDoctorsActive(
            List<Doctor> doctors
    ) {
        return doctors.stream().allMatch(Doctor::isActive);
    }

    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alex", true));
        doctors.add(new Doctor("Maria", true));
        doctors.add(new Doctor("John", true));
        doctors.add(new Doctor("Anna", true));

        if (areAllDoctorsActive(doctors)) {
            System.out.println("All doctors are active");
        } else {
            System.out.println("Not all doctors are active");
        }
    }


}
