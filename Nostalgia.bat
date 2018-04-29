@echo off
set arg1=%1

::This installs maven if it does not already exist. Should work assuming that it's running on a version of windows with powershell installed (default on windows 10)
if not exist maven\bin\mvn (
    echo [31mNo Maven installation found at .\maven\bin\mvn. Installing maven 3.5.3 now[0m
    PowerShell -NoProfile -ExecutionPolicy Bypass -Command "Invoke-WebRequest -OutFile apache-maven-3.5.3-bin.zip http://apache.mirrors.ionfish.org/maven/maven-3/3.5.3/binaries/apache-maven-3.5.3-bin.zip"
    PowerShell -NoProfile -ExecutionPolicy Bypass -Command "Expand-Archive apache-maven-3.5.3-bin.zip"
    move apache-maven-3.5.3-bin/apache-maven-3.5.3 ./maven
    rmdir apache-maven-3.5.3-bin
    del apache-maven-3.5.3-bin.zip
)

if /i "%arg1%" == "build" (
    echo "Building..."
    maven\bin\mvn clean package
)

if /i "%arg1%" == "test" (
    echo "Testing..."
    maven\bin\mvn test
)

::TODO: Change command to whatever the main class ends up being. It's set to EmailSender right now since that's the only class that's here
if /i "%arg1%" == "run" (
    echo "Running..."
    maven\bin\mvn exec:java -D exec.mainClass=arcade.Main
)

if /i "%arg1%" == "help" (
    echo Handles maven installation and commands
    echo   Commands(case insensitive)
    echo    - build; builds the project with the mvn(maven) command line tool
    echo    - run; runs the currently built version of the project through maven
    echo      (eg .\Nostalgia.bat run)
)

if /i "%~1" == "" (
    echo Handles maven installation and commands
    echo   Commands(case insensitive)
    echo    - build; builds the project with the mvn(maven) command line tool
    echo    - run; runs the currently built version of the project through maven
    echo      (eg .\Nostalgia.bat run)
    PAUSE
)