# **MVC**

## **Spring MVC**

#### **What is Spring MVC?**  
📝 **Definition**:  
Spring MVC (Model-View-Controller) is a framework in Spring used to build web applications, based on the MVC design pattern. It separates application logic into three main components: Model, View, and Controller.

📌 **MVC Components**:  
1. **Model** – Represents the data or business logic of the application.  
2. **View** – Displays the data from the Model to the user. Typically a JSP, Thymeleaf, or other view technologies.  
3. **Controller** – Handles user requests, interacts with the Model, and returns the View.

⚙️ **How it works internally**:  
1. **DispatcherServlet**: The main controller that acts as the front controller. It receives all incoming requests and dispatches them to the appropriate controller.  
2. **Controller**: The controller handles the request logic and updates the Model.  
3. **View Resolver**: It resolves the view (such as JSP or HTML) to be rendered.  
4. **Model**: The model (usually an object) is passed to the view for display.

#### **Annotations in Spring MVC**  
📌 **Common Spring MVC Annotations**:

1. **`@Controller`**: Marks a class as a Spring MVC controller.  
2. **`@RequestMapping`**: Maps HTTP requests to handler methods of MVC controllers.  
3. **`@GetMapping`**: Specialized version of `@RequestMapping` for GET requests.  
4. **`@PostMapping`**: Specialized version of `@RequestMapping` for POST requests.  
5. **`@PutMapping`**: Specialized version of `@RequestMapping` for PUT requests.  
6. **`@DeleteMapping`**: Specialized version of `@RequestMapping` for DELETE requests.  
7. **`@RequestParam`**: Binds request parameters to method parameters.  
8. **`@PathVariable`**: Binds URI template variables to method parameters.  
9. **`@ResponseBody`**: Indicates that the return value of a method should be bound to the web response body (usually for REST APIs).

#### **Example of Spring MVC Controller**  
```java
@Controller
public class UserController {

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userView"; // View name (userView.jsp)
    }
}
```
#### **Query vs Path Parameters**

##### **Query Parameters**:
- **Used for**: Filtering, sorting, pagination.
- **Location**: After `?` in the URL (e.g., `?key=value`).
- **Example**: `GET /products?category=electronics&limit=10`.
##### **Path Parameters**:
- **Used for**: Identifying specific resources.
- **Location**: In the URL path (e.g., `/resource/{id}`).
- **Example**: `GET /products/12345`.

#### **Filtering, Sorting, and Pagination in REST**

##### **Filtering**:
- **Used for**: Narrowing down results based on specific criteria.
- **Location**: Query parameters.
- **Example**: `GET /products?category=electronics`.
  
##### **Sorting**:
- **Used for**: Ordering results based on a specific field.
- **Location**: Query parameters.
- **Example**: `GET /products?sort=price`.

##### **Pagination**:
- **Used for**: Breaking results into manageable chunks.
- **Location**: Query parameters.
- **Example**: `GET /products?page=2&size=10`.
---


## **Exception Handling in Spring**  

#### **What is Exception Handling in Spring?**  
📝 **Definition**:  
- Exception Handling in Spring is a mechanism to handle runtime errors gracefully and provide meaningful error messages to users, while maintaining application flow. 
- Spring provides several tools for centralized exception management, including `@ExceptionHandler` and `@ControllerAdvice`.

#### **What is `@ExceptionHandler`?**  
⚙️ **Definition**:  
- `@ExceptionHandler` is an annotation used to define a method that will handle specific exceptions thrown within a **controller**. 
- It is applied to the method to catch the exception and provide custom handling logic.

📌 **Example**:  
```java
@Controller
public class MyController {

    @RequestMapping("/test")
    public String testMethod() throws Exception {
        throw new RuntimeException("An error occurred");
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException ex) {
        return "errorPage"; // Return custom error page
    }
}
```
🔹 **Use Case**: Handles specific exceptions for a single controller.

#### **What is `@ControllerAdvice`?**  
⚙️ **Definition**:  
`@ControllerAdvice` is a specialized form of `@Component` that allows handling exceptions across the whole application in a centralized manner. It can define global exception handling logic, making it ideal for handling exceptions in multiple controllers.

📌 **Example**:  
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handleGlobalException(RuntimeException ex) {
        return "globalErrorPage"; // Return a global error page for all controllers
    }
}
```
🔹 **Use Case**: Handles exceptions globally across multiple controllers.

#### **Differences between `@ExceptionHandler` and `@ControllerAdvice`**  
🔹 **Scope**:  
- **`@ExceptionHandler`**: Handles exceptions within a specific controller.  
- **`@ControllerAdvice`**: Handles exceptions globally for all controllers.  

🔹 **Usage**:  
- **`@ExceptionHandler`**: Use when exceptions need to be handled in a single controller.  
- **`@ControllerAdvice`**: Use for centralized exception handling for the entire application.

#### **Example of Global Exception Handling with `@ControllerAdvice`**  
📌 **Example**:  
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```
🔹 **Explanation**: This example returns a custom response entity for all exceptions thrown in the application.

---

## **REST**

#### **What is REST?**  
📝 **Definition**:  
- **REST (Representational State Transfer)** is an architectural style for designing networked applications. 
- It uses a stateless, client-server communication model, typically over HTTP, where resources are identified by URIs.

#### **What are the Key Principles of REST?**  
🔑 **Key Principles**:  
1. **Stateless**: Each request from client to server must contain all necessary information (i.e., no session state).
2. **Client-Server Architecture**: Separation of concerns; client is responsible for the user interface, server for data management.
3. **Uniform Interface**: A consistent way of interacting with resources (e.g., HTTP methods like GET, POST).
4. **Cacheable**: Responses should define themselves as cacheable or not, to improve performance.
5. **Layered System**: The client cannot ordinarily tell whether it is connected directly to the end server or to an intermediary.
6. **Code on Demand (optional)**: Servers can temporarily extend or customize functionality by transferring executable code.

#### **RESTful HTTP Methods**  
🔹 **GET**: Retrieve resource (read).  
🔹 **POST**: Create a new resource (write).  
🔹 **PUT**: Update an existing resource (write).  
🔹 **PATCH**: Partially update an existing resource (write).  
🔹 **DELETE**: Remove a resource (delete).  
🔹 **OPTIONS**: Retrieve supported HTTP methods for a resource.  
🔹 **HEAD**: Retrieve metadata for a resource (like GET, but no body).

#### **What is a REST Resource?**  
📝 **Definition**:  
- A **REST resource** is any object, data, or service that is identified by a URI (Uniform Resource Identifier). 
- Resources are accessed and manipulated using standard HTTP methods (GET, POST, PUT, DELETE).

#### **What are HTTP Status Codes in REST?**  
🔹 **2xx Success**:  
   - **200 OK**: Request succeeded.
   - **201 Created**: Resource successfully created.
   - **204 No Content**: No content to return (useful for DELETE).

🔹 **3xx Redirection**:  
   - **301 Moved Permanently**: Resource permanently moved to a new URI.
   - **302 Found**: Resource temporarily moved to a new URI.

🔹 **4xx Client Errors**:  
   - **400 Bad Request**: Malformed request.
   - **401 Unauthorized**: Authentication is required.
   - **404 Not Found**: Resource not found.
   - **409 Conflict**: Request conflict (e.g., trying to create a duplicate).

🔹 **5xx Server Errors**:  
   - **500 Internal Server Error**: Generic server error.
   - **502 Bad Gateway**: Invalid response from upstream server.
   - **503 Service Unavailable**: Server is temporarily unavailable.

#### **What is the Difference Between PUT and PATCH?**  
🔹 **PUT**:  
   - Replaces the entire resource.  
   - Used when you want to update or overwrite an entire resource.  
   - If the resource doesn’t exist, it can create it (idempotent).

🔹 **PATCH**:  
   - Applies partial modifications to a resource.  
   - Used for updating only specific fields or properties of the resource (idempotent).

#### **How to Handle Errors in REST APIs?**  
🔹 **400 Bad Request**: If the request is malformed or invalid.  
🔹 **401 Unauthorized**: When authentication is required but not provided or invalid.  
🔹 **404 Not Found**: When the requested resource does not exist.  
🔹 **500 Internal Server Error**: For unexpected server-side issues.  
- **Best Practice**: Provide meaningful error messages in the response body to help clients understand and resolve the issue.

#### **What is an Idempotent HTTP Method?**  
📝 **Definition**:  
- An HTTP method is **idempotent** if making multiple identical requests has the same effect as making a single request.  
🔹 **Examples**:  
   - **GET**: No side effects (retrieves data).
   - **PUT**: Updating a resource multiple times doesn’t change the result after the first update.  
   - **DELETE**: Deleting a resource multiple times has the same effect (resource is deleted).

#### **What is the Purpose of HTTP Headers in REST APIs?**  
🔹 **Definition**:  
- HTTP headers provide meta-information about the request or response. 
- They can include information about the data format, authentication, cache control, and more.  
🔹 **Common Headers**:
   - **Content-Type**: Defines the media type of the resource (e.g., `application/json`).
   - **Authorization**: Used for sending authentication tokens (e.g., Bearer Token).
   - **Accept**: Specifies the media type(s) that the client is willing to receive.
   - **Cache-Control**: Directs caching behavior for resources.


#### **What is HATEOAS in REST?**  
🔹 **HATEOAS (Hypermedia as the engine of application state)**:  
A constraint of REST where the client interacts with the application entirely through hypermedia provided by the server (e.g., via links).  
   - **Purpose**: Makes the API more flexible by allowing the client to dynamically discover available actions.

**Example**:
```json
{
  "name": "John Doe",
  "links": [
    {
      "rel": "self",
      "href": "http://api.example.com/users/1"
    },
    {
      "rel": "friends",
      "href": "http://api.example.com/users/1/friends"
    }
  ]
}
```

---

#### **Statelessness in REST**  
🔹 **Definition**:  
- In REST, each request from the client to the server must contain all the necessary information for the server to understand and process the request. The server does not store any state about the client between requests.

   - **Benefit**: Scalability, as each request is independent and can be handled by any available server.

#### **What is CORS (Cross-Origin Resource Sharing)?**  
🔹 **Definition**:  
**CORS** is a security feature implemented by browsers to restrict how resources on a web page can be requested from another domain. REST APIs can enable or restrict CORS by setting the appropriate HTTP headers (`Access-Control-Allow-Origin`).

**Use Case**:  
If your frontend (e.g., React app) is hosted on a different domain than the backend (REST API), CORS will allow or block requests based on configured rules.

#### **REST API Design Best Practices**  
1. **Use Nouns for Resource Names**:  
   - **Correct**: `/users`, `/orders`
   - **Incorrect**: `/getUsers`, `/createOrder`
2. **Use HTTP Methods Correctly**:  
   - **GET**: Retrieve data.
   - **POST**: Create a resource.
   - **PUT**: Replace or update a resource.
   - **DELETE**: Remove a resource.
3. **Return Proper Status Codes**:  
   Always return the appropriate HTTP status code based on the operation's outcome.
4. **Use Filters and Pagination**:  
   For large datasets, provide filtering options (e.g., `/users?age=25`) and pagination (`/users?page=2&size=10`).

#### **What is JSON and XML in REST APIs?**  
🔹 **JSON**:  
   - **Format**: Lightweight, easy to read and write, and often used for data exchange in REST APIs.  
   - **Example**:  
     ```json
     {
       "name": "John",
       "age": 30
     }
     ```

🔹 **XML**:  
   - **Format**: Heavier, more complex, but used in certain legacy systems or integrations.  
   - **Example**:  
     ```xml
     <person>
       <name>John</name>
       <age>30</age>
     </person>
     ```

### **Versioning in REST APIs**  
🔹 **Definition**:  
API versioning ensures that changes to the API do not break existing client implementations.

🔹 **Common Strategies**:  
   - **URI Versioning**: `/api/v1/users`
   - **Query Parameter Versioning**: `/api/users?version=1`
   - **Header Versioning**: `X-API-Version: 1`

---

### **Key Takeaway**:
RESTful APIs follow principles that make systems scalable, efficient, and easy to maintain. Understanding these key concepts and HTTP methods helps you build robust, reliable APIs while ensuring clients interact with them effectively.