package com.gridnine.testing.filter.filtering_impls;

import com.gridnine.testing.filter.Filtering;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.Segment;

import java.util.List;

public class ArrivalBeforeDepartureSegmentsFilter implements Filtering {
    @Override
    public boolean checkFlight(Flight flight) {
        List<Segment> segments = flight.getSegments();
        Segment tempSeg = segments.get(0);
        if (segments.size() == 1) {
            return checkSingleSeg(tempSeg);
        }
        for (int i = 1; i < segments.size(); i++) {
            Segment seg = segments.get(i);
            if (checkSingleSeg(seg)) {
                return true;
            }
            if (!seg.getArrivalDate().isBefore(tempSeg.getDepartureDate())) {
                tempSeg = seg;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean checkSingleSeg(Segment seg) {
        return seg.getArrivalDate().isBefore(seg.getDepartureDate());
    }
}
