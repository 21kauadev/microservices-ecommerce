CREATE TABLE product(
    id SERIAL PRIMARY KEY, -- auto increment
    name VARCHAR(80) NOT NULL,
    description TEXT NOT NULL,
    price NUMERIC(5,2) NOT NULL, -- 5 num no total, só 2 dps da virgula
    stock INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);