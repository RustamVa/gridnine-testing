package com.gridnine.testing.filter.filtering_impls;

import com.gridnine.testing.filter.Filtering;
import com.gridnine.testing.flight.Flight;

public class MoreThan2hOnGround implements Filtering {
    @Override
    public boolean checkFlight(Flight flight) {
        return false;
    }
}
