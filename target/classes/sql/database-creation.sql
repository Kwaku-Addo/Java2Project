CREATE TABLE IF NOT EXISTS person (
    idperson INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 
    lastname VARCHAR(45) NOT NULL,  
    firstname VARCHAR(45) NOT NULL,
    nickname VARCHAR(45) NOT NULL,
    phone_number VARCHAR(15) NULL,
    street VARCHAR(200) NULL,
    apartment VARCHAR(200) NULL,
    postal_code INTEGER(5) NULL,
    city VARCHAR(200) NULL,
    email_address VARCHAR(150) NULL,
    birth_date DATE NULL);