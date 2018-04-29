#!/bin/bash
#This installs maven if it does not already exist. It should work on pretty much any unix system, since it downloads with curl and not a package manager
mvn=""
if ! [ -x "$(command -v mvnaa)" ]; then
	if [ ! -f ./maven/bin/mvn ]; then
		curl -o apache-maven-3.5.3-bin.tar.gz http://apache.osuosl.org/maven/maven-3/3.5.3/binaries/apache-maven-3.5.3-bin.tar.gz
		tar -xf apache-maven-3.5.3-bin.tar.gz
		mv ./apache-maven-3.5.3 ./maven
		rm ./apache-maven-3.5.3-bin.tar.gz
	fi
	mvn=./maven/bin/mvn
else
	mvn=mvn
fi

if [ "$1" = "build" ]; then
	mvn clean package
elif [ "$1" = "run" ]; then
	mvn exec:java -D exec.mainClass=nostalgia.ChallengeFriends
elif [ "$1" = "test" ]; then
	mvn test
elif [ "$1" = "help" ] || [ "$1" = "" ]; then
	echo ""
	echo "Handles maven installation and commands"
	echo "	Commands(case sensitive):"
	echo "	 - build : builds the project with the mvn(maven) command line tool"
	echo "	 - run : runs the currently built version of the project"
	echo "	  (eg ./nostalgia.sh run)"
	echo ""
	if [ "$1" = "" ]; then
		read -p "Press enter to continue"
	fi
fi
