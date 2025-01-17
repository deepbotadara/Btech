--1. Display the Highest, Lowest, Total, and Average salary of all employees. Label the columns Maximum,
--Minimum, Total_Sal and Average_Sal, respectively.
--select * from employee;
SELECT MAX(SALARY) as 'maximum' , MIN(SALARY) as 'Minimum', sum(SALARY) as 'total', AVG(SALARY) as 'avg'  
FROM EMPLOYEE 
GROUP BY EID;

--2. Find total number of employees of EMPLOYEE table.
select count(eid) as 'total_employees' 
from EMPLOYEE

--3. Give maximum salary from IT department.
select max(salary) as 'maximum' 
from EMPLOYEE 
where DEPARTMENT='IT';

--4. Count total number of cities of employee without duplication.
SELECT COUNT(DISTINCT CITY) as 'Total_Cities'
FROM EMPLOYEE

--5. Display city with the total number of employees belonging to each city.
SELECT city, count(eid) as 'total_employees' 
FROM EMPLOYEE 
GROUP BY city

--6. Display city having more than one employee.
SELECT city, COUNT(EID) AS 'TOTAL_EMPLOYEES'
FROM EMPLOYEE
GROUP BY CITY
HAVING COUNT(EID)>1

--7. Give total salary of each department of EMPLOYEE table.
SELECT DEPARTMENT,SUM(SALARY) AS 'TOTAL_SALARY'
FROM EMPLOYEE
GROUP BY DEPARTMENT

--8. Give average salary of each department of EMPLOYEE table without displaying the respective department
--name.
SELECT avg(SALARY) AS 'AVG_SALARY'
FROM EMPLOYEE
GROUP BY DEPARTMENT

--9. Give minimum salary of employee who belongs to Ahmedabad.
Select min(salary) as 'MINIMUM'
FROM EMPLOYEE
where city ='ahmedabad'

--10. List the departments having total salaries more than 50000 and located in city Rajkot.
SELECT department
FROM EMPLOYEE
WHERE SALARY>50000 AND CITY='RAJKOT'

--11. Count the number of employees living in Rajkot.
SELECT COUNT(EID) AS 'TOTAL_EMPLOYEES'
FROM EMPLOYEE
WHERE CITY='RAJKOT'

--12. Display the difference between the highest and lowest salaries. Label the column DIFFERENCE.
SELECT MAX(SALARY) - MIN(SALARY) AS 'DIFFERENCE'
FROM EMPLOYEE

--13. Display the total number of employees hired before 1st January, 1991.
SELECT COUNT(EID) 
FROM EMPLOYEE
WHERE JOININGDATE>'01-DEC-91'

--14. Display total salary of each department with total salary exceeding 35000 and sort the list by total salary.
SELECT DEPARTMENT,SUM(SALARY) AS 'SALARY'
FROM EMPLOYEE
GROUP BY DEPARTMENT
HAVING SUM(SALARY)>35000
ORDER BY SUM(SALARY)

--15. List out department names in which more than two employees.
SELECT DEPARTMENT,COUNT(EID)
FROM EMPLOYEE
GROUP BY DEPARTMENT
HAVING COUNT(EID)>2

