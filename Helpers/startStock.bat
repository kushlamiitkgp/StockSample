@echo off
cd ..

start "config server" java -jar -Xmx120m ".\Microservices\ConfigServer\build\libs\ConfigServer.jar"
timeout /t 25

start "ServiceRegistry server" java -jar ".\Microservices\ServiceRegistry\build\libs\ServiceRegistry.jar"
timeout /t 20

start "ApiGateway server" java -jar ".\Microservices\ApiGateway\build\libs\ApiGateway.jar"
timeout /t 20

start "AuthMgmt server" java -jar ".\Microservices\AuthMgmt\build\libs\AuthMgmt.jar"
timeout /t 20

start "UserMgmt server" java -jar ".\Microservices\UserMgmt\build\libs\UserMgmt.jar"
timeout /t 20

start "StockMgmt server" java -jar ".\Microservices\StockMgmt\build\libs\StockMgmt.jar"



:: start "config server" java -jar ".\Microservices\ServiceRegistry\build\libs\ConfigServer.jar"