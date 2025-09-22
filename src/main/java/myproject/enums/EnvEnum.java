package myproject.enums;

public enum EnvEnum {
    QA("Quality Assurance"),
    UAT("User Acceptance Testing");

    private final String fullName;

    EnvEnum(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return this.fullName;
    }
}




