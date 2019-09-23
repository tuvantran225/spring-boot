DELIMITER //
DROP PROCEDURE IF EXISTS CreateEmployee//
CREATE PROCEDURE CreateEmployee(pCompany VARCHAR(50), pLastName VARCHAR(50), pFirstName VARCHAR(50), pEmail VARCHAR(50),
pJob VARCHAR(50), pBusinessPhone VARCHAR(25), pHomePhone VARCHAR(25), pMobilePhone VARCHAR(25), pFax VARCHAR(25),
pAddress LONGTEXT, pCity VARCHAR(50), pState VARCHAR(50), pZipCode VARCHAR(15), pCountry VARCHAR(50),
pWebPage LONGTEXT, pNotes LONGTEXT, pAttachments LONGBLOB)
BEGIN
    INSERT INTO employees(company, last_name, first_name, email_address, job_title, business_phone, home_phone, mobile_phone,
    fax_number, address, city, state_province, zip_postal_code, country_region, web_page, notes, attachments)
    VALUES(pCompany, pLastName, pFirstName, pEmail, pJob, pBusinessPhone, pHomePhone, pMobilePhone, pFax, pAddress,
    pCity, pState, pZipCode, pCountry, pWebPage, pNotes, pAttachments);
END//