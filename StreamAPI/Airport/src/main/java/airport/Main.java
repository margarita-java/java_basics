package airport;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Airport airport =Airport.getInstance();
    }

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {

        airport.getAllAircraft()
                .stream()
                .filter(aircraft.getModel().startWich(model)
                .count()
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {

        airport.getTerminals()
                .stream
                .collect(Collectors.toMap(
                        terminal -> terminal.getName(),
                        terminal -> terminal.getParkedAircrafts().size()
                ));
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {

        Instant now = Instant.now();
        Instant upperBound = now.plusSeconds(hours * 3600);

        return airport.getTerminals()
                .stream
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Type.DEPARTURE)
                .filter(flight -> flight.getDate().isAfter(now) && flight.getDate().isBefore(upperBound))
                .collect(Collectors.toList());
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {

        return airport.getTerminals()
                .stream
                .filter(terminal -> terminal.getName().equals(terminalName))
                .flatMap(terminal -> terminal.getFlights().stream()
                .filter(flight -> flight.getType() == Type.ARRIVAL)
                        .min(Comparator.comparing(Flight::getDate));
    }

}