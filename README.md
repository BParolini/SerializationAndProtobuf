# Serialization and Protobuf

The intention behind this project was just to check the output binary files generated by [Java's default serialization][java_serialization] mechanism and [Protocol Buffer][protobuf].

## Technologies
- Java 17
- Gradle 7.3-rc-3
- Protocol Buffer 3.18.1

## Build and Run
The following commands can be used to build and run the application:
```shell
./gradlew build

./gradlew run
```

## Tests
As the main objective of this application is to test and compare the serialization mechanisms output size, testing the (almost inexistent) logic seemed unnecessary.

If anyone thinks it would be nice to have unit tests, feel free to add them and send a Pull Request.

[java_serialization]: https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html
[protobuf]: https://developers.google.com/protocol-buffers
