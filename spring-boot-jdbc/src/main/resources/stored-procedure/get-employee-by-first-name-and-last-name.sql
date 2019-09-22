DELIMITER //
DROP PROCEDURE IF EXISTS GetEmployeeByFirstNameAndLastName//
CREATE PROCEDURE GetEmployeeByFirstNameAndLastName(pFirstName VARCHAR(50), pLastName VARCHAR(50))
BEGIN
    SELECT * FROM employees WHERE first_name = pFirstName AND last_name = pLastName;
END//