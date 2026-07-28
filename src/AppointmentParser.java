
public class AppointmentParser {
    private static int parseAppointmentHour(
            String hour
    ) {
        int result = Integer.parseInt(hour);
        if (result < 9 || result > 18) {
            throw new IllegalArgumentException("Hour must be between 9 and 18");
        }
        return result;
    }

    public static void main(String[] args) {
        String hour = "abc";
        try {
            int appointmentHour = parseAppointmentHour(hour);
            System.out.println("Appointment hour: " + appointmentHour);
        } catch (NumberFormatException exception) {
            System.out.println("Error: Hour must be a number");
        } catch (IllegalArgumentException exception) {
            System.out.println("Error: " + exception.getMessage());
        } finally {
            System.out.println("Parsing finished");
        }
    }
}
