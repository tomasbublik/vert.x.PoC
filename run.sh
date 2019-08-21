#!bin/bash
java -Djava.security.egd=file:/dev/./urandom -Xms2048m -Xmx2048m -XX:MaxPermSize=512m -cp /app.jar -Dloader.main=$1 org.springframework.boot.loader.PropertiesLauncher
