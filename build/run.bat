IF EXIST bin/szoftlab GOTO RUN
mkdir bin
javac -d bin ../src/szoftlab/szoftlab/*.java

:RUN
java -cp bin szoftlab.Program
pause
cls
GOTO RUN


