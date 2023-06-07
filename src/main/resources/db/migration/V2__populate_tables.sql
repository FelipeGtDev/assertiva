-- INSERTS NA TABELA "client"
INSERT INTO client (cpf, name) VALUES ('12345678901', 'João Silva');
INSERT INTO client (cpf, name) VALUES ('98765432109', 'Maria Santos');
INSERT INTO client (cpf, name) VALUES ('45678912305', 'Pedro Almeida');
INSERT INTO client (cpf, name) VALUES ('78912345602', 'Ana Pereira');
INSERT INTO client (cpf, name) VALUES ('32109876504', 'Lucas Oliveira');
INSERT INTO client (cpf, name) VALUES ('65432109803', 'Mariana Costa');
INSERT INTO client (cpf, name) VALUES ('98765432106', 'Carlos Rodrigues');
INSERT INTO client (cpf, name) VALUES ('23456789012', 'Camila Souza');
INSERT INTO client (cpf, name) VALUES ('56789012306', 'Rafael Lima');
INSERT INTO client (cpf, name) VALUES ('89012345603', 'Juliana Fernandes');
INSERT INTO client (cpf, name) VALUES ('45678901207', 'Gustavo Pereira');
INSERT INTO client (cpf, name) VALUES ('78901234502', 'Fernanda Santos');
INSERT INTO client (cpf, name) VALUES ('32109876508', 'Marcelo Oliveira');
INSERT INTO client (cpf, name) VALUES ('65432109807', 'Leticia Costa');
INSERT INTO client (cpf, name) VALUES ('98765432100', 'Gabriel Rodrigues');
INSERT INTO client (cpf, name) VALUES ('23456789016', 'Amanda Souza');
INSERT INTO client (cpf, name) VALUES ('56789012301', 'Vinicius Lima');
INSERT INTO client (cpf, name) VALUES ('89012345606', 'Larissa Fernandes');
INSERT INTO client (cpf, name) VALUES ('45678901210', 'Felipe Pereira');
INSERT INTO client (cpf, name) VALUES ('78901234505', 'Isabela Santos');
-- Inserts na tabela "phone"
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '999999999', 1);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '888888888', 2);
INSERT INTO phone (ddd, number, client_id) VALUES ('32', '777777777', 3);
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '666666666', 4);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '555555555', 5);
INSERT INTO phone (ddd, number, client_id) VALUES ('32', '444444444', 6);
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '333333333', 7);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '222222222', 8);
INSERT INTO phone (ddd, number, client_id) VALUES ('32', '111111111', 9);
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '000000000', 10);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '121212121', 11);
INSERT INTO phone (ddd, number, client_id) VALUES ('32', '232323232', 12);
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '343434343', 13);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '454545454', 14);
INSERT INTO phone (ddd, number, client_id) VALUES ('32', '565656565', 15);
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '676767676', 16);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '787878787', 17);
INSERT INTO phone (ddd, number, client_id) VALUES ('32', '898989898', 18);
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '909090909', 19);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '101010101', 20);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '222222222', 1);
INSERT INTO phone (ddd, number, client_id) VALUES ('32', '333333333', 2);
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '444444444', 3);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '555555555', 4);
INSERT INTO phone (ddd, number, client_id) VALUES ('32', '666666666', 5);
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '777777777', 6);
INSERT INTO phone (ddd, number, client_id) VALUES ('11', '888888888', 7);
INSERT INTO phone (ddd, number, client_id) VALUES ('32', '999999999', 8);
INSERT INTO phone (ddd, number, client_id) VALUES ('21', '101010101', 9);

-- Inserts na tabela "email"INSERT INTO email (client_id, email) VALUES (1, 1, 'cliente1@example.com');
INSERT INTO email (client_id, email) VALUES (2, 'cliente2@example.com');
INSERT INTO email (client_id, email) VALUES (3, 'cliente3@example.com');
INSERT INTO email (client_id, email) VALUES (4, 'cliente4@example.com');



