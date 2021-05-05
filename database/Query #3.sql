SELECT f.ORIGIN_AIRPORT_ID AS origine, f.DESTINATION_AIRPORT_ID AS destinazione, COUNT(*) AS tot,AVG(distance) AS media
FROM flights f
GROUP BY origine, destinazione
HAVING AVG(distance) > 3500
