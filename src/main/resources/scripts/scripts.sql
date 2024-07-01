CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    enabled INT NOT NULL
);

CREATE TABLE authorities (
    id SERIAL PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    authority VARCHAR(45) NOT NULL
);

INSERT INTO users (username, password, enabled) VALUES ('happy', '12345', 1)
ON CONFLICT DO NOTHING;

INSERT INTO authorities (username, authority) VALUES ('happy', 'write')
ON CONFLICT DO NOTHING;

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    email VARCHAR(45) NOT NULL,
    pwd VARCHAR(200) NOT NULL,
    role VARCHAR(45) NOT NULL
);

INSERT INTO customer (email, pwd, role) VALUES ('johndoe@example.com', '54321', 'admin');