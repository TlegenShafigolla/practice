public class DoctorSalaryCalculator {

    private static final double BONUS_RATE = 0.10;

    public static void main(String[] args) {
        String doctorName = "Alex";
        int workedDays = 20;
        double salaryPerDay = 15_000;
        boolean hasBonus = true;

        if (!isValid(workedDays, salaryPerDay)) {
            System.out.println("Invalid data");
            return;
        }

        double baseSalary = calculateBaseSalary(workedDays, salaryPerDay);
        double bonus = calculateBonus(baseSalary, hasBonus);
        double totalSalary = calculateSalary(baseSalary, bonus);

        System.out.println("Doctor: " + doctorName);
        System.out.println("Base salary: " + baseSalary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total salary: " + totalSalary);
    }

    private static boolean isValid(int workedDays, double salaryPerDay) {
        return workedDays >= 0 && salaryPerDay >= 0;
    }

    private static double calculateBaseSalary(
            int workedDays,
            double salaryPerDay
    ) {
        return workedDays * salaryPerDay;
    }

    private static double calculateBonus(
            double baseSalary,
            boolean hasBonus
    ) {
        if (!hasBonus) {
            return 0;
        }

        return baseSalary * BONUS_RATE;
    }

    private static double calculateSalary(
            double baseSalary,
            double bonus
    ) {
        return baseSalary + bonus;
    }
}