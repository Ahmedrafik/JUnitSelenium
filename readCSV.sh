#!/bin/bash

mvn clean
rm -f res.csv
sed -n -e '1,1p' testcase.csv > res.csv
tail -n +2 testcase.csv >> tmp.csv

while read line;
do
    echo -ne "$line" >> res.csv
    testName="$(cut -d';' -f $1 <<< $line | sed 'y/áàâäçéèêëîïìôöóùúüñÂÀÄÇÉÈÊËÎÏÔÖÙÜÑ/aaaaceeeeiiiooouuunAAACEEEEIIOOUUN/')"
	nbTest=$(wc -w <<< "$@") - 2
    if [[ "${nbTest}" -eq 0 ]] || [[ "$@" =~ (^|[[:space:]])${testName}($|[[:space:]]) ]];
    then
        mvn test -Dtest="${testName}Test"
        if [[ "$?" -ne 0 ]] ;
        then
            echo -e ";KO" >> res.csv
        else
            echo -e ";OK" >> res.csv
        fi
    else
        echo -e ";Ignore" >> res.csv

    fi
done < tmp.csv

rm -f tmp.csv
rm -f testcase.csv