ACME Spring Boot Test Application
---------------------------------

 A Spring Boot REST test application that has a diverse set of endpoints:  
 1. A "Hello World" endpoint that basically returns "Hello World!"
 1. Three Fibonacci sequence endpoints that take a number, N, and return an array with the first 
 N Fibonacci numbers. The three endpoints use recursive algorithms of various complexity
 (exponential O(2^n), O(n), and a tail recursive algorithm).
 1. A Deadlock endpoint that causes two threads to become deadlocked and returns
 the deadlock state after a timeout of 3 seconds. This implementation
 simulates a real-life deadlock situation in which a <code>Pedestrian</code> and a
 <code>Driver</code> are waiting for each other to cross a <code>Crosswalk</code>.
 1. Several CRUD endpoints that add, query, and delete rows representing Pearl Jam
 <code>Album</code>s from a HyperSQL, in-memory database using a JPA Repository.
 1. An External endpoint that uses Spring <code>RestTemplate</code> to return the data
 from a specific external endpoint (https://jsonplaceholder.typicode.com/posts).

### Build and Run Requirements
1. Java 8
1. Maven 3.3.3 (minimum)
1. Internet connection to download dependencies

### How to Clone and Build
1. Clone the repository:
    1. SSH
        1. ```git clone git@github.com:shadesgodown/acmetest.git```
    1. HTTPS
        1. ```git clone https://github.com/shadesgodown/acmetest.git```

1. Change directory to acmetest
    1. ```cd acmetest```

1. Build and run tests with Maven
    1. ```mvn clean install```

### How to Run Application
1. Change directory to acmetest/target
    1. ```cd target```
1. Run executable jar
    1. ```java -jar app-1.0.0-SNAPSHOT.jar```

NOTE: Application runs on port 8080. Be careful of port conflicts.

## How to Stop Application
1. <code>Ctrl-C</code> or <code>Cmd-C</code> for OS X

### Example API calls with cURL
NOTE: If you do not background the application process, you will need to 
run the following in a separate Terminal session. 

1. Hello World
    1. ```curl http://localhost:8080/hello-world```
1. Fibonacci (replace <code>n</code> with the number of Fibonacci
   numbers in the sequence to be calculated)
    1. Exponential Complexity (O(2^n))
        1. ```curl http://localhost:8080/fib-exp/{n}```
    1. O(n) Complexity
        1. ```curl http://localhost:8080/fib-On/{n}```
    1. Tail Recursive: Complexity of Calculating Previous Value + (n - 1)
        1. ```curl http://localhost:8080/fib-tail-rec/{n}```
1. Deadlock
    1. ```curl http://localhost:8080/deadlock```
1. CRUD
    1. Find Album By Id (replace id with number between 1 and 9)
        1. ```curl http://localhost:8080/album/{id}```
    1. Find All Albums
        1. ```curl http://localhost:8080/albums```
    1. Create Album (with example body)
        1. ```curl -H "Content-Type: application/json" -X POST -d '{"title":"Vs.", "artist":"Pearl Jam", "label":"Epic"}' http://localhost:8080/album```
    1. Delete Album By Id (replace id with number between 1 and 9)
        1. ```curl -X DELETE http://localhost:8080/album/{id}```
    1. Delete Album (with example body)
        1. ```curl -H "Content-Type: application/json" -X DELETE -d '{"id":1,"title":"Ten", "artist":"Pearl Jam", "label":"Epic"}' http://localhost:8080/album```
1. External Endpoint (gets content from https://jsonplaceholder.typicode.com/posts)
    1. ```curl http://localhost:8080/external-endpoint```

### Additional Features
1. JaCoCo code coverage report available at: <code>target/coverage-reports/jacoco-ut/index.html</code>
    1. Current coverage is 62%
1. JavaDoc available at: <code>target/apidocs/index.html</code>