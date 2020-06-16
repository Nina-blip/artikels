insert into artikels(naam, prijs, artikelGroepId) values ('Appel', 0.77, (select id from artikelgroepen where naam = 'Fruit'));
insert into artikels(naam, prijs, artikelGroepId) values ('Banaan', 1.45, (select id from artikelgroepen where naam = 'Fruit'));
insert into artikels(naam, prijs, artikelGroepId) values ('Aardappel', 0.51, (select id from artikelgroepen where naam = 'Groenten'));
insert into artikels(naam, prijs, artikelGroepId) values ('Bloemkool', 1.68, (select id from artikelgroepen where naam = 'Groenten'));