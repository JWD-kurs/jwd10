## Lab 8 - AngularJS, Spring - HTTP request parametri, paginacija

----

### Filteri

Zapravo pretraživanje podataka na osnovu nekog kriterijuma.

* Implementacija pretraživanja aktivnosti po imenu - dodati input polje u koje će korisnik unositi upit pretrage, kao i dugme Search.

* Implementirati pretraživanje slanjem upita na REST servis (server-side).


Po pravilu, svi dodatni parametri koje je neophodno poslati REST servisu, šalju se preko HTTP request parametara. Npr., za zahtev:

HTTP GET http://www.restservice.com/api/examples**?param1=value1&param2=value2**

request parametri su param1 i param2 i imaju vrednosti value1 i value2. Naravno, ne moraju se zvati (čak se i ne savetuje) param1 i param2,
već nešto smisleno. Vodeći se ovim, pretraživanje aktivnosti po imenu (na WAFEPA aplikaciji) će biti implementirano slanjem request parametra **name**, 
npr. za pronalaženje aktivnosti čije ime sadrži reč "run":

HTTP GET http://localhost:8080/api/activities**?name=run**  (obratite pažnju da je osnovni poziv na REST isti, samo smo dodali request parametre na kraju)

**Pogrešne implementacije pretraživanja aktivnosti po imenu (preko REST servisa)**:

* HTTP GET http://localhost:8080/api/activities/run
* HTTP GET http://localhost:8080/api/activities/name/run
* HTTP POST http://localhost:8080/api/activities/find
* HTTP GET http://localhost:8080/api/find_activities?name=run
* HTTP GET http://localhost:8080/api/find_by_name/run
* itd...

Spring omogućava proširenje REST servisa ovakvim request parametrima. Sve što je potrebno uraditi je:

* Metodu kontrolera proširiti parametrom i anotirati ga sa @RequestParam.

* Dakle, u našem slučaju metodu getActivities (kontroller ApiActivitiesController) proširiti parametrom String name i anotirati ga sa @RequestParam.

AngularJS omogućava slanje request parametra kroz $http servis, tako što se u drugom argumentu poziva funkcije $http servisa 
postave željeni request parametri u poseban objekat **params** (mora se tako zvati po AngularJS dokumentaciji). Primer:


```javascript
$http.get('api/activities', { params: {'name': 'run'}})
		.success(...)
		.error(...)
```


----

### Paginacija

Dobavaljanje podataka u stranicama. Ovo se u praksi uvek koristi, jer se smanjuje otperećenje servera, ali se i povećava preglednost samom korisniku.

* Desno ispod tabele za prikaz aktivnosti, dodati dva dugmeta: "Previous" i "Next".

* Implementirati paginaciju.
  * REST servis proširiti request parametrom **page** koji predstavlja indeks stranice koja se dobavlja
  * Proširiti frontend aplikaciju da šalje request parametar **page**. Podrazumevana vrednost ovog parametra je 0.
  * Onemogućiti pritisak dugmeta "Previous" ako je korisnik na prvoj stranici, odnosno dugmeta "Next" ako je na poslednjoj.

----

### Domaći zadaci

* Uraditi za korisnike sve što je urađeno na času za aktivnosti.
* Izmeniti pretraživanje tako da radi uz paginaciju.
* Omogućiti pretraživanje korisnika po imenu ILI prezimenu (dakle ukoliko je upit pretrage "pet"), treba pronaći korisnika koje se zove npr. "Petar",
ali i korisnika koji se preziva npr. "Petrović".
* Dodati novu stranicu "Filmovi", na kojoj je moguće pretraživati filmove po imenu i godini koristeći themoviedb.org API https://www.themoviedb.org/documentation/api .

