import java.util.ArrayList;
import java.util.List;

public class DoctorNameSorter {
    private static List<String> findSortedActiveDoctorNames(
            List<Doctor> doctors
    ) {
        return doctors.stream()
                .filter(Doctor::isActive)
                .map(Doctor::getName)
                .sorted()
                .toList();
    }

    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();

        doctors.add(new Doctor("Alex", 5, true));
        doctors.add(new Doctor("Maria", 2, true));
        doctors.add(new Doctor("John", 7, false));
        doctors.add(new Doctor("Anna", 4, true));

        List<String> result = findSortedActiveDoctorNames(doctors);

        for (String name : result) {
            System.out.println(name);
        }
    }
}
