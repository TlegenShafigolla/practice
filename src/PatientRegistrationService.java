public class PatientRegistrationService {
    static class InvalidPatientException  extends Exception {
        public InvalidPatientException(String message) {
            super(message);
        }
    }
    private static void registerPatient(
            String name,
            int age
    ) throws InvalidPatientException{
        if (name == null || name.isBlank()) {
            throw new InvalidPatientException("Patient name is invalid");
        }
        if (age < 0|| age >120) {
            throw new InvalidPatientException("Patient age must be between 0 and 120");
        }
        System.out.println("Patient " + name + " is registered");
    }

    public static void main(String[] args) {
        String patient = "Maria";
        int age = 14;

        try {
            registerPatient(patient,age);
        } catch (InvalidPatientException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
