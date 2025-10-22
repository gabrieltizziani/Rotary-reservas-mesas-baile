CREATE TABLE mesa (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      numero_mesa INT NOT NULL,
                      reservada BOOLEAN DEFAULT FALSE,
                      baile_id BIGINT NOT NULL,
                      FOREIGN KEY (baile_id) REFERENCES baile(id) ON DELETE CASCADE
);
