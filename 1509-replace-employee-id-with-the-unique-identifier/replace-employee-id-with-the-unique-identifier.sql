# Write your MySQL query statement below
select a.unique_id, b.name from Employees b Left join EmployeeUNI a On a.id = b.id;