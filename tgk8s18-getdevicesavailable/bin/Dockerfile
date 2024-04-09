#**************************************************************************
# Copyright (C) 2023 Mob Army S.R.L. - All Rights Reserved
# Unauthorized copying of this file, via any medium is strictly prohibited.
# Proprietary and confidential.
# Written by Mob Army <info@wwtelecommunications.com>, 2023 for TELEFONICA
# CELULAR DE BOLIVIA S.A. (Telecel S.A.) use only.
# *************************************************************************

# Primera etapa: compila el proyecto
FROM maven:3.8.1-openjdk-8-slim AS build

# Establecer las variables de entorno para el proxy HTTP y HTTPS
ENV MAVEN_OPTS="-Dhttp.proxyHost=10.250.0.12 -Dhttp.proxyPort=1522 -Dhttps.proxyHost=10.250.0.12 -Dhttps.proxyPort=1522"

# Configurar el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml al contenedor
COPY pom.xml .

# Descarga todas las dependencias del proyecto y las almacena en el directorio .m2 del contenedor
RUN mvn dependency:go-offline -B

# Copia todo el código fuente al contenedor
COPY src/ ./src/

# Compila el proyecto
RUN mvn clean package

# Segunda etapa: ejecuta el proyecto
FROM openjdk:8-jre-slim
WORKDIR /app

# Copia el archivo JAR generado por la primera etapa al contenedor
COPY --from=build /app/target/tgk8s18-getdevicesavailable-1.0.0-SNAPSHOT.jar .

# Exponer puerto
EXPOSE 9091

# Variable de Zona horaria
ENV TZ=America/La_Paz

# Agergar la zona horaria al contenedor
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone