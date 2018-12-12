-- Base de datos DerbySQL (iweb iweb iweb)

-- Esquema básico

/*
    PRODUCTO: 
         id      - Int PK    - identificador autogeneraado.
         nombre     - String    - nombre para el producto.
         vendedor   - String    - email vendedor.
         cantidad   - Integer   - número de productos disponibles.
         precio     - Real      - precio unitario en € del producto.
         detalles   - String    - texto descriptivo del producto.
         imagen     - String    - url de una imagen para el producto.
         caducidad  - Date      - Fecha de caducidad del producto. (yyyy-mm-dd)
*/

DROP TABLE  producto ;

CREATE TABLE  producto  (
     id  INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
     nombre  VARCHAR(50) NOT NULL,
     cantidad  INTEGER NOT NULL,
     precio  FLOAT NOT NULL,
     detalles  VARCHAR(150),
     imagen  VARCHAR(256) NOT NULL DEFAULT 'https://i5.walmartimages.ca/images/Large/428/5_r/6000195494285_R.jpg',
     caducidad  DATE NOT NULL DEFAULT CURRENT_DATE,
     vendedor  VARCHAR(100) NOT NULL,
    PRIMARY KEY ( id )
);

INSERT INTO  producto  ( nombre ,  cantidad ,  precio ,  caducidad ,  vendedor ) VALUES ('Manzana', 10, 1, '2018-12-30', 'procione@mail.com');
INSERT INTO  producto  ( nombre ,  cantidad ,  precio ,  caducidad ,  vendedor ) VALUES ('Mela', 1, 1, '2018-12-30', 'orsetto@mail.com');
INSERT INTO  producto  ( nombre ,  cantidad ,  precio ,  caducidad ,  vendedor ) VALUES ('Apple', 5, 1, '2018-12-30', 'raccoon@mail.com');
INSERT INTO  producto  ( nombre ,  cantidad ,  precio ,  caducidad ,  vendedor ,  imagen ) VALUES ('Amaretto', 4, 10, '2020-1-1', 'carla@shop.com', 'https://media-verticommnetwork1.netdna-ssl.com/wines/amaretto-lombardo-1281397-s350.jpg');
INSERT INTO  producto  ( nombre ,  cantidad ,  precio ,  caducidad ,  vendedor ) VALUES ('Pasta', 4, 10, '2020-1-1', 'bi@shop.com');



UPDATE  producto  SET  detalles  = 'El alimento mas eficiente' WHERE  nombre  = 'Manzana';
UPDATE  producto  SET  detalles  = 'Il cibo piu efficiente' WHERE  nombre  = 'Mela';
UPDATE  producto  SET  detalles  = 'The most efficient food' WHERE  nombre  = 'Apple';
UPDATE  producto  SET  detalles  = 'Un cibo orribile' WHERE  nombre  = 'Amaretto';