CREATE TABLE IF NOT EXISTS weather (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    temperature DOUBLE NOT NULL,
    humidity INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    wind_speed DOUBLE NOT NULL
);