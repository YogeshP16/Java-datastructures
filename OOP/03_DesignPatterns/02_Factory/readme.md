### Factory Pattern 

The **Factory Pattern** is a design pattern where a method (the **factory**) creates objects without specifying the exact class of the object that will be created.

- **Factory**: The object that creates instances (e.g., **NotificationFactory**).
- **Product**: The objects being created (e.g., **EmailNotification**, **SMSNotification**).

### How it Works:
1. The **factory** provides a method to create objects of different types based on a condition (e.g., type of notification).
2. The **factory** returns an instance of the appropriate **product** (e.g., **EmailNotification** or **SMSNotification**).
3. Clients use the **factory** to get the correct object without worrying about its creation.

### Why Use It:
- **Encapsulation**: The client doesn’t need to know the details of object creation.
- **Flexibility**: You can easily add new types of products without changing client code.

### Example:
- **Factory** (NotificationFactory) creates **Products** (EmailNotification, SMSNotification) based on the type of notification needed. The client calls the factory to get the right notification type (email or SMS).