ALTER TABLE users
    MODIFY emailaddress VARCHAR(255) NOT NULL;
ALTER TABLE users
    ADD CONSTRAINT UC_Email UNIQUE (emailaddress);