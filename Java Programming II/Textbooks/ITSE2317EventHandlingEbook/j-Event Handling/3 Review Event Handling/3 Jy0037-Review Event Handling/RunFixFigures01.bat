echo off
rem 07/06/11
rem The purpose of this batch file is to run a 
rem program named FixFigures01, which renumbers a set
rem of Figures in an xhtml file beginning with the
rem last one and ending with the first one.

rem Requires the name of the htm file (without an
rem extension) and a list of "changeFrom" and "changeTo" figure 
rem numbers as command-line parameters.

rem The output file name has the word "revised"
rem inserted before the extension.

rem Modify the following command for each new module
java -cp M:\Baldwin\AA-School\JavaProg\Combined\Java FixFigures01 Phy1080 A 1 B 2 C 3 1 4 2 5 3 6 4 7 5 8 D 9 E 10 F 11 6 12 7 13 8 14 9 15

pause