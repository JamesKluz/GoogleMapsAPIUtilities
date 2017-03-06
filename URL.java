package com.example.mike.jsonparser;

/**
 * Created by Mike on 3/4/2017.
 * class to generate url types
 * Origin, Destination, API Key
 * Arrival Time, Departure Time
 * Travel Mode
 * Avoid Tolls
 */


/**
 * Example usage:
 *
 * public URL url = new URL.URLBuilder("origin", "destination", "apiKey") // required
 *                      .arrivalTime("arrivalTime")     // optional?
 *                      .departureTime("departureTime") // optional?
 *                      .mode("mode")                   // optional?
 *                      .avoidToll()                    // optional
 *                      .avoidHighways()                // optional
 *                      .build(); // must call this to get back a URL
 */
public class URL {
    private final String origin;            // required
    private final String destination;       // required
    private final String apiKey;            // required
    private final String arrivalTime;       // optional?
    private final String departureTime;     // optional?
    private final String mode;              // optional?
    private final boolean avoidToll;        // optional
    private final boolean avoidHighways;    // optional
    private final String baseUrl = "https://maps.googleapis.com/maps/api/directions/json?";

    private String url = baseUrl;

    private URL(URLBuilder builder) {
        this.origin = builder.origin;
        this.destination = builder.destination;
        this.apiKey = builder.apiKey;
        this.arrivalTime = builder.arrivalTime;
        this.departureTime = builder.departureTime;
        this.travelMode = builder.travelMode;
        this.avoidToll = builder.avoidToll;
        this.avoidHighways = builder.avoidHighways;

        addOrigin(origin);
        addDestination(destination);
        addArrivalTime(arrivalTime);
        addDepartureTime(departureTime);
        addTravelMode(travelMode);
        addAvoidToll(avoidToll);
        addAvoidHighways(avoidHighways);
        addApiKey(apiKey);
    }

    private void addOrigin(String origin) {
        if (!origin.equals(null))
            this.url += "origin=" + origin;
        else
            ; // TODO: Throw exception; this variable is required.
    }

    private void addDestination(String destination) {
        if (!destination.equals(null))
            this.url += "destination=" + destination;
        else
            ; // TODO: Throw exception; this variable is required.
    }

    private void addAPIKey(String apiKey) {
        if (!apiKey.equals(null))
            this.url += "key=" + apiKey;
        else
            ; // TODO: Throw exception; this variable is required.
    }

    // TODO: Need to add unix time
    private void addArrivalTime(String arrivalTime) {
        if (!arrivalTime.equals(null))
            this.url += "arrival_time=" + aTime;
    }

    private void addDepartureTime(String departureTime) {
        if (!departureTime.equals(null))
            this.url += "departure_time=" + departureTime;
    }

    private void addTravelMode(String travelMode) {
        if (!travelMode.equals(null))
            this.url += "mode=" + travelMode;
    }

    private void addAvoidToll(boolean avoidToll) {
        if (avoidToll)
            this.url += "avoid=tolls";
    }

    private void addAvoidHighways(boolean avoidHighways) {
        if (avoidHighways)
            this.url += "avoid=highways";
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getTravelMode() {
        return mode;
    }

    public boolean avoidToll() {
        return avoidToll;
    }

    public boolean avoidHighways() {
        return avoidHighways;
    }

    public static class URLBuilder {
        private final String origin;        // required
        private final String destination;   // required
        private final String apiKey;        // required
        private String arrivalTime;         // optional?
        private String departureTime;       // optional?
        private String travelMode;          // optional?
        private boolean avoidToll;          // optional
        private boolean avoidHighways;      // optional

        public URLBuilder(String origin, String destination, String apiKey) {
            this.origin = origin;
            this.destination = destination;
            this.apiKey = apiKey;
        }

        public URLBuilder arrivalTime(String arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public URLBuilder departureTime(String departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        public URLBuilder travelMode(String travelMode) {
            this.travelMode = travelMode;
            return this;
        }

        public URLBuilder avoidToll() {
            this.avoidToll = true;
            return this;
        }

        public URLBuilder avoidHighways() {
            this.avoidHighways = true;
            return this;
        }

        public URL build() {
            return new URL(this);
        }
    }
}