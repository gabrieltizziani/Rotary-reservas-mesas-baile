CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       login VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL
);
