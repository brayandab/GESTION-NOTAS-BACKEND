# Proyecto de Gestión de Notas - Spring Boot.

PRUEBA: TECNICA-FULL-STACK

DESARROLLADA POR: BRAYAN DAVID BANGUERA ALEGRIA.

API REST para gestión de Alumnos, Materias y Notas con Spring Boot, PostgreSQL y la parte de Frontend ha sido desarrollado con React. Del lado del Backend la apliación cuenta con una arquitectura orientada a Servicios en tres capas.

## Repositorios

   • Backend: https://github.com/brayandab/GESTION-NOTAS-BACKEND
   
   • Frontend: https://github.com/brayandab/GESTION-NOTAS-FRONTEND

## Modelo Entidad Relación.
Para la base de datos de acuerdo al análisis que se hizo del requrimiento se realizo el siguiente modelo entidad relación (MER).

<img width="598" height="386" alt="image" src="https://github.com/user-attachments/assets/5ab75a0c-f768-4be0-8d4a-b676ee7d7beb" />


## El proyecto proporciona los siguientes Enpoind:
Alumno

      •	Crear una materia: Alta de nuevas asignaturas en el catálogo.
      
      
      • Listar todos los alumnos: Consulta general de la base de datos de estudiantes.
      
      • Consultar un alumno por ID: Obtener información detallada de un estudiante específico.
      
      • Actualizar un alumno: Modificar datos existentes de un estudiante.
      
      • Eliminar un alumno: Borrar el registro de un estudiante del sistema.

Materia
      
      • Crear una materia: Alta de nuevas asignaturas en el catálogo.
      
      • Listar materias: Visualización de todas las materias disponibles.
      
      • Consultar materia por ID: Detalle de una asignatura específica.
      
      • Actualizar materia: Edición de nombre o detalles de la asignatura.
      
      • Eliminar materia: Remoción de una asignatura del sistema.

Nota
     
      • Registrar nota: Asignar una calificación a un alumno en una materia específica.
      
      • Listar notas por alumno: Consultar el historial de calificaciones de un estudiante desglosado por materia.


## Documentación con OpenApi.

•  Endpoints Materias:

<img width="1333" height="518" alt="image" src="https://github.com/user-attachments/assets/cc4a8fcc-e9ce-4ac1-820e-4f2f400fed23" />

•  Endpoints Alumnos:

<img width="1323" height="314" alt="image" src="https://github.com/user-attachments/assets/67e59811-02f6-4466-9cac-d8c85ce2373e" />

•  Endpoints Notas:

<img width="1316" height="206" alt="image" src="https://github.com/user-attachments/assets/4d5e7f3a-74e5-4d4d-ac1f-d3158390afc9" />


## pruebas Endpoints:

1. **Crear una materia: Alta de nuevas asignaturas en el catálogo.**
   
   URL: http://localhost:8080/materias
   Metodo: POST
   
   ```JSON
   {"codigo": "05",
    "creditos": 2,
    "nombre": "Fisica"
   }

<img width="1286" height="453" alt="image" src="https://github.com/user-attachments/assets/d13e0389-49af-437a-b3b5-0cd468816d13" />
2. **Listar materias: Visualización de todas las materias disponibles.**
   
   URL: http://localhost:8080/materias
   
   Método: GET
     

<img width="1274" height="571" alt="image" src="https://github.com/user-attachments/assets/01648814-8e7d-46fb-bc3d-0cb49aa6ac2b" />


3. **Consultar materia por ID: Detalle de una asignatura específica.**
   
   URL: http://localhost:8080/materias/1
   
   <img width="1297" height="469" alt="image" src="https://github.com/user-attachments/assets/c2f38f59-ca9e-4899-a816-690a758d416f" />




4. **Actualizar materia: Edición de nombre o detalles de la asignatura.**
   
  <img width="917" height="506" alt="image" src="https://github.com/user-attachments/assets/625d9242-060b-46b5-aa29-9b7a5acec39d" />



5. **Eliminar materia: Remoción de una asignatura del sistema.**
   
   URL: http://localhost:8080/materias/1
   Metodo: Delete
   
   <img width="940" height="398" alt="image" src="https://github.com/user-attachments/assets/de8400f9-7859-45a7-a158-a64e64cc1a97" />







## Variables de Entorno Requeridas

Para ejecutar la aplicación, configura las siguientes variables de entorno:

| Variable | Descripción | Valor por Defecto | Requerido |
|----------|-------------|-------------------|-----------|
| `DB_URI` | URL de conexión a PostgreSQL | jdbc:postgresql://postgres:5432/notasdb | Sí |
| `DB_USER` | Usuario de la base de datos | notas_user | Sí |
| `DB_PASSWORD` | Contraseña de la base de datos | StrongPass123! | Sí |
| `DB_DRIVER` | Driver JDBC de PostgreSQL | org.postgresql.Driver | Sí |


## Instrucciones para Desplegar en Docker (Backend y Base de Datos Postgres).

1. **Clonar el repositorio Descritos anteriormente:**
   
   • Backend: https://github.com/brayandab/GESTION-NOTAS-BACKEND
   
   ```bash
   git clone https://github.com/brayandab/GESTION-NOTAS-BACKEND
   cd GESTION-NOTAS-BACKEND

2. **Camandos para desplegar en docker mediante compose.(asegurarse de esta en la carpeta del proyecto clonado anteriormete.)**
   ```bash
     docker-compose up --build

Si se realizo correctamente las instrucciones se veran en consola lo siguiente:
<img width="1336" height="665" alt="image" src="https://github.com/user-attachments/assets/32f90bab-5c9d-4f42-9f23-d9fc28c061c4" />

Y se podrá mirar que la apliacion esta corriendo en la siguiente URL:

http://localhost:8080/swagger-ui/index.html


## Instrucciones para Desplegar Localmente el Frontend.
1. **Clonar el repositorio Descritos anteriormente del frontend:**
   
   • Frontend: https://github.com/brayandab/GESTION-NOTAS-FRONTEND
   
   ```bash
   git clone https://github.com/brayandab/GESTION-NOTAS-FRONTEND
   cd GESTION-NOTAS-FRONTEND

   Luego ejecutar el siguiente comando.
   npm run dev


Para Acceder a la Aplicación ir a la siguiente URL: http://localhost:5173/materias
 
