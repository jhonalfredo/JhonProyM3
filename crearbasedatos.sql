-- Tabla "user_account"
CREATE TABLE user_account (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(150) NOT NULL,
    password VARCHAR(150) NOT NULL,
    email VARCHAR(150) NOT NULL,
    created_at TIMESTAMP
);

-- Tabla "user_detail"
CREATE TABLE user_detail (
    user_id BIGINT PRIMARY KEY REFERENCES user_account(id),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    age INTEGER,
    birth_day DATE
);


-- Tabla "rol"
CREATE TABLE rol (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL
);

-- Tabla "user_rol"
CREATE TABLE user_rol (
    id SERIAL PRIMARY KEY NOT NULL,
    active BOOLEAN NOT NULL,
    created_at TIMESTAMP NOT NULL,
    user_id BIGINT REFERENCES user_account(id),
    rol_id INTEGER REFERENCES rol(id)
);
