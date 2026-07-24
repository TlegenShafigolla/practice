import java.util.ArrayList;
import java.util.List;

public class DoctorFilter {
    static class Doctor {
        private String name;
        private int experienceYears;
        private boolean active;

        Doctor(String name, int experienceYears, boolean active) {
            this.name = name;
            this.experienceYears = experienceYears;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public int getExperienceYears() {
            return experienceYears;
        }

        public boolean isActive() {
            return active;
        }
    }

    private static List<Doctor> findActiveDoctorsWithExperience(List<Doctor> doctors, int minimumExperience) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.isActive() && doctor.getExperienceYears() >= minimumExperience) {
                result.add(doctor);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int minimumExperience = 3;

        if (minimumExperience < 0) {
            System.out.println("Invalid experience");
            return;
        }
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alex", 5, true));
        doctors.add(new Doctor("Maria", 2, true));
        doctors.add(new Doctor("John", 7, false));
        doctors.add(new Doctor("Anna", 4, true));
        List<Doctor> result = findActiveDoctorsWithExperience(doctors, minimumExperience);
        for (Doctor doctor : result) {
            System.out.println(doctor.getName());
        }
    }
}