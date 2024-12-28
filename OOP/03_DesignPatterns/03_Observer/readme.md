### Observer Pattern: Weather Report Example

#### **What is the Observer Pattern?**
The Observer Pattern is like a group of friends who want to know when it’s going to rain. One friend (the "weather station") knows when the weather changes, and the other friends (the "observers") want to be told whenever it changes. 

#### **How it Works**
- Imagine you have a **weather station** that keeps track of the weather. 
- There are several **observers** (friends) who want to know when the weather changes, like your **mobile app** or the **school noticeboard**.
- Whenever the **weather station** finds out that the weather has changed (like it started raining), it tells all its **observers** (the friends) to update them.

#### **Real-Life Example: Weather Report**
- Let’s say the **weather station** says, "It’s raining!"
- Your **friends** (observers) need to know about this:
    - **Mobile App**: It shows a message, "It's raining outside."
    - **School Noticeboard**: It updates the weather board, "Rainy Day."
- Each friend has signed up (or subscribed) to receive weather updates from the weather station.

### **Summary**
- The **weather station** tells the observers (friends) whenever the weather changes.
- The **observers** listen for updates and do something when they hear about it.
- This way, everyone knows what's happening without the weather station having to tell each one separately. 

In short: **The observer pattern helps everyone stay updated with the weather change automatically!**

### Observer Pattern 

The **Observer Pattern** is a design pattern where one object (the **subject**) notifies multiple objects (the **observers**) when its state changes.

- **Subject**: The object being observed (e.g., **WeatherStation**).
- **Observer**: The objects that receive updates (e.g., **MobileApp**, **DisplayBoard**).
  
### How it Works:
1. **Subject** maintains a list of **observers**.
2. When the **subject’s state changes**, it calls the `update()` method on all its **observers**.
3. **Observers** react to the change (e.g., display the new weather).

### Why Use It:
- **Loose Coupling**: **Observers** don’t need to know about each other.
- **Real-time Updates**: **Observers** get notified automatically when the state changes.

### Example:
- **Subject** (WeatherStation) updates **Observers** (MobileApp, DisplayBoard) whenever the weather changes.