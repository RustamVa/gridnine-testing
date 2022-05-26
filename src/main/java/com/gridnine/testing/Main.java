package com.gridnine.testing;

import com.gridnine.testing.filter.filtering_impls.ArrivalBeforeDepartureSegmentsFilter;
import com.gridnine.testing.filter.filtering_impls.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.filter.filtering_impls.MoreThan2hOnGroundFilter;
import com.gridnine.testing.flight.Flight;
import com.gridnine.testing.flight.FlightBuilder;
import com.gridnine.testing.service.FlightsFilterImpl;
import com.gridnine.testing.service.FlightsFilter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightsFilter flightsFilter = new FlightsFilterImpl(flights);
        List<Flight> filteredFlights;

        System.out.println("\n\n((EACH FILTER SEPARATELY TO SINGLE TEST CASE))\n\n");
        System.out.println("BEFORE\n___________\n");
        flights.forEach(System.out::println);

        filteredFlights = flightsFilter.filter(new DepartureBeforeCurrentTimeFilter());

        System.out.println("\nAFTER \"Flights with departure before current time\" FILTERING" +
                "\n___________");
        filteredFlights.forEach(System.out::println);
        System.out.println("\n___________________________________________________________________\n");


        filteredFlights = flightsFilter.filter(new ArrivalBeforeDepartureSegmentsFilter());

        System.out.println("\nAFTER \"Flights with arrival before departure segments\" FILTERING" +
                "\n___________");
        filteredFlights.forEach(System.out::println);
        System.out.println("\n___________________________________________________________________\n");


        filteredFlights = flightsFilter.filter(new MoreThan2hOnGroundFilter());
        System.out.println("\nAFTER \"More than 2 hours on ground\" FILTERING" +
                "\n___________");
        filteredFlights.forEach(System.out::println);


        System.out.println("\n\n_____________________________________________________________________________\n" +
                "_____________________________________________________________________________");



        flights = FlightBuilder.createFlights();
        System.out.println("\n\n((ALL FILTERS TO CASE))\n\n");

        flightsFilter = new FlightsFilterImpl(flights);
        flights = flightsFilter.filter(new DepartureBeforeCurrentTimeFilter());

        System.out.println("\nAFTER \"Flights with departure before current time\" FILTERING" +
                "\n___________");
        flights.forEach(System.out::println);
        System.out.println("\n___________________________________________________________________\n");

        flightsFilter = new FlightsFilterImpl(flights);
        flights = flightsFilter.filter(new ArrivalBeforeDepartureSegmentsFilter());
        System.out.println("\nAFTER \"Flights with arrival before departure segments\" FILTERING" +
                "\n___________");
        flights.forEach(System.out::println);
        System.out.println("\n___________________________________________________________________\n");

        flightsFilter = new FlightsFilterImpl(flights);
        flights = flightsFilter.filter(new MoreThan2hOnGroundFilter());
        System.out.println("\nAFTER \"More than 2 hours on ground\" FILTERING" +
                "\n___________");
        flights.forEach(System.out::println);
        System.out.println("\n___________________________________________________________________\n");

    }
}
