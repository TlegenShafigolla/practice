public class Doctor {
    private final String name;
    private final int experienceYears;
    private final boolean active;

    public Doctor(String name, int experienceYears, boolean active) {
        this.name = name;
        this.experienceYears = experienceYears;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public boolean isActive() {
        return active;
    }
}
