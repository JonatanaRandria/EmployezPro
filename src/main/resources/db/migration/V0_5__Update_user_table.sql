ALTER TABLE phone_numbers
    ADD CONSTRAINT fk_employee
        FOREIGN KEY (employee_id) REFERENCES employee (id);

