# Write your MySQL query statement below
select s.user_id, round(ifnull(sum(c.action = 'confirmed')/count(c.action),0),2) AS confirmation_rate From signups s
left join confirmations c 
ON s.user_id = c.user_id
Group by user_id;