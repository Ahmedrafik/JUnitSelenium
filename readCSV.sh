#!/bin/bash

mvn clean
if [ "$#" -ne 1 ];
then
  echo "Aucun test séléctionner"
  mvn test
else
  for var in $@
  do
    mvn test -Dtest=$var
  done
fi
