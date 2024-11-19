package airport;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Flight.Type;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
    }

    public static long findCountAircraftWithModelAirbus(Airport airport, String model) {
        return airport.getAllAircrafts()
                .stream()
                .filter(aircraft -> aircraft.getModel().startsWith(model))
                .count();
    }

    public static Map<String, Integer> findMapCountParkedAircraftByTerminalName(Airport airport) {
        return airport.getTerminals()
                .stream()
                .collect(Collectors.toMap(
                        terminal -> terminal.getName(),
                        terminal -> terminal.getParkedAircrafts().size()
                ));
    }

    public static List<Flight> findFlightsLeavingInTheNextHours(Airport airport, int hours) {
        Instant now = Instant.now();
        Instant upperBound = now.plusSeconds(hours * 3600);
        return airport.getTerminals()
                .stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Type.DEPARTURE)
                .filter(flight -> flight.getDate().isAfter(now) && flight.getDate().isBefore(upperBound))
                .collect(Collectors.toList());
    }

    public static Optional<Flight> findFirstFlightArriveToTerminal(Airport airport, String terminalName) {
        return airport.getTerminals()
                .stream()
                .filter(terminal -> terminal.getName().equals(terminalName))
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType() == Type.ARRIVAL)
                .min(Comparator.comparing(Flight::getDate));
    }
}
