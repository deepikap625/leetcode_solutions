# Write your MySQL query statement below
select p.project_id, round(ifnull(sum(e.experience_years)/count(p.project_id),0),2) AS average_years from Project p
LEft join Employee e
on p.employee_id = e.employee_id
group by p.project_id