# Write your MySQL query statement below
select date_format(trans_date, '%Y-%m') AS month, 
country, 
count(*) as trans_count, 
sum(CASE when state = 'approved' then 1 else 0 end) as approved_count, 
sum(amount) AS trans_total_amount, 
sum(CASE when state ='approved' then amount else 0 end) AS approved_total_amount
from  transactions
group by month,country
order by month,country;