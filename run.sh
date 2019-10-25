#!bin/bash
#java -Djava.security.egd=file:/dev/./urandom -Xms2048m -Xmx2048m -XX:MaxPermSize=512m -cp /app.jar -Dloader.main=$1 org.springframework.boot.loader.PropertiesLauncher
exec java -Djava.security.egd=file:/dev/./urandom -cp /app.jar -Dloader.main=io.spring.boot.starter.StarterApplicationKt org.springframework.boot.loader.PropertiesLauncher
