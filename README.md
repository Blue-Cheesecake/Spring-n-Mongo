# Spring Boot with MongoDB

This is a simple Spring Boot project that demonstrates how to connect to MongoDB as a database. It showcases basic operations and provides a starting point for developers who want to work with Spring Boot and MongoDB.

## Prerequisites

1. JDK 17 or higher
2. Docker

## Getting Started

1. Clone this repository

```
git clone https://github.com/Blue-Cheesecake/Spring-n-Mongo.git
```

2. Cd to server directory

```
cd Spring-n-Mongo/server
```

3. Run the docker for mongodb

```
docker-compose -f docker-compose.yaml up -d
```

4. Run Spring Boot application

## Usage

The application exposes RESTful APIs to perform only GET operations on a simple "student" collection. Here are the available endpoints:

- `GET /api/student/get/all`: Retrieve all students
- `GET /api/student/get/{email}`: Retrieve student with this email