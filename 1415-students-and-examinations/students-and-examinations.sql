# Write your MySQL query statement below
select s.student_id, s.student_name, a.subject_name, count(e.subject_name) As attended_exams from students s cross join subjects a
left join examinations e 
on s.student_id = e.student_id
and a.subject_name = e.subject_name
group by s.student_id,s.student_name, a.subject_name
order by student_id;