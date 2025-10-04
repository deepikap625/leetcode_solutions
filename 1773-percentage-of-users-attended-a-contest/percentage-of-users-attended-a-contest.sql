# Write your MySQL query statement below
select r.contest_id, round(ifnull(count(distinct r.user_id)*100.0/(select count(*) from users),0),2) As percentage 
from Register r
left join Users u
On r.user_id = u.user_id
group by r.contest_id
order by percentage desc, r.contest_id asc;