DELIMITER //
DROP PROCEDURE IF EXISTS GetEmployeeByFilter//
CREATE PROCEDURE GetEmployeeByFilter(pCompany VARCHAR(50), pLastName VARCHAR(50), pFirstName VARCHAR(50),
    pEmail VARCHAR(50), pJob VARCHAR(50), pBusinessPhone VARCHAR(25), pHomePhone VARCHAR(25), pMobilePhone VARCHAR(25),
    pFax VARCHAR(25), pAddress LONGTEXT, pCity VARCHAR(50), pState VARCHAR(50), pZipCode VARCHAR(15), pCountry VARCHAR(50),
    pWebPage LONGTEXT, pNotes LONGTEXT, pAttachments LONGBLOB)
BEGIN
    SET @sql = CONCAT("
        SELECT * FROM employees WHERE 1 = 1
    ");
    IF pCompany IS NOT NULL AND pCompany != "" THEN
        SET @sql = CONCAT(@sql, " AND company = '", pCompany, "'");
    END IF;
    IF pLastName IS NOT NULL AND pLastName != "" THEN
        SET @sql = CONCAT(@sql, " AND last_name = '", pLastName, "'");
    END IF;
    IF pFirstName IS NOT NULL AND pFirstName != "" THEN
        SET @sql = CONCAT(@sql, " AND first_name = '", pFirstName, "'");
    END IF;
    IF pEmail IS NOT NULL AND pEmail != "" THEN
        SET @sql = CONCAT(@sql, " AND email_address = '", pEmail, "'");
    END IF;
    IF pJob IS NOT NULL AND pJob != "" THEN
        SET @sql = CONCAT(@sql, " AND job_title = '", pJob, "'");
    END IF;
    IF pBusinessPhone IS NOT NULL AND pBusinessPhone != "" THEN
        SET @sql = CONCAT(@sql, " AND business_phone = '", pBusinessPhone, "'");
    END IF;
    IF pHomePhone IS NOT NULL AND pHomePhone != "" THEN
        SET @sql = CONCAT(@sql, " AND home_phone = '", pHomePhone, "'");
    END IF;
    IF pMobilePhone IS NOT NULL AND pMobilePhone != "" THEN
        SET @sql = CONCAT(@sql, " AND mobile_phone = '", pMobilePhone, "'");
    END IF;
    IF pFax IS NOT NULL AND pFax != "" THEN
        SET @sql = CONCAT(@sql, " AND fax_number = '", pFax, "'");
    END IF;
    IF pAddress IS NOT NULL AND pAddress != "" THEN
        SET @sql = CONCAT(@sql, " AND address = '", pAddress, "'");
    END IF;
    IF pCity IS NOT NULL AND pCity != "" THEN
        SET @sql = CONCAT(@sql, " AND city = '", pCity, "'");
    END IF;
    IF pState IS NOT NULL AND pState != "" THEN
        SET @sql = CONCAT(@sql, " AND state_province = '", pState, "'");
    END IF;
    IF pZipCode IS NOT NULL AND pZipCode != "" THEN
        SET @sql = CONCAT(@sql, " AND zip_postal_code = '", pZipCode, "'");
    END IF;
    IF pCountry IS NOT NULL AND pCountry != "" THEN
        SET @sql = CONCAT(@sql, " AND country_region = '", pCountry, "'");
    END IF;
    IF pWebPage IS NOT NULL AND pWebPage != "" THEN
        SET @sql = CONCAT(@sql, " AND web_page = '", pWebPage, "'");
    END IF;
    IF pNotes IS NOT NULL AND pNotes != "" THEN
        SET @sql = CONCAT(@sql, " AND notes = '", pNotes, "'");
    END IF;
    IF pAttachments IS NOT NULL AND pAttachments != "" THEN
        SET @sql = CONCAT(@sql, " AND attachments = '", pAttachments, "'");
    END IF;

    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END//