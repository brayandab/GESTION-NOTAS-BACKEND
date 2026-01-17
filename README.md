# Proyecto de Gestión de Notas - Spring Boot.
PRUEBA: TECNICA-FULL-STACK

BRAYAN DAVID BANGUERA ALEGRIA.

API REST para gestión de notas con Spring Boot  y PostgreSQL.

## Modelo Entidad Relación.


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