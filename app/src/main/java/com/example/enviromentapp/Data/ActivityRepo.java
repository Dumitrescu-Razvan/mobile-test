package com.example.enviromentapp.Data;


import java.util.ArrayList;

public class ActivityRepo {
    /*
    A list that contains all the activities
     */

    private ArrayList<EnvActivity> activities;

    public ActivityRepo() {
        activities = new ArrayList<>();
    }

    public void addActivity(EnvActivity activity) {
        activities.add(activity);
    }

    public ArrayList<EnvActivity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<EnvActivity> activities) {
        this.activities = activities;
    }

    public void removeActivity(EnvActivity activity) {
        activities.remove(activity);
    }

    public void removeActivity(int index) {
        activities.remove(index);
    }

    public EnvActivity getActivity(int index) {
        return activities.get(index);
    }

    public int getSize() {
        return activities.size();
    }

    public void clear() {
        activities.clear();
    }

    public void updateActivity(int index, EnvActivity activity) {
        activities.set(index, activity);
    }

    public void updateActivity(EnvActivity oldActivity, EnvActivity newActivity) {
        int index = activities.indexOf(oldActivity);
        activities.set(index, newActivity);
    }


}
