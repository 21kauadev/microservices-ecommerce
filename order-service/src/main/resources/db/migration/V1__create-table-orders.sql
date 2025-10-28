CREATE TABLE orders(
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL, -- só o id mesmo. não tem join pois são microsserviços.
    quantity INTEGER NOT NULL,
    total_value DECIMAL(5,2) NOT NULL, -- 5 numeros no total, 2 dps da virgula
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
