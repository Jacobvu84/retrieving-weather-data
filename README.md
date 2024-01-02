## Running the tests under Maven
To run the tests with Maven, open a command window and run:

```
>mvn clean verify
```

## Runs every day at 7:00 AM and repeats every hour for a duration of 1 day

```
schtasks /create /tn "Execution Test Hourly" /tr "../run.bat" /sc DAILY /st 07:00 /f /RI 60 /du 24:00
```

run.bat

```
mvn clean verify -f %CD%\pom.xml
```

## Viewing the reports
The commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!

![image](https://github.com/Jacobvu84/retrieving-weather-data/assets/983936/a81e69f3-f99a-48da-9a86-3d66b28e0cd8)

![image](https://github.com/Jacobvu84/retrieving-weather-data/assets/983936/74c90b15-51d6-4ee1-be00-1bca730e55be)

![image](https://github.com/Jacobvu84/retrieving-weather-data/assets/983936/01c5a72b-9f47-42af-9a2b-9c1227d44af3)

![image](https://github.com/Jacobvu84/retrieving-weather-data/assets/983936/993bbd3c-e741-4bbe-a65a-d11768458627)
