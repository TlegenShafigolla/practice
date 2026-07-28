import java.util.ArrayList;
import java.util.List;

public class PatientNameFilter {
    static class Patient {
        private final String name;
        private final int age;
        private boolean active;

        Patient(String name, int age, boolean active) {
            this.name = name;
            this.age = age;
            this.active = active;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isActive() {
            return active;
        }
    }

    private static List<String> findActiveAdultPatientNames(
            List<Patient> patients,
            int minimumAge
    ) {
        return patients.stream()
                .filter(p -> p.getAge() >= minimumAge)
                .filter(Patient::isActive)
                .map(Patient::getName)
                .toList();
    }

    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Alex", 25, true));
        patients.add(new Patient("Maria", 17, true));
        patients.add(new Patient("John", 40, false));
        patients.add(new Patient("Anna", 30, true));

        int minimumAge = 18;
        if (minimumAge < 0) {
            System.out.println("Invalid age");
            return;
        }
        List<String> result = findActiveAdultPatientNames(patients, minimumAge);

        for (String name : result) {
            System.out.println(name);
        }
    }

}
