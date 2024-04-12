
# Proyecto de registro de Usuarios




# Requsitos de Instalación

Tener instalado java 17, gradle, git




## API Reference

#### Guardar Persona

```http
  POST /api/person
```
Parametro que recibe:
```
{
    "name": "juan",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
        "number": "1234567",
        "citycode": "1",
        "contrycode": "57"
        },
        {
        "number": "12345677",
        "citycode": "11",
        "contrycode": "577"
        }
    ]
}
```
respuesta:

```
{
    "id": "ebd071c5-acba-42f4-99af-9a1ecbe9cd3b",
    "created": "2024-04-12",
    "modified": null,
    "lastLogin": "2024-04-12",
    "isactive": 1,
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuQHJvZHJpZ3Vlei5vcmciLCJpYXQiOjE3MTI5NTExMjIsImV4cCI6MTcxMjk1NDcyMn0.GZQMw1DuVuyWLCNskHRSCnVz1zqjt_ki7nofLzZNFzw"
}
```
## Ejecutar Localmente

Clonar el projecto

```bash
  git clone https://github.com/yelsin62/bciprueba.git
```

Ir al directorio del projecto

```bash
  cd bciprueba
```

Abrir con cualquier editor IntelliJ IDEA u otro editor y ejecutar

