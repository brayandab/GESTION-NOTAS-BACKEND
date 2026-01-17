# Proyecto de Gestión de Notas - Spring Boot.

PRUEBA: TECNICA-FULL-STACK

DESARROLLADA POR: BRAYAN DAVID BANGUERA ALEGRIA.

API REST para gestión de Alumnos, Materias y Notas con Spring Boot, PostgreSQL y la parte de Frontend ha sido desarrollado con React. Del lado del Backend la apliación cuenta con una arquitectura orientada a Servicios en tres capas.

## Modelo Entidad Relación.
Para la base de datos de acuerdo al análisis que se hizo del requrimiento se realizo el siguiente modelo entidad relación (MER).

<img width="598" height="386" alt="image" src="https://github.com/user-attachments/assets/5ab75a0c-f768-4be0-8d4a-b676ee7d7beb" />


## El proyecto proporcia los siguien Enpoind:.


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
