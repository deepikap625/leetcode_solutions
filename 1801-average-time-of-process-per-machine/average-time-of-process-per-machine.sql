# Write your MySQL query statement below
select a.machine_id, round(avg(a.timestamp-b.timestamp),3) as processing_time from Activity a JOIN Activity b 
ON a.machine_id = b.machine_id
AND a.process_id = b.process_id
where b.activity_type = 'start'
AND a.activity_type ='end'
group by a.machine_id;
