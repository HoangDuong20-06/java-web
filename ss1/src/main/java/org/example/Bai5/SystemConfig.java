package org.example.Bai5;

public class SystemConfig {
    private String branchName;
    private String openingHour;

    public SystemConfig(String branchName, String openingHour) {
        this.branchName = branchName;
        this.openingHour = openingHour;
    }

    public void display() {
        System.out.println("Branch: " + branchName);
        System.out.println("Opening Hour: " + openingHour);
    }
}
