# Write your MySQL query statement below
select round(
    count(distinct a.player_id)/
    (select count(distinct player_id) from activity)
    ,2)AS fraction
from activity a
JOIN(
    Select player_id, min(event_date) AS first_login 
    From Activity 
    group by player_id) b
ON b.player_id = a.player_id
AND a.event_date = date_add(b.first_login, interval 1 day);

