INSERT INTO COMPANY (id, name, address, email) VALUES (1, 'Big Chery', 'NYC', 'big.apple@localhost');
INSERT INTO COMPANY (id, name, address, email) VALUES (2, 'Big Apple', 'NYC', 'big.apple@localhost');


INSERT INTO USER (id, company_id, first_name, last_name, phone, email, password, role) VALUES (1, 1, 'Frank', 'Frankly', '001', 'demo@localhost', '$2a$10$OHcKJxX3i1E.hb0GqfIZUeAIySVWqb9t3rFgTu2koC5Fzx1wI6FlW', 'ADMIN');
INSERT INTO USER (id, company_id, first_name, last_name, phone, email, password, role) VALUES (2, 2, 'John', 'Worker', '002', 'john@localhost', '$2a$10$asrKNFf/xXs5PQRkzLiKLujxVLEPtYIXRbQ4lYomxQRHqe0yl9gXa', 'COMPANY_OWNER');
INSERT INTO USER (id, company_id, first_name, last_name, phone, email, password, role) VALUES (3, 1, 'Jekky', 'Jones', '003', 'jones@localhost', '$2a$10$OHcKJxX3i1E.hb0GqfIZUeAIySVWqb9t3rFgTu2koC5Fzx1wI6FlW', 'COMPANY_OWNER');
INSERT INTO USER (id, company_id, first_name, last_name, phone, email, password, role) VALUES (4, 1, 'Peter', 'Tailor', '004', 'peter@localhost', '$2a$10$asrKNFf/xXs5PQRkzLiKLujxVLEPtYIXRbQ4lYomxQRHqe0yl9gXa', 'COMPANY_EMPLOYER');
INSERT INTO USER (id, company_id, first_name, last_name, phone, email, password, role) VALUES (5, 1, 'Jessica', 'Morningston', '005', 'jessica@localhost', '$2a$10$OHcKJxX3i1E.hb0GqfIZUeAIySVWqb9t3rFgTu2koC5Fzx1wI6FlW', 'COMPANY_EMPLOYER');
INSERT INTO USER (id, company_id, first_name, last_name, phone, email, password, role) VALUES (6, 1, 'Mike', 'Parker', '006', 'mike@localhost', '$2a$10$asrKNFf/xXs5PQRkzLiKLujxVLEPtYIXRbQ4lYomxQRHqe0yl9gXa', 'COMPANY_EMPLOYER');


INSERT INTO REPORT (user_id, company_id, name, data) VALUES (1, 1, 'Big Chery Report', 'Big Chery Report Data');
INSERT INTO REPORT (user_id, company_id, name, data) VALUES (2, 2, 'Big Apple Report', 'Big Chery Report Data');
