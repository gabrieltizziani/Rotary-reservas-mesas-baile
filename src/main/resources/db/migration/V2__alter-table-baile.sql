ALTER TABLE baile
    ADD COLUMN total_mesas INT NOT NULL DEFAULT 0 CHECK (total_mesas >= 0);
