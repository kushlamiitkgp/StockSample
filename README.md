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



**************************************************************************
Service	       * Port	* Spring_App_Name  *  Special_Dependency
****************************************** * *******************************
AuthMgmt	   * 8082	* authmgmt	       *  JPA + Eureka Client + Config
UserMgmt	   * 8081	* usermgmt	       *  JPA + Eureka Client + Config
StockMgmt	   * 8083	* stockmgmt	       *  JPA + Eureka Client + Config
ApiGateway	   * 8080	* api-gateway	   *  Gateway + Eureka Client + Config
ConfigServer   * 8888	* config-server	   *  Config Server + Eureka Client
ServiceRegistry* 8761	* service-registry *  Eureka Server
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