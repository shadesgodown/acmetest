CREATE SEQUENCE album_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE album(
  id                  NUMERIC DEFAULT nextval('album_id_seq') NOT NULL PRIMARY KEY,
  title               VARCHAR(255) NOT NULL,
  artist              VARCHAR(255) NOT NULL,
  label               VARCHAR(255) NOT NULL
);

ALTER SEQUENCE album_id_seq OWNED BY album.id;