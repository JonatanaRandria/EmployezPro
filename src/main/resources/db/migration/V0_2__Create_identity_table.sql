CREATE TABLE card (
                                id SERIAL PRIMARY KEY,
                                cin_number VARCHAR(255) NOT NULL,
                                cin_issue_date DATE NOT NULL,
                                cin_issue_place VARCHAR(255) NOT NULL
);
