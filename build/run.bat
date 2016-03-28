IF EXIST bin/szoftlab GOTO RUN
mkdir bin
javac -d bin ../src/szoftlab/szoftlab/*.java
GOTO RUN

:RUN
java -cp bin szoftlab.SeqTester
pause

