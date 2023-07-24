CREATE TABLE phone_numbers (
                               id SERIAL PRIMARY KEY,
                               phone_number VARCHAR(255) NOT NULL,
                               employee_id BIGINT
);
