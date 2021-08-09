# SocialMeli API

SocialMeli es una plataforma de MercadoLibre para establecer una relación entre vendedores y usuarios.

## Testing

Hay disponibles dos opciones:

1. Documentacion con pruebas dinamicas en swagger.
2. Collection para Postman.

## Swagger

Para acceder a la documentacion en swagger, una vez iniciada la app se debe ingresar
a: [Doc Swagger](http://localhost:8080/swagger-ui.html)

Alli se podran testear cada uno de los endpoints referidos a operaciones de User y Post por separado. Ademas, se pueden
ver cómo estan estructurados los distintos DTO's desde la seccion "Schemas".

## Postman

En la carpeta Resources del proyecto se encuentra la collection de Postman con las respectivas carpetas y url's de cada
ejercicio. La misma figura con el siguiente nombre:

```bash
SocialMeli.postman_collection.json
```

## Nota:

En los requerimientos tecnicos se especifica en el punto 6 un .json con formato erróneo, donde se ven alguna "," de mas
y las '"' no son las correctas. Por lo mismo se procedio a editar el .json de request de manera correcta:

```bash
{
    "userId": 4,
    "id_post": 1,
    "date": "01-08-2021",
    "detail": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
}
```

## Ejercicios

Se plantea el requerimiento de la creación de una API Rest que permita:

1. Poder realizar la acción de “Follow” (seguir) a un determinado vendedor

2. Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

3. Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

4. Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

5. Dar de alta una nueva publicación.

6. Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos
   semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).

7. Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.

Por otra parte, dado que se pretende una buena experiencia de usuario con respecto a la forma de presentación de los
resultados de cada consulta, se necesita que los mismos puedan ser ordenados mediante cualquiera de los siguientes
criterios:

8. Alfabético Ascendente y Descendente
9. Fecha Ascendente y Descendente

Un analista funcional llevó a cabo el relevamiento de los requerimientos técnicos funcionales y ha proporcionado la
documentación que se cita a continuación para tener en cuenta a la hora de llevar a cabo el desarrollo correspondiente:

[Requerimientos Tecnicos](https://drive.google.com/file/d/1iPdb8VVgxi4SZtWNqwHo_lo-quODgi3i/view?usp=sharing)

## Bonus

SocialMeli además permitirá a los vendedores poder publicar nuevos productos con ofertas o descuentos especiales
exclusivos para sus seguidores por un determinado período de tiempo. Para ello propone los siguientes requerimientos:

10. Llevar a cabo la publicación de un nuevo producto en promoción.
11. Obtener la cantidad de productos en promoción de un determinado vendedor
12. Obtener un listado de todos los productos en promoción de un determinado vendedor

Tener en cuenta para estos requerimientos la posibilidad de poder ordenarlos alfabéticamente por nombre de cada producto
tanto de forma ascendente como descendente.

#### Hecho por: Manuel Vassallo