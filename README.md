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


## El proyecto proporcia los siguien Enpoind:
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


## Documentacion con OpenApi.

•  Enpoints Materias:

<img width="1333" height="518" alt="image" src="https://github.com/user-attachments/assets/cc4a8fcc-e9ce-4ac1-820e-4f2f400fed23" />

•  Enpoints Alumnos:

<img width="1323" height="314" alt="image" src="https://github.com/user-attachments/assets/67e59811-02f6-4466-9cac-d8c85ce2373e" />

•  Enpoints Notas:

<img width="1316" height="206" alt="image" src="https://github.com/user-attachments/assets/4d5e7f3a-74e5-4d4d-ac1f-d3158390afc9" />


## pruebas Enpoints:

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
   Metodo: GET
   
   Body Response:
   
   ```JSON
  {
    "status": 200,
    "message": "Operación exitosa",
    "data": {
        "content": [
            {
                "codigo": "05",
                "creditos": 2,
                "id": 1,
                "nombre": "Fisica",
                "notas": []
            },
            {
                "codigo": "01",
                "creditos": 3,
                "id": 2,
                "nombre": "Matematicas",
                "notas": []
            }
        ],
        "empty": false,
        "first": true,
        "last": true,
        "number": 0,
        "numberOfElements": 2,
        "pageable": {
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 10,
            "paged": true,
            "sort": {
                "empty": false,
                "sorted": true,
                "unsorted": false
            },
            "unpaged": false
        },
        "size": 10,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "totalElements": 2,
        "totalPages": 1
    }
}

<img width="1274" height="571" alt="image" src="https://github.com/user-attachments/assets/01648814-8e7d-46fb-bc3d-0cb49aa6ac2b" />


3. **Consultar materia por ID: Detalle de una asignatura específica.**
   
   URL: http://localhost:8080/materias
   
   ```JSON
   {"codigo": "05",
    "creditos": 2,
    "nombre": "Fisica"
   }

<img width="1286" height="453" alt="image" src="https://github.com/user-attachments/assets/d13e0389-49af-437a-b3b5-0cd468816d13" />

4. **Actualizar materia: Edición de nombre o detalles de la asignatura.**
   
   URL: http://localhost:8080/materias
   
   ```JSON
   {"codigo": "05",
    "creditos": 2,
    "nombre": "Fisica"
   }

<img width="1286" height="453" alt="image" src="https://github.com/user-attachments/assets/d13e0389-49af-437a-b3b5-0cd468816d13" />


5. **Eliminar materia: Remoción de una asignatura del sistema.**
   
   URL: http://localhost:8080/materias/1
   Metodo: Delete
   
   ```JSON
   {"codigo": "05",
    "creditos": 2,
    "nombre": "Fisica"
   }

<img width="1286" height="453" alt="image" src="https://github.com/user-attachments/assets/d13e0389-49af-437a-b3b5-0cd468816d13" />






## Variables de Entorno Requeridas

Para ejecutar la aplicación, configura las siguientes variables de entorno:

| Variable | Descripción | Valor por Defecto | Requerido |
|----------|-------------|-------------------|-----------|
| `DB_URI` | URL de conexión a PostgreSQL | jdbc:postgresql://postgres:5432/notasdb | Sí |
| `DB_USER` | Usuario de la base de datos | notas_user | Sí |
| `DB_PASSWORD` | Contraseña de la base de datos | StrongPass123! | Sí |
| `DB_DRIVER` | Driver JDBC de PostgreSQL | org.postgresql.Driver | Sí |


## Instrucciones de Ejecución (Máximo 10 comandos)

### Opción 1: Usando Docker Compose (Recomendado)

1. **Clonar el repositorio:**
   ```bash
   git clone <url-del-repositorio>
   cd gestion-notas
