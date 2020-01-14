#!/bin/sh

echo "Starting runner..."

COUNTER=0

until curl --output /dev/null --silent --fail http://template-app:8081/management/health;
do
  sleep 1;

  if [ $COUNTER -gt 30 ]
  then
    "app was never up..!";
    exit 1;
  fi

  COUNTER=$((COUNTER+1))
  echo "waiting for app healthy, $COUNTER..."
done

echo "app up..!"

cp -R /copy /app
cd /app
gradle test -DintegrationTest=true
