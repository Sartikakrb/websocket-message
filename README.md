# websocket-message

## Developer Guide
This project demonstrates a simple messaging with Spring Boot Java using WebSocket. This project contains two folders for **Web Frontend** and **Web API** . To run this project, you needed to install some required softwares in your local machine.

## Project Requirements
1. JDK 8
2. Spring Boot
3. Intellij Idea
4. Tomcat(embedded with Spring)
5. Gradle Wrapper(embedded with Intellij Idea)
6. Plugin Lombok (plugin in Intellij to automate setter and getter of class)

## Project Structure
```bash
├── src
│   ├── main
│   │   ├── java
│   │   |   ├── config
│   │   |   |   └── WebSocketConfig.java
│   │   |   └── module
│   │   |        ├── message
│   │   |        |   ├── Message.java
│   │   |        |   └── MessageApiController.java
│   │   |        └── MainClass.java
│   │   └── resources
│   │       └── static
│   │            ├── app.js
│   │            └── index.html
│   └── test
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── README.md
└── setting.gradle
```
## Project Description

**build.gradle**
<br>
Below are listed the main dependency in this project.
```
dependencies {
    compile("org.springframework.boot:spring-boot-starter-websocket")
    compile('com.fasterxml.jackson.core:jackson-databind:2.7.5')
    compile(group: 'org.webjars', name: 'sockjs-client', version: '1.0.2')
    compile('org.webjars:stomp-websocket:2.3.3')
 }
```
<br>

**WebSocketConfig.java**
<br>
WebSocketConfig is a config class that enables WebSocket message handling that is marked by ```@Configuration``` and ```@EnableWebSocketMessageBroker```. This class extends ```AbstractWebSocketMessageBrokerConfigurer ``` class to configure the message broker. There two override methods namely ```configureMessageBroker``` and ```registerStompEndpoints```. <br> <br>The method ```configureMessageBroker``` enables message broker to carry the message back to the client which destinations prefixed with ```/topic``` and beside that ```/app``` prefix is designed to bound for ```@MessageMapping``` in the controller ```MessageApiController.java```.
<br><br>

**MessageApiController.java**
<br>
MesssageApiController.java is a file to control the STOP messaging. It is marked by ```@Controller``` annotation. This class is responsible to handle messages to destination ```/hello```and then the method ```greeting``` is called. There is a delay about a second before it return the object ```Message```. The return object is broadcast to all subscribers to ```/topic/greetings```
<br><br>

**Message.java**
<br>
Message.java is a model to hold only one property namely ```content```. In this file is helped with plugin Lombok by Intellij to provide setter and getter of the property.
<br><br>

**Index.html** and **App.js**
<br>
This file is a simple showcase to demonstrate the websocket itselft. It needs library SockJs and Stomp Client. First it will instantiate ```var socket = new SockJS('/message-websocket');``` to connect to the websocket. To show the messages in realtime, the client will subscribe to ```/topic/greetings``` and once the client receives the respond from the server, the client will automatically append the message.
<br><br>

## How to run
Run the MainClass.java from the Intellij and open in the browser link below : http://localhost:8080/

