# API REST - Gestión de Estudiantes

Este proyecto es una API REST desarrollada con Spring Boot desde Visual Studio Code, usando Maven para evitar instalar dependencias manualmente.

RECOMENDACIONES
- Revisar puertos: Si el 8082 está ocupado, edita "application.properties" y usa otro.
- Verificar versión de Java**: Si no tienes la versión 24, cambia en "pom.xml":
 "  <java.version>24</java.version> "
- **Base de datos**: Se usa "gestion_estudiantes"
- **Tablas automáticas**: Si las tablas no existen, Spring Boot las generará al arrancar.

##Descripción
Proyecto de gestión de estudiantes con endpoints **GET, POST, PUT, DELETE**, usando **DTOs** para manejar los datos correctamente.
La base de datos utilizada es **PostgreSQL** y las dependencias necesarias ya están en "pom.xml".
