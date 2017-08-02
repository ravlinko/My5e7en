INSERT INTO COMPANY (id, name, address, email) VALUES (1, 'Green Garden inc.', 'NYC', 'info@greengarden.com');
INSERT INTO COMPANY (id, name, address, email) VALUES (2, 'Red Dragon inc.', 'NYC', 'info@reddragon.com');
INSERT INTO COMPANY (id, name, address, email) VALUES (3, 'Chery Street inc.', 'NYC', 'info@cherystreet.com');

--password www
INSERT INTO USER (id, company_id, first_name, last_name, phone, email, password, role) VALUES (1, 1, 'Admin', 'Admin', '099 999 00 00', 'admin', '$2a$10$IyIUBSrSbLHx2C1K4G3QsOf74DK2OPZhFzoIvI61H/qtgRj58887.', 'ADMIN');
INSERT INTO USER (id, company_id, first_name, last_name, phone, email, password, role) VALUES (2, 1, 'Jenny', 'Kelly', '099 999 01 01', 'jkelly@solidcircle.com', '$2a$10$IyIUBSrSbLHx2C1K4G3QsOf74DK2OPZhFzoIvI61H/qtgRj58887.', 'ADMIN');

INSERT INTO USER (company_id, first_name, last_name, phone, email, password, role) VALUES (1, 'Frank', 'Frankly', '001', 'demo@localhost', '$2a$10$IyIUBSrSbLHx2C1K4G3QsOf74DK2OPZhFzoIvI61H/qtgRj58887.', 'ADMIN');
INSERT INTO USER (company_id, first_name, last_name, phone, email, password, role) VALUES (2, 'John', 'Worker', '002', 'john@localhost', '$2a$10$IyIUBSrSbLHx2C1K4G3QsOf74DK2OPZhFzoIvI61H/qtgRj58887.', 'COMPANY_OWNER');
INSERT INTO USER (company_id, first_name, last_name, phone, email, password, role) VALUES (1, 'Jekky', 'Jones', '003', 'jones@localhost', '$2a$10$IyIUBSrSbLHx2C1K4G3QsOf74DK2OPZhFzoIvI61H/qtgRj58887.', 'COMPANY_OWNER');
INSERT INTO USER (company_id, first_name, last_name, phone, email, password, role) VALUES (1, 'Peter', 'Tailor', '004', 'peter@localhost', '$2a$10$IyIUBSrSbLHx2C1K4G3QsOf74DK2OPZhFzoIvI61H/qtgRj58887.', 'COMPANY_EMPLOYER');
INSERT INTO USER (company_id, first_name, last_name, phone, email, password, role) VALUES (1, 'Jessica', 'Morningston', '005', 'jessica@localhost', '$2a$10$IyIUBSrSbLHx2C1K4G3QsOf74DK2OPZhFzoIvI61H/qtgRj58887.', 'COMPANY_EMPLOYER');
INSERT INTO USER (company_id, first_name, last_name, phone, email, password, role) VALUES (1, 'Mike', 'Parker', '006', 'mike@localhost', '$2a$10$IyIUBSrSbLHx2C1K4G3QsOf74DK2OPZhFzoIvI61H/qtgRj58887.', 'COMPANY_EMPLOYER');


-- bdd reports
INSERT INTO REPORT (user_id, company_id, name, data) VALUES (2, 2, 'Green Garden inc. 2017 May month report', 'Green Garden inc. 2017 May month report');
INSERT INTO REPORT (user_id, company_id, name, data) VALUES (2, 2, 'Red Dragon inc. 2017 May month report', 'Red Dragon inc. 2017 May month report Data');
INSERT INTO REPORT (user_id, company_id, name, data) VALUES (2, 2, 'Chery Street inc. 2017 May month report', 'Chery Street inc. 2017 May month report Data');
