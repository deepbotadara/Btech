--1. Display the name and total revenue for each company.
SELECT COMPANY,SUM(REVENUE) AS 'TOTAL_REVENUE'
FROM COMPANY
GROUP BY COMPANY

--2. Generate a report with the production year and the number of games released this year (named count), the --average of production cost for all games produced in this year (named avg_cost) and the average revenue
--for that year (named avg_revenue).
SELECT PRODUCTION_YEAR, COUNT(*) AS 'COUNT',
AVG(PRODUCTION_COST) as 'AVG_COST', avg(revenue) AS 'AVG_REVENUE'
FROM company
group by production_year;

--3. Count how many games of a given type are profitable (i.e. the revenue was greater than the production
--cost). Show the game type and the number of profitable games (named number_of_games) for each type.


--4. Obtain the type of games and the total revenue generated for games with a production_year after 2010 and
--with a PS2 or PS3 system. Order the result so the types with the highest revenue come first.
--5. For all companies present in the table, obtain their names and the sum of gross profit over all years. (Assume
--that gross profit = revenue - cost of production). Name this column gross_profit_sum. Order the results by
--gross profit, in descending order.
--6. Obtain the yearly gross profit of each company. In other words, we want a report with the company name,
--the year, and the gross profit for that year. Order the report by company name and year.
--7. For each company, select its name, the number of games it’s produced (as the number_of_games column),
--and the average cost of production (as the avg_cost column). Show only companies producing more than
--one game.