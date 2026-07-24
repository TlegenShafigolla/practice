import java.util.ArrayList;
import java.util.List;

public class PatientFilter {

    static class Patient {

        private final String name;
        private final int age;
        private final boolean insured;

        Patient(String name, int age, boolean insured) {
            this.name = name;
            this.age = age;
            this.insured = insured;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isInsured() {
            return insured;
        }
    }

    private static List<Patient> findInsuredAdultPatients(
            List<Patient> patients,
            int minimumAge
    ) {
        List<Patient> filteredPatients = new ArrayList<>();

        for (Patient patient : patients) {
            if (patient.isInsured()
                    && patient.getAge() >= minimumAge) {
                filteredPatients.add(patient);
            }
        }

        return filteredPatients;
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

        List<Patient> filteredPatients =
                findInsuredAdultPatients(patients, minimumAge);

        for (Patient patient : filteredPatients) {
            System.out.println(patient.getName());
        }
    }
}