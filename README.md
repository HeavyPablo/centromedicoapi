# centromedicoapi
API para aplicacion centro medico de Dos Alamos.
Aplicar esto en POSTMAN.

## Comuna
**URL BASE: ``http://localhost:8080/comuna``**

### Crear
- **URL: ``http://localhost:8080/comuna``**
- **METHOD: ``POST``**

Para crear una COMUNA se debe enviar un json con lo siguiente:
```
{
  "nombre": "NOMBRE_COMUNA"
}
```
>Reemplazar:
>- ``NOMBRE_COMUNA`` por el nombre de la comuna.

### Obtener todo
- **URL: ``http://localhost:8080/comuna``**
- **METHOD: ``GET``**

### Obtener por ID
- **URL: ``http://localhost:8080/comuna/{id}``**
- **METHOD: ``GET``**

>Reemplazar:
>- ``{id}`` por el ID de la comuna.

## Rol
**URL BASE: ``http://localhost:8080/rol``**

### Crear
- **URL: ``http://localhost:8080/rol``**
- **METHOD: ``POST``**

Para crear un ROL se debe enviar un json con lo siguiente:
```
{
  "nombre": "NOMBRE_ROL"
}
```

>Reemplazar:
>- ``NOMBRE_ROL`` por el nombre del rol(ej: Secretaria, Paciente o Medico).

### Obtener todo
- **URL: ``http://localhost:8080/rol``**
- **METHOD: ``GET``**

### Obtener por ID
- **URL: ``http://localhost:8080/rol/{id}``**
- **METHOD: ``GET``**

>Reemplazar: 
> - ``{id}`` por el ID del rol.

## Sucursal
URL BASE: ``http://localhost:8080/sucursal``

### Crear
- **URL: ``http://localhost:8080/sucursal``**
- **METHOD: ``POST``**

Para crear una SUCURSAL se debe enviar un json con lo siguiente:
```
{
  "nombre": "NOMBRE_SUCURSAL",
  "direccion": "DIRECCION_SUCURSAL",
  "comuna": "ID_COMUNA"
}
```
>Reemplazar: 
> - ``NOMBRE_SUCURSAL`` por el nombre de la sucursal.
> - ``DIRECCION_SUCURSAL`` por la direccion de la sucursal.
> - ``ID_COMUNA`` por el id de la comuna donde se ubica esta sucursal.

### Obtener todo
- **URL: ``http://localhost:8080/sucursal``**
- **METHOD: ``GET``**

### Obtener por ID
- **URL: ``http://localhost:8080/sucursal/{id}``**
- **METHOD: ``GET``**

>Reemplazar:
>- ``{id}`` por el ID de la sucursal.
