# Homework 1
## 1. Request / response

### HTTP Request
An **HTTP request** is an application-layer message sent from a client to a server. It contains an **HTTP method** that indicates the actions the client wants the server to perform, along with any additional information needed to process the request. An HTTP request consists of an HTTP method, a target resource (URI), headers, and optionally a message body.

### HTTP method

The HTTP method tells the server the intent of the request. Therefore, there are different types of methods stand for different intents.

- GET: used to retrieve data
- POST: used to create a new resource
- PUT: replace the entire resource
- PATCH: updates only part of a resource
- DELETE: delete a resource
- HEAD: like GET, but server sends only the header, use for checking whether a resource exits, file size, or last modified time
- OPTIONS: what methods are allowed for this resource

### HTTP Response
- An **HTTP response** is a reply message sent by a server in response for a client's request. It communicates the outcome of the request through a status code and includes metatdata in the response headers and, optionally, a message body containing the requested resource or additional information

### HTTP Status Codes
- An **HTTP status code** is a three-digit number included an HTTP response that indicates the outcome of the server's attempt to process the client's request
- General categories:
  - 1xx: Informational
  - 2xx: Success
  - 3xx: Redirection
  - 4xx: Client error
  - 5xx: Server error
- Common codes for RESTful API:
  - 200 OK: Get resource successfully
  - 201 Created: Create resource successfully
  - 200 OK or 204 No Content: Update a resource
  - 204 No Content: Delete a resource
  - 400 Bad Request: Invalid request
  - 401 Unauthorized: Authentication required
  - 403 Forbidden: Permission denied
  - 404 Not Found: Resource not found
  - 500 Internal Server Error: Unexpected server error



