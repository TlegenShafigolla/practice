import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientSearch {
    static class Patient {
        private long id;
        private String name;
        private boolean active;


        Patient(long id, String name, boolean active) {
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

    private static Optional<Patient> findPatientById(
            List<Patient> patients,
            long patientId
    ){
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return Optional.of(patient);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1, "Alex", true));
        patients.add(new Patient(2, "Maria", true));
        patients.add(new Patient(3, "John", false));
        long patientId = 2L;


        Patient patient = findPatientById(patients, patientId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Patient with id " + patientId + " not found"
                ));

        System.out.println("Patient found: " + patient.getName());
    }
}
