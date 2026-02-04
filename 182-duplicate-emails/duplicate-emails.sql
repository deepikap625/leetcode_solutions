# Write your MySQL query statement below
select distinct p.email AS Email from person p join person e
on p.email = e.email where p.id != e.id