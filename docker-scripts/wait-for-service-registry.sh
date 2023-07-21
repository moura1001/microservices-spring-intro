#!/bin/sh
RETRIES=${RETRIES:-5}
UP='{"status":"UP"}'

check() {
    local RESULT="$(curl --fail --silent service-registry:8761/actuator/health | jq -c -r)"
    if [ "$RESULT" == "$UP" ]; then
        echo "1"
    else
        echo "0"
    fi
}

STATUS="0"

for i in $(seq 1 $RETRIES); do
    sleep 10s
    STATUS=`check $i`
    echo "STATUS: $STATUS"
    if [ "$STATUS" == "1" ]; then
        break
    fi
done

if [ "$STATUS" == "1" ]; then
    echo "waiting for spring boot initialization"
    java -jar /opt/app/*.jar
else
    exit 1
fi