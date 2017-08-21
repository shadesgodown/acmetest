CREATE SEQUENCE vinyl_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE vinyl(
  id                  NUMERIC DEFAULT nextval('vinyl_id_seq') NOT NULL,
  title               VARCHAR(255) NOT NULL,
  artist              VARCHAR(255) NOT NULL,
  label               VARCHAR(255) NOT NULL,
  release_date        DATE NOT NULL
);

ALTER SEQUENCE vinyl_id_seq OWNED BY vinyl.id;