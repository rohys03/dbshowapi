#!/bin/sh
export DBSHOWAPI_HOME=/app/puser/dbshowapi
export JAVA_HOME=/app/jdk/bin/java
export JAVA_OPT=''
export APP_OPT='--server.port=8082 --spring.profiles.active=stage'

nohup java $JAVA_OPTS -jar $DBSHOWAPI_HOME/build/libs/dbshowapi-0.0.1-SNAPSHOT.jar $APP_OPT >> $DBSHOWAPI_HOME/log/log.out 2>&1 &
