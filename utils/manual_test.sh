#!/usr/bin/env sh
mvn clean package -DskipTests

# Set Tomcat variables
export CATALINA_HOME="$(pwd)/apache-tomcat"
export CATALINA_PID="$CATALINA_HOME/bin/catalina.pid"

# Register the profiler
export CATALINA_OPTS="-javaagent:teamscale-jacoco-agent/lib/teamscale-jacoco-agent.jar=config-file=teamscale-jacoco-agent/jacocoagent.properties"

# Deploy application to Tomcat
cp "bank/target/digitalbank-2.1.0.local.war" "$CATALINA_HOME/webapps/bank.war"

# Start tomcat and testing
$CATALINA_HOME/bin/catalina.sh start
echo "Please run your tests at http://localhost:8081/bank"
echo "You can login with user jsmith@demo.io and password Demo123!"
echo "To stop testing, press any key."
read LINE

# Shutdown Tomcat to upload coverage to Teamscale
$CATALINA_HOME/bin/catalina.sh stop
