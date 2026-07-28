public class DoctorRegistrationService {
    static class InvalidDoctorException extends Exception {
        public InvalidDoctorException(String message) {
            super(message);
        }
    }

    private static void registerDoctor(
            String name,
            String specialization,
            int experienceYears
    ) throws InvalidDoctorException {
        if (name == null || name.isBlank()) {
            throw new InvalidDoctorException("Doctor name is invalid");
        }
        if (specialization == null || specialization.isBlank()) {
            throw new InvalidDoctorException("Doctor specialization is invalid");
        }
        if (experienceYears < 0 || experienceYears > 60) {
            throw new InvalidDoctorException("Doctor experience must be between 0 and 60");
        }

        System.out.println("Doctor " + name + " registered as " + specialization);
    }

    public static void main(String[] args) {
        String doctorName = "Maria";
        String specialization = "Cardiologist";
        int experienceYears = 8;
        try {
            registerDoctor(doctorName, specialization, experienceYears);
        } catch (InvalidDoctorException exception) {
            System.out.println("Error: "+exception.getMessage());
        }
    }
}
