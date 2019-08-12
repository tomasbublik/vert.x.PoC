#!bin/bash
java -Djava.security.egd=file:/dev/./urandom -cp /app.jar -Dloader.main=$1 org.springframework.boot.loader.PropertiesLauncher
