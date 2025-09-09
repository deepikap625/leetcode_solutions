# Write your MySQL query statement below
select tweet_id from Tweets where char_length(content) > 15 OR content regexp '[^a-zA-Z0-9! ]';