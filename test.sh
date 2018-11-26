#!/usr/bin/env bash

input="Count from this String tralala "
nb=$(wc -w <<< "$input")
echo "test number : ${nb}"
