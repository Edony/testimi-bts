package edu.ubt.testimi.entity.type;

import java.util.ArrayList;
import java.util.List;

public enum Status {

    ACTIVE,

    INACTIVE;

    public static Status getStatus(String status) {
        if (status.equalsIgnoreCase("ACTIVE")) {
            return Status.ACTIVE;
        } else if (status.equalsIgnoreCase("INACTIVE")) {
            return Status.INACTIVE;
        }
        return null;
    }

    public static List<String> getStatusesAsList() {
        List<String> res = new ArrayList<>();

        res.add(ACTIVE.name());
        res.add(INACTIVE.name());

        return res;
    }
}
