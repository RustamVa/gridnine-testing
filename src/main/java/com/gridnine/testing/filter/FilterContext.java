package com.gridnine.testing.filter;

import com.gridnine.testing.flight.Flight;

public class FilterContext {
    private final Filtering filtering;

    public FilterContext (Filtering filtering) {
        this.filtering = filtering;
    }

    public boolean doCheck(Flight flight) {
        return filtering.checkFlight(flight);
    }
}
