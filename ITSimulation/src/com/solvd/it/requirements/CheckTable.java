package com.solvd.it.requirements;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

public class CheckTable {
    private Dictionary<Requirement, StateInfo> goals = new Hashtable<>();

    public boolean addGoal(Requirement requirement, Date startDate) {
        try {
            goals.put(requirement, new StateInfo(startDate));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public CheckTable(ArrayList<Requirement> requirements, Date startDate) {
        for (Requirement requirement :
                requirements) {
            goals.put(requirement, new StateInfo(startDate));
        }
    }
}
