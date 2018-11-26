#!/bin/bash

mvn clean
rm -f res.csv

while read line;
do
    echo -ne "$line" >> res.csv
    testName="$(cut -d';' -f $COLUMNNUMBER <<< $line)"
	nbTest=$(wc -w <<< "$TESTLIST")
    if [[ "${nbTest}" -eq 0 ]] || [[ "$TESTLIST" =~ (^|[[:space:]])${testName}($|[[:space:]]) ]];
    then
        mvn test -Dtest="${testName}"
        if [[ "$?" -ne 0 ]] ;
        then
            echo -e ";KO" >> res.csv
        else
            echo -e ";OK" >> res.csv
        fi
    else
        echo -e ";Ignore" >> res.csv

    fi
done < testcase.csv