# AUTORIA

* [Jorge Rambla](https://github.com/jorgeRambla)
* [Gonzalo Berné](https://github.com/MegaGera)
* [Alejandro Navarro](https://github.com/ANavarro96)

#	INSTALACIÓN DE LA RED SOCIAL
Explicacion para desplegar en ubuntu 16

1. Ejecutar:

```sh
#!/bin/bash
mkdir redSocial
cd redSocial
git clone https://github.com/UNIZAR-30245-2018/modelo-control.git "modelo"
git clone https://github.com/UNIZAR-30245-2018/Back-End-DataBase-.git "DB"
git clone https://github.com/UNIZAR-30245-2018/vista


sudo apt-get install default-jdk

sudo apt-get install mysql-server mysql-client

echo "\n\n--------OPERACIONES DE ROOT--------\n\n"
mysql -u root -p -e "CREATE DATABASE sistInfBD"
mysql -u root -p -e "CREATE USER 'usuarioSIBD'@'localhost' IDENTIFIED BY 'claveSIBD'"
mysql -u root -p -e "Grant ALL ON sistInfBD.* TO usuarioSIBD@localhost"

cd DB
echo "\n\n--------OPERACIONES DE usuarioSIBD--------\n\n"
echo "\n\n--------clave: claveSIB--------\n\n"
mysql -u usuarioSIBD -p sistInfBD < codigo\ SQL.sql
mysql -u usuarioSIBD -p sistInfBD < juegos\ SQL.sql --force
mysql -u usuarioSIBD -p sistInfBD < logros\ SQL.sql

mysql -u usuarioSIBD -p -e "USE sistInfBD"

## TOMCAT

cd ../modelo
mkdir bin
echo pwd
pwd

javac -d bin -sourcepath src -classpath 'lib/servlet-api.jar:lib/mysql-connector-java-5.1.40-bin.jar:lib/commons-codec-1.11.jar' src/control/*.java src/modelo/datos/WebFacade.java src/modelo/datos/BD/GestorDeConexionesBD.java src/modelo/datos/DAO/*.java src/modelo/datos/VO/*.java

cd ../vista/WEB-INF
mkdir classes

cp -r ../../modelo/bin/* classes

cd ..

echo pwd
pwd

jar -cvf vista.war *

mv vista.war ../

cd ..

rm -rf modelo/
rm -rf DB/
rm -rf vista/
```
2. Descargar Apache Tomcat [descargar](https://tomcat.apache.org/download-70.cgi)
3. Levantar Apache Tomcat
```sh
[Ruta Tomcat]/bin/startup.sh
```
4. Mover el archivo generado a la carpeta [Ruta Tomcat]/webapps
5. Esperar a que se despliegue
