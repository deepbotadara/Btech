--QUERY1: Display the name of students whose name starts with ‘k’.
SELECT FIRSTNAME FROM STUDENT1 WHERE FIRSTNAME LIKE 'K%';

--QUERY2: Display the name of students whose name consists of five characters.
SELECT FIRSTNAME FROM STUDENT1 WHERE FIRSTNAME LIKE '_____';

--QUERY3: Retrieve the first name & last name of students whose city name ends with a & contains six characters.
SELECT FIRSTNAME,LASTNAME FROM Student1 WHERE CITY LIKE '%A' AND CITY LIKE '______';

--QUERY4: Display all the students whose last name ends with ‘tel’.
SELECT FIRSTNAME FROM STUDENT1 WHERE LASTNAME LIKE '%TEL';

--QUERY5: Display all the students whose first name starts with ‘ha’ & ends with‘t’.
SELECT FIRSTNAME FROM Student1 WHERE FIRSTNAME LIKE 'HA%' AND FIRSTNAME LIKE '%T';

--QUERY6: Display all the students whose first name starts with ‘k’ and third character is ‘y’.
SELECT FIRSTNAME FROM Student1 WHERE FIRSTNAME LIKE 'K%' AND FIRSTNAME LIKE '__Y%';

--7. Display the name of students having no website and name consists of five characters.
SELECT FIRSTNAME FROM Student1 WHERE WEBSITE IS NULL AND FIRSTNAME LIKE '_____';

--8. Display all the students whose last name consist of ‘jer’.
SELECT FIRSTNAME FROM Student1 WHERE LASTNAME LIKE '%JER%';

--9. Display all the students whose city name starts with either ‘r’ or ‘b’.
SELECT FIRSTNAME FROM Student1 WHERE CITY LIKE 'B%' OR CITY LIKE 'R%';

--10. Display all the name students having websites.
SELECT FIRSTNAME FROM Student1 WHERE WEBSITE LIKE '%';

--11. Display all the students whose name starts from alphabet A to H.
SELECT FIRSTNAME FROM Student1 WHERE FIRSTNAME LIKE '[A-H]%';

--12. Display all the students whose name’s second character is vowel.
SELECT FIRSTNAME FROM Student1 WHERE FIRSTNAME LIKE '_[A,E,I,O,U]%';

--13. Display student’s name whose city name consist of ‘rod’.
SELECT FIRSTNAME FROM Student1 WHERE CITY LIKE '%ROD%';

--14. Retrieve the First & Last Name of students whose website name starts with ‘bi’.
SELECT FIRSTNAME FROM Student1 WHERE WEBSITE LIKE 'BI%';

--15. Display student’s city whose last name consists of six characters.
SELECT FIRSTNAME FROM Student1 WHERE LASTNAME LIKE '______';

--16. Display all the students whose city name consist of five characters & not starts with ‘ba’.
SELECT FIRSTNAME FROM Student1 WHERE CITY LIKE '_____' AND CITY NOT LIKE 'BA%';

--17. Show all the student’s whose division starts with ‘II’.
SELECT FIRSTNAME FROM Student1 WHERE DIVISION LIKE 'II%';

--18. Find out student’s first name whose division contains ‘bc’ anywhere in division name.
SELECT FIRSTNAME FROM Student1 WHERE DIVISION LIKE '%BC%';

--19. Show student id and city name in which division consist of six characters and having website name.
SELECT STUID,CITY FROM Student1 WHERE DIVISION LIKE '______' AND WEBSITE LIKE '%';

--20. Display all the students whose name’s third character is consonant.
SELECT FIRSTNAME FROM Student1 WHERE FIRSTNAME NOT LIKE '__[A,E,I,O,U]%';
