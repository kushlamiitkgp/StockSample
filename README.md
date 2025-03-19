**************************************************************************
+-------------------+        +-------------------+       +---------------------+
|                   |        |                   |       |                     |
|  User (Frontend)  +------> |  UserMgmt Service +-----> |  Auth Service       |
|                   |        |                   |       |  (JWT, OAuth2)      |
+-------------------+        +-------------------+       +---------------------+
        |                          |                               |
        |  /register/login         |  Feign Client: /validate      |
        |------------------------->|-----------------------------> |
        |                          |                               |
        |                          |      Returns JWT Token        |
        |                          |<----------------------------- |
        |                          |                               |
        |      JWT Token           |                               |
        |<-------------------------|                               |
        |                          |                               |
        |                          |                               |
        |  /stocks (with token)    |                               |
        |------------------------->|                               |
        |                          |                               |
        |                    +-------------------------------------+
        |                    |         +---------------------------+
        |                    |         | Validates Token & User Info
        |                    |         |
        |                    |         v
        |                    |     +-------------------+
        |                    |     |                   |
        |                    +---> |  Stock Service    |
        |                          |                   |
        |                          +-------------------+
        |                                   |
        |         Authorized Stock List    |
        |<---------------------------------+


**************************************************************************

[Client] → [ApiGateway] → Routes → [Microservices]

Service Registry
├── Tracks: AuthMgmt, UserMgmt, StockMgmt, ApiGateway
└── Supplies config via Config Server

**************************************************************************

Client → http://localhost:8080/auth/login → ApiGateway → authmgmt service
![img_1.png](Helpers/img_1.png)

****************************************************************************
**************************************************************************

Matching Logic while fetching and applying Configurations(Resolution Order)
- authmgmt-default.properties
- authmgmt.properties (if no profile-specific file exists)
- application-default.properties (shared fallback)
- application.properties
**************************************************************************
Runs with Java 17
For building all microservices - go to base branch
.\gradlew clean build

For Building Individually
.\gradlew :ConfigServer:clean :ConfigServer:build

**************************************************************************


**************************************************************************


**************************************************************************