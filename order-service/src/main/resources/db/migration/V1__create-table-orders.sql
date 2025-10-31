CREATE TABLE orders(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER NOT NULL, -- só o id mesmo. não tem join pois são microsserviços.
    quantity INTEGER NOT NULL,
      total_value DECIMAL(5,2) NOT NULL, -- 5 numeros no total, 2 dps da virgula
      status VARCHAR(50) NOT NULL,
      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  );

  -- tabela pra manipular os produtos do pedido.
  CREATE TABLE order_products (
      id BIGINT PRIMARY KEY AUTO_INCREMENT,
      product_id BIGINT NOT NULL,-- vem de um serviço diferente. sem join
      order_id BIGINT NOT NULL,
      CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE -- aqui o join é recomendado. mesmo serviço, mesmo banco.
  );