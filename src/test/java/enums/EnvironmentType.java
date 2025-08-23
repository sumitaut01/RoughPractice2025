package enums;

public enum EnvironmentType {
    QA("Quality Assurance"),
    UAT("User Acceptance Testing");

    private final String fullName;

    EnvironmentType(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }
}