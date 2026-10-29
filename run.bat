@echo off
cd /d "%~dp0"
if not exist build mkdir build
javac -d build LabAsset.java Main.java
if errorlevel 1 (
    echo Compilation failed. Check that the Java Development Kit is installed.
    pause
    exit /b 1
)
java -cp build Main
pause
