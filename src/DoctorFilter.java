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

    private static List<Doctor> findActiveDoctorsWithExperience(
            List<Doctor> doctors,
            int minimumExperience
    ) {
        List<Doctor> result = new ArrayList<>();

        for (Doctor doctor : doctors) {
            if (doctor.isActive() && doctor.getExperienceYears() >= minimumExperience) {
                result.add(doctor);
            }
        }

        return result;
    }

}


