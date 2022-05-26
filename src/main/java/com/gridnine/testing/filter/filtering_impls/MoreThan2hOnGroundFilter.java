package com.gridnine.testing.filter.filtering_impls;

import com.gridnine.testing.filter.Filtering;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class MoreThan2hOnGroundFilter implements Filtering {
    @Override
    public boolean checkFlight(Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments.size() == 1) {
            return false;
        }
        long onGrMinSum = 0;
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrTime = segments.get(i).getArrivalDate();
            LocalDateTime depNextTime = segments.get(i + 1).getDepartureDate();
            onGrMinSum += arrTime.until(depNextTime, ChronoUnit.MINUTES);
            if (onGrMinSum / 60 > 2) {
                return true;
            }
        }
        return false;
    }
}
