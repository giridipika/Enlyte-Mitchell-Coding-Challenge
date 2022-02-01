Enlyte, Mitchell Coding Challenge

RESTful web service with Spring Boot Framework

What you will need
- Clone this repository
- Open the directory in IDE test editor
- Make sure you are using JDK 1.8 and Maven 3.2
- Run the application
Using Postman, provide query parameters using following resource and URI mapping:
Resources and URI Mappings
- Retrieve all Vehicles- GET /vehicles
- Retrieve one Vehicles- GET /vehicles/{id}
- Create a Vehicles- POST /vehicles
- Update a Vehicles- PUT /vehicles
- Delete a Vehicles- DELETE /vehicles/{id}

Example Requests
GET http://localhost:8080/vehicles
    [
    {
        "id": 1,
        "year": 2000,
        "make": "toyota",
        "model": "camry"
    },
    {
        "id": 2,
        "year": 1960,
        "make": "ford",
        "model": "mustang"
    }
    ]

GET http://localhost:8080/vehicles/1
    {
    "id": 1,
    "year": 2000,
    "make": "toyota",
    "model": "camry"
    }
Status: 200 OK

POST http://localhost:8080/vehicles
    Parameters:
    id:1
    year:2000
    make:toyota
    model:camry
Status: 200 OK

PUT http://localhost:8080/vehicles
    Parameters:
    id:1
    year:2022
    make:honda
    model:accord
Status: 200 OK

DELETE http://localhost:8080/vehicles/1

Status: 200 OK   

POST http://localhost:8080/vehicles with bound error
    Parameters:
    id:1
    year:1900
    make:toyota
    model:camry
    {
    "timestamp": "2022-02-01T01:48:16.093+00:00",
    "status": 405,
    "error": "Method Not Allowed",
    "path": "/vehicles/1"
    }
Status: 405 Method Not Allowed





