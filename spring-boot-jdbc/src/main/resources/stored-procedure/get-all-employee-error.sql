DELIMITER //
DROP PROCEDURE IF EXISTS GetAllEmployeeError//
CREATE PROCEDURE GetAllEmployeeError()
BEGIN
    SELECT abc FROM employees;
END//