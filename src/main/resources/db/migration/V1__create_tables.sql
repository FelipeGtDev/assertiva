CREATE TABLE client(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    PRIMARY KEY (id)
) ;

CREATE TABLE phone(
    id BIGINT NOT NULL AUTO_INCREMENT,
    ddd varchar(2),
    phone_number varchar(9),
    client_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE email(
    id BIGINT NOT NULL AUTO_INCREMENT,
    email varchar(255),
    client_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES client(id)
);
