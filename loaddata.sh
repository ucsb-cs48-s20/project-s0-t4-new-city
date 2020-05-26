#!/bin/sh
if [ "$#" -ne 1 ] ; then
  echo "Usage: $0 heroku-app-name"
else
    newline=$'\n'
    echo "loading data into $1"
    JDBC_DATABASE_URL=`heroku run -a $1 echo \\$JDBC_DATABASE_URL`
    PRODUCTION_PROPERTIES=`heroku config:get PRODUCTION_PROPERTIES --app $1`
    export PRODUCTION_PROPERTIES="$PRODUCTION_PROPERTIES $newline spring.datasource.url=$JDBC_DATABASE_URL $newline HEROKU_APP=$1"
fi