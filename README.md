# ApiConcesionario

Aplicacion que gestiona un setock de coche de un concesionario.

## Lanzamiento

Para lanzar la aplicación se debe ejecutar el comando spring-boo:run

## Endpoints

Todos los endpoints se encuentran en http://localhost:8080/api

- POST http://localhost:8080/api/add Añade un coche a la base de datos. Ejemplo de un POST con JSON:

  ```
  {
    "bastidor": "4343ljklj",
    "marca": "mercedes",
    "modelo": "benz",
    "kms": 20,
    "propulsion": "gasolina",
    "fechaVendido": "2021-10-12",
    "fechaCreacion": "2021-09-12",
    "precioVenta": 23000,
    "vendedor": "pablo"

  }
  ``` 
- GET http://localhost:8080/api/coches/{id} Muestra el coche con el id escogido.
- GET http://localhost:8080/api/coches Muestra la lista de coches de la base de datos.
- GET http://localhost:8080/api/nominas Muestra el nombre de los vendedores y la suma del prrecio de los coches que han vendido.
- DELETE http://localhost:8080/api/coches/{id} Elimina el coche que coincida con el id escogido.

**Los datos en base de datos se eliminan una vez se cierra la aplicación.**
