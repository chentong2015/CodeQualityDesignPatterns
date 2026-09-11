## Exercise Project :
#### Find the final position after serials of instructions from the init position
- 4 types of direction (E, S, W, N)
- 3 types of order/instruction (A, D, G)

### Diagram
![Test Design](https://github.com/chentong2023/PublicisSapientTechProject/assets/128691291/cc19eaab-8cce-4432-8d11-ba894786617f)

## Build project

In order to build the project, make sure you have java runtime environment on your machine, 
> **_NOTE:_** The project is complied based on Java 11, it's highly recommended to use the version >= 11.

Go to project root folder and build project with maven command: 
- For windows
 ```
> mvnw.cmd clean package
 ```

- For Linux
```
> ./mvnw clean package
```

While packaging the project
1. It will launch all unit tests automatically, and create testing .log file under /log folder
2. project-jar-with-dependencies.jar file will be generated under /target folder

## Run application from cmd/terminal
### Input
Before running the app, please prepare the input <strong>txt</strong> file, put it in any folder as you like.

Below is an example of txt file:
```
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
```

### Run application
Execute .jar file from cmd (from windows) or terminal (Linux, Mac) by providing fullpath of txt file as parameter.
> **_NOTE:_** The fullpath should not contain any space inside.

Below is an example:
```
> java -jar project-jar-with-dependencies.jar C:\test\file_simple.txt
```

Below is an example for executing several files at the same time
```
> java -jar project-jar-with-dependencies.jar C:\test\file_simple.txt C:\test\file_complex.txt
```

### Log
The corresponding .log file will be generated each time (based on timestamp) after running the app successfully, 
Please check .log file under /log (relative path) folder.

Here is an example of .log:
```
2023-11-17 18:29:23,095 [main] [INFO ] com.publicis.test.MainApplication - Loading filepath: C:\test\file_simple.txt 
2023-11-17 18:29:23,097 [main] [INFO ] com.publicis.test.io.FileSourceManager - Read file line '5 5' for border coordinate 
2023-11-17 18:29:23,097 [main] [INFO ] com.publicis.test.io.FileSourceManager - Read init position '1 2 N' 
2023-11-17 18:29:23,097 [main] [INFO ] com.publicis.test.io.FileSourceManager - Read orders line string 'GAGAGAGAA' 
2023-11-17 18:29:23,098 [main] [INFO ] com.publicis.test.io.FileSourceManager - Read init position '3 3 E' 
2023-11-17 18:29:23,098 [main] [INFO ] com.publicis.test.io.FileSourceManager - Read orders line string 'AADAADADDA' 
2023-11-17 18:29:23,098 [main] [INFO ] com.publicis.test.MowerMachine - Init Mower Machine with position: 1 2 N 
2023-11-17 18:29:23,102 [main] [INFO ] com.publicis.test.MainApplication - Final Position: 1 3 N 
2023-11-17 18:29:23,102 [main] [INFO ] com.publicis.test.MowerMachine - Init Mower Machine with position: 3 3 E 
2023-11-17 18:29:23,102 [main] [INFO ] com.publicis.test.MainApplication - Final Position: 5 1 E 
```

Here is an example of exception:
```
2023-11-19 14:31:19,648 [main] [INFO ] com.publicis.test.MainApplication - Loading filepath: C:\test\file_with_wrong_init_position.txt 
2023-11-19 14:31:19,651 [main] [INFO ] com.publicis.test.io.FileSourceManager - Read file line '10 10' for border coordinate 
2023-11-19 14:31:19,651 [main] [INFO ] com.publicis.test.io.FileSourceManager - Read init position '1 20 N' 
2023-11-19 14:31:19,652 [main] [INFO ] com.publicis.test.io.FileSourceManager - Read orders line string 'GAGAGAGAAGD' 
2023-11-19 14:31:19,653 [main] [ERROR] com.publicis.test.MainApplication - Init position is out of Border 
com.publicis.test.exception.IndexOutOfBorderException: Init position is out of Border
	at com.publicis.test.MowerMachine.<init>(MowerMachine.java:23)
	at com.publicis.test.MainApplication.playMowerMachine(MainApplication.java:43)
	at com.publicis.test.MainApplication.main(MainApplication.java:25)
```

