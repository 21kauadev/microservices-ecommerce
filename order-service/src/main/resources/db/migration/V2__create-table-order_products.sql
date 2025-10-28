-- tabela pra manipular os produtos do pedido.
CREATE TABLE order_products (
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,-- vem de um serviço diferente. sem join
    FOREIGN KEY (order_id) REFERENCES orders(id) -- aqui o join é recomendado. mesmo serviço, mesmo banco.
);