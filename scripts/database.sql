CREATE TABLE IF NOT EXISTS P_User (
    id SERIAL UNIQUE PRIMARY KEY NOT NULL,
    mail VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS Degree (
    id SERIAL UNIQUE PRIMARY KEY NOT NULL,
    title VARCHAR(60) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS Skill (
    id SERIAL UNIQUE PRIMARY KEY NOT NULL,
    title VARCHAR(60) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS CompanyType (
    id SERIAL UNIQUE PRIMARY KEY NOT NULL,
    title VARCHAR(60) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS JobSeeker (
    id SERIAL UNIQUE NOT NULL,
    firstName VARCHAR(60) NOT NULL,
    lastName VARCHAR(60) NOT NULL,
    gender INT NOT NULL,
    birthDate DATE NOT NULL,
    address TEXT NOT NULL,
    city VARCHAR(50) NOT NULL,
    mobile VARCHAR(30) NOT NULL,
    degreeID INT NOT NULL,
    passYear DATE NOT NULL,
    detail TEXT,
    experience INT NOT NULL,
    userID INT NOT NULL,
    CONSTRAINT fk_degree    
        FOREIGN KEY (degreeID)
            REFERENCES Degree (id)
            ON UPDATE CASCADE,
    CONSTRAINT fk_user
        FOREIGN KEY (userID)
            REFERENCES P_User (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Company (
    id SERIAL UNIQUE NOT NULL,
    companyName VARCHAR(100) NOT NULL,
    address TEXT NOT NULL,
    city VARCHAR(50) NOT NULL,
    contactPersonName VARCHAR(60) NOT NULL,
    contactPersonLastname VARCHAR(60) NOT NULL,
    mobile VARCHAR(30) NOT NULL,
    companyTypeID int NOT NULL,
    detail TEXT,
    userID INT NOT NULL,
    CONSTRAINT fk_company_type    
        FOREIGN KEY (companyTypeID)
            REFERENCES CompanyType (id)
            ON UPDATE CASCADE,
    CONSTRAINT fk_user
        FOREIGN KEY (userID)
            REFERENCES P_User (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Job (
    id SERIAL UNIQUE NOT NULL,
    degreeID INT NOT NULL,
    salary NUMERIC(7,2),
    experience INT,
    detail TEXT NOT NULL,
    deadline DATE NOT NULL,
    creationDate DATE DEFAULT CURRENT_DATE,
    CONSTRAINT fk_degree    
        FOREIGN KEY (degreeID)
            REFERENCES Degree (id)
            ON UPDATE CASCADE,
    PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS JobXSkill (
    jobID INT NOT NULL,
    skillID INT NOT NULL,
    FOREIGN KEY (jobID)
        REFERENCES Job (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
    FOREIGN KEY (skillID) 
        REFERENCES Skill (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS JobSeekerXSkill (
    jobSeekerID INT NOT NULL,
    skillID INT NOT NULL,
    FOREIGN KEY (jobSeekerID)
        REFERENCES JobSeeker (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE,
    FOREIGN KEY (skillID) 
        REFERENCES Skill (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Message (
    id SERIAL UNIQUE NOT NULL,
    subject VARCHAR,
    content TEXT NOT NULL,
    date DATE DEFAULT CURRENT_DATE,
    PRIMARY KEY (id)
);

CREATE  TABLE IF NOT EXISTS JobSeekerMessage(
    from_p INT UNIQUE NOT NULL,
    to_p INT UNIQUE NOT NULL,
    FOREIGN KEY (from_p) REFERENCES JobSeeker (id),
    FOREIGN KEY (to_p) REFERENCES Company (id)
)INHERITS (Message);

CREATE  TABLE IF NOT EXISTS CompanyMessage(
    from_p INT UNIQUE NOT NULL,
    to_p INT UNIQUE NOT NULL,
    FOREIGN KEY (from_p) REFERENCES Company (id),
    FOREIGN KEY (to_p) REFERENCES JobSeeker (id)
)INHERITS (Message);

CREATE  TABLE IF NOT EXISTS CompanyContactUsMessage(
    from_p INT UNIQUE NOT NULL,
    FOREIGN KEY (from_p) REFERENCES Company (id)
)INHERITS (Message);

CREATE  TABLE IF NOT EXISTS JobSeekerContactUsMessage(
    from_p INT UNIQUE NOT NULL,
    FOREIGN KEY (from_p) REFERENCES JobSeeker (id)
)INHERITS (Message);


