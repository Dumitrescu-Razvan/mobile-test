package com.example.enviromentapp.Data;

public class EnvActivity {

    /*

    Activity Name (string): Describes the activity (e.g., "Driving to work").
    Category (string): Specifies whether the activity relates to carbon, water, or energy usage.
    Amount (float): The amount of the resource consumed or saved (e.g., "15" liters of water).
    Date (date): The date when the activity was logged.
    Impact Level (string): A qualitative measure of the activity's impact (e.g., "High", "Medium", "Low").

     */

    private String activityName;
    private String category;
    private float amount;
    private String date;
    private String impactLevel;

    public EnvActivity(String activityName, String category, float amount, String date, String impactLevel) {
        this.activityName = activityName;
        this.category = category;
        this.amount = amount;
        this.date = date;
        this.impactLevel = impactLevel;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImpactLevel() {
        return impactLevel;
    }

    public void setImpactLevel(String impactLevel) {
        this.impactLevel = impactLevel;
    }

    @Override
    public String toString() {
        return activityName + ", " + category + ", " + amount + ", " + date + ", " + impactLevel;
    }


}
