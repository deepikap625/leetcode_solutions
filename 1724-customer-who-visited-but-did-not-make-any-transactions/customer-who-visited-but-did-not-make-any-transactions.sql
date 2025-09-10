# Write your MySQL query statement below
select v.customer_id, count(*) count_no_trans from visits v 
left join transactions t on v.visit_id = t.visit_id 
where t.visit_id IS NULL
GROUP BY v.customer_id; 