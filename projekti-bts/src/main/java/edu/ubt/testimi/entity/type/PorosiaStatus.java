package edu.ubt.testimi.entity.type;

import java.util.ArrayList;
import java.util.List;

public enum PorosiaStatus {

    PENDING,

    CANCELED,

    SENT;

    public static PorosiaStatus getStatus(String status) {
        if (status.equalsIgnoreCase("PENDING")) {
            return PorosiaStatus.PENDING;
        } else if (status.equalsIgnoreCase("CANCELED")) {
            return PorosiaStatus.CANCELED;
        } else if (status.equalsIgnoreCase("SENT")) {
            return PorosiaStatus.SENT;
        }
        return null;
    }

    public static List<String> getStatusesAsList() {
        List<String> res = new ArrayList<>();

        res.add(PENDING.name());
        res.add(CANCELED.name());
        res.add(SENT.name());

        return res;
    }
}
