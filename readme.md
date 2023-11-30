# Gestion Veterinaria

Acordarse configurar la base de datos en application.properties

### Endpoints perro:

- **Obtener todos**
  - Método: GET
  - Url: `http://localhost:8080/perros`


- **Obtener por id**
    - Método: GET
    - Url: `http://localhost:8080/perros/{id}`
  

- **Crear**
    - Método: POST
    - Url: `http://localhost:8080/perros`


- **Editar por id**
    - Método: PUT
    - Url: `http://localhost:8080/perros/{id}`


- **Eliminar por id**
    - Método: DELETE
    - Url: `http://localhost:8080/perros/{id}`


### Endpoints gato: `lo mismo que con perros pero reemplazarlo por gatos`


### Endpoints médico: `lo mismo pero reemplazarlo por medicos`


### Endpoints Turnos:

- **Obtener todos**
    - Método: GET
    - Url: `http://localhost:8080/turnos`


- **Obtener todos por idMedico**
    - Método: GET
    - Url: `http://localhost:8080/turnos/medico/{idMedico}`


- **Obtener por id**
    - Método: GET
    - Url: `http://localhost:8080/turnos/{id}`



- **Crear**
    - Método: POST
    - Url: `http://localhost:8080/turnos/{idMedico}`


- **Gestionar turno**
    - Método: PUT
    - Url: `http://localhost:8080/turnos/{animal}/{idMedico}/{idTurno}`
    - **Aclaración: animal debe ser un string que diga perro o gato**
    - **PD: el proceso de ejecución se puede ver en la consola de salida**
  


- **Eliminar por id**
    - Método: DELETE
    - Url: `http://localhost:8080/turnos/{id}`