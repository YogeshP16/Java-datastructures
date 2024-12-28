// WeatherListener interface (Observer)

import java.util.ArrayList;
import java.util.List;

interface WeatherListener {
    void updateWeather(String weather);  // Reacts to weather updates
}

// WeatherStation (Subject)
class WeatherStation {
    private List<WeatherListener> subscribers = new ArrayList<>();
    
    // Add a subscriber to the list
    public void addSubscriber(WeatherListener subscriber) {
        subscribers.add(subscriber);
    }
    
    // Notify all subscribers about the weather change
    public void notifySubscribers(String weather) {
        for (WeatherListener subscriber : subscribers) {
            subscriber.updateWeather(weather);  // Subscribers react to weather update
        }
    }
}

// Concrete WeatherListeners
class MobileApp implements WeatherListener {
    public void updateWeather(String weather) {
        System.out.println("Mobile App: Weather update - " + weather);  // Action when updated
    }
}

class DisplayBoard implements WeatherListener {
    public void updateWeather(String weather) {
        System.out.println("Display Board: Weather update - " + weather);  // Action when updated
    }
}

// Main class to simulate
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        MobileApp app = new MobileApp();
        DisplayBoard board = new DisplayBoard();

        // Adding subscribers to the WeatherStation
        station.addSubscriber(app);
        station.addSubscriber(board);

        // The weather station updates the subscribers
        station.notifySubscribers("It's raining!");  // Subscribers react to this update
    }
}
/*
Mobile App: Weather update - It's raining!
Display Board: Weather update - It's raining!
 */