public class PatientFileService {
    static class InvalidFileException extends Exception {
        public InvalidFileException(String message) {
            super(message);
        }
    }

    private static void readPatientFile(String fileName) throws InvalidFileException {
        if (fileName == null || fileName.isBlank()) {
            throw new InvalidFileException("File name is invalid");
        }
        if (!fileName.endsWith(".txt")) {
            throw new InvalidFileException("Only txt files are supported");
        }

        System.out.println("Reading file: " + fileName);
    }

    public static void main(String[] args) {
        String fileName = "patients.pdf";
        try {
            readPatientFile(fileName);
        } catch (InvalidFileException exception) {
            System.out.println("Error: " + exception.getMessage());
        } finally {
            System.out.println("File operation finished");
        }
    }
}
