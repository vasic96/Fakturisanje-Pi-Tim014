INSERT INTO mesto (grad, drzava) VALUES ("Valjevo","Srbija")
INSERT INTO mesto (grad, drzava) VALUES ("Novi Sad","Srbija")

INSERT INTO preduzece (naziv,adresa,pib,telefon,email,password,logo,tip,mesto) VALUES ("Preduzece","Adresa 1","123123","062326386","vasic@gmail.com","password","logo 1","tip 1",1);
INSERT INTO preduzece (naziv,adresa,pib,telefon,email,password,logo,tip,mesto) VALUES ("Preduzece 2","Adresa 2","123123","062326386","aleksandar@gmail.com","password","logo 1","tip 2",2);

INSERT INTO cenovnik (datum_vazenja, preduzece) VALUES ("2004-05-23T14:25:10",1)
INSERT INTO cenovnik (datum_vazenja, preduzece) VALUES ("2004-05-23T14:25:10",2)

INSERT INTO poslovna_godina (godina, zakljucena) VALUES (1996,0)
INSERT INTO poslovna_godina (godina, zakljucena) VALUES (2018,1)
