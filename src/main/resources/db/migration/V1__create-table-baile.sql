CREATE TABLE baile (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,          -- ID auto-increment
                       nome_baile VARCHAR(255) NOT NULL,             -- nome do baile
                       descricao_baile TEXT,                          -- descrição do baile
                       data_do_baile DATETIME NOT NULL,               -- data e hora do baile
                       localizacao VARCHAR(255) NOT NULL,            -- local do baile
                       status ENUM('ABERTO', 'ENCERRADO', 'CANCELADO') NOT NULL DEFAULT 'ABERTO' -- status do baile
);
