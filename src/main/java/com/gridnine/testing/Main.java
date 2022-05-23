package com.gridnine.testing;

import com.gridnine.testing.filter.FilterContext;
import com.gridnine.testing.filter.filtering_impls.ArrivalBeforeDepartureSegmentsFilter;
import com.gridnine.testing.filter.filtering_impls.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.filter.filtering_impls.MoreThan2hOnGround;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;
import com.gridnine.testing.flight.Segment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);
        FilterContext fc = new FilterContext(new MoreThan2hOnGround());
        System.out.println("__________________________\n");
        int i = 0;
        for (Flight f: flights){
            if (fc.doCheck(f)) {
                System.out.println(f + " " + i);
            }
            i += 1;
        }

    }
}
