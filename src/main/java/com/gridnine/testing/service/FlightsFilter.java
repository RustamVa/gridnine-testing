package com.gridnine.testing.service;

import com.gridnine.testing.filter.Filtering;
import com.gridnine.testing.flight.Flight;

import java.util.List;

public interface FlightsFilter {
    List<Flight> filter(Filtering filtering);

}
