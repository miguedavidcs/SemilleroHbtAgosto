@echo off
::Realizado por: Miguel Castaño
echo *****SEMILLEROSCRIPT2022******
echo ***** quien me ayuda******

set d1=semillero-servicios
set d2=semillero-ear
echo *****Activando modo flojera******

start "%d2%" /D "C:\Users\Usuario\OneDrive\Documents\SemilleroHBT2022\semillero-padre" mvn clean install 
echo Si el proyecto %d2% compilo con exito la parte PADRE, presiona cualquier tecla...
pause >nul

start "%d1%" /D "C:\Users\Usuario\OneDrive\Documents\SemilleroHBT2022\semillero-padre\semillero-servicios" mvn clean install 
echo Si el proyecto %d1% compilo con exito la parte Servicio, presiona cualquier tecla...
pause >nul
echo *****Esperemos si Dios quiere funciona******



cd /D "C:\wildfly-15.0.1.Final\standalone\deployments" 
echo Limpiando directorio...
del /F /S /Q *.ear
del /F /S /Q *.deployed


echo Copiando .ear
xcopy C:\Users\Usuario\OneDrive\Documents\SemilleroHBT2022\semillero-padre\semillero-ear\target\semillero-ear-1.0-SNAPSHOT.ear "C:\wildfly-15.0.1.Final\standalone\deployments"  



echo Ejecutando .bat
cd /D "C:\wildfly-15.0.1.Final\bin"  
call standalone.bat
pause
:exit