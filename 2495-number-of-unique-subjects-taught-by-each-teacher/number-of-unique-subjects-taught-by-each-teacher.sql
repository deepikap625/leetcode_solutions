# Write your MySQL query statement below
select distinct(teacher_id), count(distinct(subject_id))  AS cnt
from Teacher 
group by teacher_id;