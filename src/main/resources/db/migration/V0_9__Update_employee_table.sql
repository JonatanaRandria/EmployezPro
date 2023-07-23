-- Drop the existing columns for personal and work emails
ALTER TABLE employee ADD COLUMN personal_email VARCHAR(255);
ALTER TABLE employee ADD COLUMN work_email VARCHAR(255);


