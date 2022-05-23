package com.gridnine.testing.filter.filtering_impls;

import com.gridnine.testing.filter.Filtering;
import com.gridnine.testing.flight.Flight;

public class ArrivalBeforeDepartureSegmentsFilter implements Filtering {
    @Override
    public boolean checkFlight(Flight flight) {
        return false;
    }
}
