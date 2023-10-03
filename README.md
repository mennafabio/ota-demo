
# OpenTestingAPI - Demo Application

This is a simple Spring Boot Application holding two services which are used to demonstrate the usage of the OpenTestingAPI Tool.

## Related

This Project is related to
[OpenTestingAPI](https://github.com/opentestingapi) 


## Installation

Install OTA-Demo with Maven.

```bash
  - cd processingService
    - mvn clean install
  - cd validationService
    - mvn clean install
```


## Run Docker Container Locally

Start the containers

```bash
  cd docker
  docker compose up
```
This will start following containers
- PostgreSQL,
- PGAdmin (optional),
- OpenTestingAPI v1.37,
- Kafka Zookeeperless Mode (Kafka KRaft).

GUI of OpenTestingAPI will be available under localhost:50000
## API Reference

As this is just a small application, there is only a POST Mapping needed.

#### POST verarbeite Nachricht

```http
  POST /rest/dateneingang/v1/nachricht
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `nachricht` | `string` | **Required**. Your Message |


## Usage/Examples

Example POST using e.g IntelliJ or Insomnia..

POST http://localhost:8089/validation-service/rest/dateneingang/v1/nachricht

with body
```json
{
	"personendaten": {
		"nachname": "Mustermann",
		"vorname": "Max",
		"anschrift": "Musterstrasse 12",
		"geburtsdatum": "12.12.12",
		"ausweisnr": "ABCDEF1234"
	}
}
```

uploading the provided example testcase
```shell
.\uploadtestcase.sh .\testcase\testcase-01\ 
```
if there is no CRON-Job specified in the test, just execute the testcase manually over the GUI
## Documentation

[OpenTestAPI Specification](https://opentestingapi.github.io/specification/version-1.5/)