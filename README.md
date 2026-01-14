## Crud en Java
Este proyecto esta enfocado en hacer una migracion de js a java.

## Equivalencias 
Las equivalencias en los diferentes lenguajes, express es equivalente a Spring Boot y sus dependencias: las herramientas que utilizamos son:
- Spring Web: Esta maneja rutas y responde petiiones de HTTP y añade la empaquetacion a JSON.
- Spring Data JPA: convierte clases en tablas sql automaticamente y extiende JpaRepositoru araa un crud automatico.
- PostgresSQL Drivwer: Conecta a java con postgreSQL y añade java.sql.Driver 
- Vlidation: Revisa que el campoo direccion no este vacio y añade @Notblank etc.
- Spring Boot DevTools: Al cambiar codigo el servidor se reinicia solo

## Archivos
pom.xml           
src/main/java/com/example/
  controler.java     
  AlumnoException.java     
  GobalException.java   
  Alumno.java   
  Alumnorepository.java
  AlmnosApiAplication

recursos/
  properties.txt         
  Index.html

## Que contiene cada archivo
  # Pom
  El pom contiene las dependencias maven, que se utilizaran para mejor facilidad en la creacion del proyecto.
  # MVN
  Este conteiene el script de maven.
  # AlummnoApiAplication.java
  Este archivo arranca todo.
  # AlumnoController.Java
  Este contiene los puertos HTTP y recibe pedidos.
  # AlunoService.Java 
  Esste contiene la logica del proyecto
  # AlumnoRepository.Java 
  Este almacena la base de datos automaticamente.
  # Alumno.java
  Este contiene Estructura de datos de la tabla de cada alumno.
  # Aplication.properties
  Este archivo tiene las configuraciones (ya viene creado)
  # AlumnoException
  Contiene mensajes para devolver si algo falla, asi como excepciones.

  ## Como funciona?
  1. Se llenan los campos de la pagina web
  2. Se envian los campos
  3. Js envia datos a controller, controler recibe datos, service valida un unico telefono, respository guarda alumnos, controller devuelve al index alumnos en pantalla.
  4. Se crea el nuevo alumno en la pagina web.
