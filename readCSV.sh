#!/bin/bash

#mvn clean
rm -f res.csv
tail -n +2 file.csv >> tmp.csv

while read line;
do
    echo -ne "$line" >> res.csv
    testName="$(cut -d';' -f $1 <<< $line | sed 'y/áàâäçéèêëîïìôöóùúüñÂÀÄÇÉÈÊËÎÏÔÖÙÜÑ/aaaaceeeeiiiooouuunAAACEEEEIIOOUUN/') "
    echo "parameters = $@"
    echo "param number = $#"
    if [[ "$#" -eq 1 ]] || [[ "$@" =~ (^|[[:space:]])${testName}($|[[:space:]]) ]];
    then
        mvn test -Dtest="${testName}"
        if [[ "$?" -ne 0 ]] ;
        then
            echo -e ";KO" >> res.csv
        else
            echo -e ";OK" >> res.csv
        fi
    else
        echo -e ";Didn't Run" >> res.csv

    fi
done < tmp.csv