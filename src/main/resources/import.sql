INSERT INTO mesto (grad, drzava) VALUES ("Valjevo","Srbija");
INSERT INTO mesto (grad, drzava) VALUES ("Novi Sad","Srbija");

INSERT INTO preduzece (naziv,adresa,pib,telefon,email,password,logo,tip,mesto) VALUES ("Preduzece","Adresa 1","123123","062326386","vasic@gmail.com","$2a$10$Z8O3J.Zjzfud8E3bLNvX7.FpXlklVPzo36VgxyVl8d6sZdjHvWUVK","logo 1","tip 1",1);
INSERT INTO preduzece (naziv,adresa,pib,telefon,email,password,logo,tip,mesto) VALUES ("Preduzece 2","Adresa 2","123123","062326386","aleksandar@gmail.com","$2a$10$Z8O3J.Zjzfud8E3bLNvX7.FpXlklVPzo36VgxyVl8d6sZdjHvWUVK","logo 1","tip 2",2);

INSERT INTO poslovna_godina (godina, zakljucena) VALUES (2010,0);
INSERT INTO poslovna_godina (godina, zakljucena) VALUES (2011,0);

INSERT INTO poslovni_partner (naziv,adresa,vrsta,mesto,preduzece) VALUES ("Partner 1","adresa partnera 1","xx",1,1);
INSERT INTO poslovni_partner (naziv,adresa,vrsta,mesto,preduzece) VALUES ("Partner 2","adresa partnera 2","yy",2,2);

INSERT INTO faktura (datum_fakture,datum_valute,status,preduzece,poslovna_godina,poslovni_partner) VALUES ('2017-01-01','2017-02-01',"OK",1,1,1);
INSERT INTO faktura (datum_fakture,datum_valute,status,preduzece,poslovna_godina,poslovni_partner) VALUES ('2018-01-01','2015-02-01',"OK",2,1,2);

INSERT INTO pdv (naziv) VALUES ("pdv");
INSERT INTO pdv (naziv) VALUES ("pdv1");

INSERT INTO stopa_pdv (datum_vazenja,procenat,pdv) VALUES ("2018-06-23T14:25:10", "20", 1);
INSERT INTO stopa_pdv (datum_vazenja,procenat,pdv) VALUES ("2016-03-23T14:25:10", "10", 2);

INSERT INTO grupa_robe (naziv, pdv, preduzece) VALUES ("robaN", 1, 1);
INSERT INTO grupa_robe (naziv, pdv, preduzece) VALUES ("robaS", 2, 1);

INSERT INTO jedinica_mere (naziv) VALUES ("kg");
INSERT INTO jedinica_mere (naziv) VALUES ("m");

INSERT INTO roba (naziv, grupa_robe, jedinica_mere) VALUES ("robaNaziv1", 1, 1);
INSERT INTO roba (naziv, grupa_robe, jedinica_mere) VALUES ("robaNaziv2", 2, 1);

INSERT INTO cenovnik (datum_vazenja,preduzece) VALUES ('2019-02-01',1);
INSERT INTO cenovnik (datum_vazenja,preduzece) VALUES ('2019-02-01',2);

INSERT INTO stavka_cenovnika (cena, roba, cenovnik) VALUES (100,1,1);
INSERT INTO stavka_cenovnika (cena, roba, cenovnik) VALUES (50,2,1);