USE movies_db;
#1
SELECT 
    s.title, g.name
FROM
    series s
        INNER JOIN
    genres g ON g.id = s.genre_id;
    
#2
SELECT 
    e.title, a.first_name, a.last_name
FROM
    episodes e
        INNER JOIN
    actor_episode ae ON e.id = ae.episode_id
        INNER JOIN
    actors a ON a.id = ae.actor_id;
    
#3
SELECT 
    s.title, COUNT(*) AS SeasonQuantity
FROM
    series s
        INNER JOIN
    seasons sea ON sea.serie_id = s.id
GROUP BY s.title;

#4
SELECT 
    g.name, COUNT(*) AS MoviesQuantity
FROM
    genres g
        INNER JOIN
    movies m ON m.genre_id = g.id
GROUP BY g.name
HAVING MoviesQuantity >= 3;

#5
SELECT DISTINCT
    a.first_name, a.last_name
FROM
    actors a
        INNER JOIN
    actor_movie am ON am.actor_id = a.id
        INNER JOIN
    movies m ON m.id = am.movie_id
WHERE
    m.title LIKE '%la guerra de las galaxias%'
GROUP BY a.first_name , a.last_name
HAVING COUNT(a.id) = (SELECT 
        COUNT(id)
    FROM
        movies
    WHERE
        title LIKE '%la guerra de las galaxias%');