use movies_db;

#1
#Es un proceso de estandarización para eliminar las redundancias favoreciendo la interpretación, para que
#así sea más simple de consultar y más eficiente.

#2
INSERT INTO `movies_db`.`movies` (`title`, `rating`, `awards`, `release_date`, `length`) VALUES ('El juez', '7.0', '0', '2020-01-01', '130');

#3
INSERT INTO `movies_db`.`genres` (`created_at`, `name`, `ranking`, `active`) VALUES ('2020-01-01', 'Comedia Romantica', '13', '1');

#4
UPDATE `movies_db`.`movies` 
SET 
    `genre_id` = '13'
WHERE
    (`id` = '22');

#5
UPDATE `movies_db`.`actors` 
SET 
    `favorite_movie_id` = '22'
WHERE
    (`id` = '49');

#6
CREATE TEMPORARY TABLE IF NOT EXISTS temp AS (SELECT * FROM movies);

#7
DELETE FROM temp 
WHERE
    awards < 5;
    
#8    
SELECT DISTINCT
    g.*
FROM
    genres g
        INNER JOIN
    movies m ON m.genre_id = g.id;    
    
#9
SELECT 
    a.*
FROM
    actors a
        INNER JOIN
    movies m ON m.id = a.favorite_movie_id
WHERE
    m.awards > 3;
    
#11
#Los indices son un mecanismo para optimizar consultas en SQL, ya que evitan tener que escanear toda la tabla para obtener datos.

#12
ALTER TABLE actors ADD INDEX actor_name(first_name);

#13
SHOW INDEX FROM actors;
