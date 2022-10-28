CREATE TABLE bicicleta (
id NUMBER PRIMARY KEY,
modelo VARCHAR2(45),
color VARCHAR2(45),
aro NUMBER,
precio NUMBER,
idMarca NUMBER,
FOREIGN KEY (idMarca) REFERENCES marca(id)
);



CREATE TABLE marca (
id NUMBER  PRIMARY KEY,
nombre VARCHAR2(45)
);


CREATE TABLE BicicletaMarca(
idBicicleta NUMBER,
idMarca NUMBER,
FOREIGN KEY (idMarca) REFERENCES marca(id),
FOREIGN KEY (idBicicleta) REFERENCES bicicleta(id)
);

INSERT INTO  marca (id, nombre)
VALUES(1, 'montana');
INSERT INTO  marca (id, nombre)
VALUES(2, 'bonita');
INSERT INTO marca (id, nombre)
VALUES(3, 'estupenda');


INSERT INTO bicicleta(id, modelo, color, aro, precio, idMarca)
VALUES (1, 'ruda','rojo', 29, 150000, 1);
INSERT INTO bicicleta(id, modelo, color, aro, precio, idMarca)
VALUES (2, 'ruda','rojo', 29, 150000, 2);
INSERT INTO bicicleta(id, modelo, color, aro, precio, idMarca)
VALUES (3, 'ruda','rojo', 29, 150000, 3);






