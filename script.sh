#!/bin/bash

PROJECT_ROOT="."
cd "$PROJECT_ROOT/src/main/java"

## prompt the user for their mysql credentials in order to setup the database
read -p "Enter your MySQL host: " dbHost
read -p "Enter your MySQL port: " dbPort
read -p "Enter your MySQL username: " dbUser
read -s -p "Enter your MySQL password: " dbPassword
echo
echo


## Print the PATH
echo "PATH: $PATH"

## Setup MySQL
## Check if MySQL is installed and added to the system's PATH
if command -v mysql >/dev/null 2>&1 ; then
  echo "MySQL found."
else
  echo "MySQL not found. Please ensure MySQL is installed and added to the PATH."
  exit 1
fi
##Setup MySQL
##FIRST MAKE SURE MySQL is installed and that its added to the system's PATH
##Find the directory where the MySQL binaries are located. This directory contains the mysql executable. If you installed MySQL using the MySQL Installer on Windows, the default path might be something like:
##on a CLI, execute the cmd: setx PATH "%PATH%;C:\Program Files\MySQL\MySQL Server x.x\bin"
##if successful, execute: mysql --version on cli to verify
#mysql -h "$dbHost" -P "$dbPort" -u"$dbUser" -p"$dbPassword" -e "CREATE DATABASE IF NOT EXISTS budgettracker"

# rm -f App.class

##Compile and run The Java app with the provided values
javac App.java
java App "$dbHost" "$dbPort" "$dbUser" "$dbPassword"
