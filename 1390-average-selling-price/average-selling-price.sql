# Write your MySQL query statement below
select p.product_id, round(ifnull(sum(u.units*p.price)/sum(u.units),0),2) AS average_price 
from prices p
Left join UnitsSold u
ON p.product_id = u.product_id
AND u.purchase_date between p.start_date and p.end_date
GROUP by p.product_id;