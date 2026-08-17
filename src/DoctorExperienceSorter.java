import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DoctorExperienceSorter {

    private static List<Doctor> findActiveDoctorsSortedByExperience(
            List<Doctor> doctors
    ) {
        return doctors.stream()
                .filter(Doctor::isActive)
                .sorted(Comparator.comparingInt(Doctor::getExperienceYears)
                        .reversed())
                .toList();
    }

    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alex", 5, true));
        doctors.add(new Doctor("Maria", 2, true));
        doctors.add(new Doctor("John", 7, false));
        doctors.add(new Doctor("Anna", 4, true));

        List<Doctor> sortedDoctorExperienceYears = findActiveDoctorsSortedByExperience(doctors);
        for (Doctor doctor : sortedDoctorExperienceYears) {
            System.out.println(doctor.getName()+" - "+doctor.getExperienceYears()+" years");
        }

    }
}
