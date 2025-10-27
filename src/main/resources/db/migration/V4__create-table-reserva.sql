CREATE TABLE reserva (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nome_para_reserva VARCHAR(100) NOT NULL,
                         data_reserva DATETIME DEFAULT CURRENT_TIMESTAMP,
                         mesa_id BIGINT NOT NULL,
                         baile_id BIGINT NOT NULL,
                         ativa BOOLEAN DEFAULT TRUE,
                         FOREIGN KEY (mesa_id) REFERENCES mesa(id) ON DELETE CASCADE,
                         FOREIGN KEY (baile_id) REFERENCES baile(id) ON DELETE CASCADE
);
