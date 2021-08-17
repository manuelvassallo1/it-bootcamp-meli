# Tucasita API

La empresa “TuCasita Tasaciones” necesita poder calcular los metros cuadrados y el costo de distintas propiedades con
las que cuenta en su cartera de clientes. Para ello, solicita por cada propiedad: un nombre, un barrio y la cantidad de
ambientes que posee; al mismo tiempo, cada ambiente contiene un nombre, un ancho y un largo.

## Testing

Hay disponibles dos opciones:

1. Documentacion con pruebas dinamicas en swagger.
2. Collection para Postman.

## Swagger

Para acceder a la documentacion en swagger, una vez iniciada la app se debe ingresar
a: [Doc Swagger](http://localhost:8080/swagger-ui.html)

Alli se podran testear cada uno de los endpoints de la API. Ademas, se pueden ver cómo estan estructurados los distintos
DTO's desde la seccion "Schemas".

## Postman

En la carpeta Resources del proyecto se encuentra la collection de Postman con las respectivas carpetas y url's de cada
ejercicio. La misma figura con el siguiente nombre:

```bash
TuCasita.postman_collection.json
```

## Nota:

Se ha cambiado la nomenclatura de algunos atributos para respetar la escritura CamelCase. Un ejemplo de JSON correcto es
el siguiente:

```bash
{
    "propName": "Casa",
    "propLandWidth": 50.00,
    "propLandLength": 50.00,
    "district": {
        "districtName": "Puerto Madero",
        "districtBuiltPrice": 2.00,
        "districtUnbuiltPrice": 1.00
    },
    "rooms": [
        {
            "roomName": "Habitacion",
            "roomWidth": 10.00,
            "roomLength": 5.00
        },
        {
            "roomName": "Cocina",
            "roomWidth": 10.00,
            "roomLength": 10.00
        }
    ]
}
```

## Nota 2:

Como Repositorio se uso un JSON como lista de Barrios(Districts) validos. Esta lista es usada para validar que el barrio
que se haya enviado por request este incluido en esa lista. La misma figura con el siguiente nombre en la carpeta
Resources:

```bash
districts.json
```

## Nueva funcionalidad:

```bash
localhost:8080/districts 
```

Se agrego una nueva funcionalidad para obtener todos los barrios disponibles en el repositorio.

## Ejercicios

Se plantea el requerimiento de la creación de una API Rest que permita:

1. ✔ <ins>US-0001</ins>: Calcular el total de metros cuadrados de una propiedad
2. ✔ <ins>US-0002</ins>: Indicar el valor de una propiedad a partir de sus ambientes y medidas. Tener en cuenta que los
   precios por metro cuadrado están determinados según el barrio.
3. ✔ <ins>US-0003</ins>: Determinar cuál es el ambiente más grande.
4. ✔ <ins>US-0004</ins>: Determinar la cantidad de metros cuadrados que tiene cada ambiente de una propiedad.

#### Hecho por: Manuel Vassallo