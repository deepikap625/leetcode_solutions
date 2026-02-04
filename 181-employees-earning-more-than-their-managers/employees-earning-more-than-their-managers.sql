# Write your MySQL query statement below
select e.name as employee from employee e 
join employee m where e.managerid = m.id
and e.salary > m.salary