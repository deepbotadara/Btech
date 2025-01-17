--1. Write a SQL query to calculate total purchase amount of all orders. Return total purchase amount.
Select Ord_no,sum(purch_amt) as "Sum of Purchased amt"
From orders 
Group by ord_no

--2. Write a SQL query to calculate the average purchase amount of all orders. Return average purchase amount.
Select ord_no,avg(purch_amt) 
From orders
Group by ord_no

--3. Write a SQL query that counts the number of unique salespeople. Return number of salespeople.
Select count(distinct salesman_id)
From orders

--4. Write a SQL query to count the number of customers. Return number of customers.
Select count(distinct customer_id)
From orders

--5. Write a SQL query to determine the number of customers who received at least one grade for their activity.
Select count(cust_name)
From customers
Where grade>=1

--6. Write a SQL query to find the maximum purchase amount.
Select max(purch_amt) 
From orders

--7. Write a SQL query to find the minimum purchase amount.
Select min(purch_amt) 
From orders

--8. Write a SQL query to find the highest grade of the customers in each city. Return city, maximum grade.
Select city,max(grade)
From customers
Group by city

--9. Write a SQL query to find the highest purchase amount ordered by each customer. Return customer ID,
--maximum purchase amount.
Select customer_id,max(purch_amt)
From orders
Group by customer_id

--10. Write a SQL query to find the highest purchase amount ordered by each customer on a particular date.
--Return, order date and highest purchase amount.
Select ord_date,max(purch_amt)
From orders
Group by ord_date
