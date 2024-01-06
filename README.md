# Practica2-SO
[!NOTE]
Pràctica 2
1. Objectius
L'objectiu principal serà construir una aplicació web a partir de l'API Web desenvolupada en el primer lliurament.

2. Especificacions generals
Aquesta aplicació tindrà una part pública, accessible per a tothom, i una part privada, on només poden accedir-hi els usuaris registrats.

2.1 Part Pública
En accedir al lloc web, l'aplicació mostrarà el llistat dels videojocs ("scroll" vertical infinit) o bé en forma de graella (p. ex., 3x3) ordenats alfabèticament per nom. L'usuari haurà de poder filtrar els videojocs per tipus de videojoc (p. ex., plataformes) o per videoconsola (p. ex., Super Nintendo). Caldrà proporcionar elements necessaris d'interfície d'usuari per aplicar aquests dos filtres com p. ex., llistes desplegables, botons, etc.

En aquesta pàgina, la web haurà de mostrar la següent informació per cada videojoc:

El nom del videojoc, p. ex., Super Mario Land, etc.;
Amb quina videoconsola s'hi pot jugar, p. ex., Game Boy, Mega Drive, etc.;
La seva disponibilitat actual;
El preu del lloguer setmanal.
Un exemple, podria ser el següent:



Figura 1. Exemple de la informació que s'haurà d'ensenyar per cada videojoc.

Quan l'usuari vegi un videojoc que li interessi, podrà clicar sobre la imatge de la caràtula del videojoc. Això permetrà presentar el detall complet d'aquest en una nova pàgina, incloent-hi una altra vegada la informació anterior i a més:

Una descripció del videojoc, p. ex., Quake és un videojoc d'acció en primera persona, desenvolupat per ID Software i publicat per GT Interactive el 1996.
El tipus de videojoc (plataforma, d'acció, de lluita, de tir en primera persona, etc.)
L'adreça de les botigues físiques on es pot recollir. L'adreça ha de ser completa, p. ex., The Retro Games Store, pl. del Blat 3, Valls, 43800.
Un botó per poder afegir el videojoc a la cistella de lloguer.


Figura 2. Informació més detallada del videojoc.

Finalment, quan l'usuari desitgi formalitzar el lloguer dels diferents videojocs, podrà clicar un altre botó tipus  i se li obrirà una nova pàgina per efectuar el lloguer sempre que s'hagi autentificat prèviament. En aquesta nova pàgina, apareixerà un formulari amb el llistat de videojocs que es vol adquirir juntament amb el preu total i la data de retorn (una setmana). Un cop l'usuari hagi adquirit els videojocs, se li retornarà un rebut amb l'identificador de la seva transacció. Els videojocs llogats hauran de passar a l'estat de no disponibles.

 2.2 Part Privada
Així doncs, tant el llistat amb els videojocs com la pàgina amb el detall complet es podran visualitzar sempre, tant si s'està autentificat com si no. Si l'usuari està autentificat, s'haurà de mostrar sempre en alguna part de la web de quin usuari es tracta, habitualment indicant el seu nom d'usuari "Benvingut Marc!" i podrà llogar videojocs.

A la part privada s'hi accedirà via un formulari on s'introdueix el nom d'usuari i una contrasenya.  Recordeu que com a mínim hi ha d'haver un usuari amb nom "sob" i contrasenya "sob".

2.3 Autentificació
Des de qualsevol de les planes de la part pública clarament s'ha de visualitzar només un dels següents elements:

"Login", o terme similar, per tal de permetre l'usuari que s'hi autentifiqui. Aquest enllaç, o element equivalent, només es mostrarà en els casos que l'usuari no s'hagi autentificat encara.
"Benvingut {nom usuari}!", on {nom usuari} serà el nom de l'usuari, per exemple "Benvingut Marc!". Aquest text només apareixerà quan l'usuari s'hagi autentificat. Si es fa clic al nom d'usuari, es mostraran les dades del seu perfil d'usuari.
Sempre que es procedeixi a fer un lloguer, el sistema comprovarà si l'usuari està ja autentificat. En cas de no estar autentificat, el sistema mostrarà el típic formulari de "Login" per poder escriure l’usuari i contrasenya. Si aquest usuari existeix a la base de dades, i la contrasenya coincideix amb la contrasenya que aquest té establerta, aleshores l'autentificació s'haurà completat correctament. Altrament, es tornarà a mostrar el formulari per tornar a intentar entrar, amb un missatge d’error a la zona superior que indiqui a l’usuari que les dades introduïdes són incorrectes.



Figura 3. Metàfora de la pantalla de "login".

Quan el client s'hagi autentificat satisfactòriament, es tornarà automàticament a la pàgina que va causar que l'usuari s'autentifiqués. Això és, es tornarà a veure la pàgina amb el detall complet del videojoc, o bé tornarà a veure el llistat de tots els videojocs, si venia de la pàgina del llistat.

Important:
Si cal fer algun tipus d'inicialització (p. ex., creació de la base de dades), haureu d'afegir els fitxers necessaris perquè ho faci (p. ex., els scripts SQL corresponents) de forma automàtica.
Serà obligatori incloure un usuari amb nom "sob" i contrasenya "sob".
Només s'acceptarà aquella pràctica que segueixi el MVC, basat en el codi base lliurat, i faci servir el back-end REST definit en l'enunciat de la Pràctica 1.
Si es fan servir eines que no s'hagin vist a classe, caldrà informar el professor prèviament.
2.4 Parts opcionals
Opció de registrar nous usuaris.
Disseny responsiu com a mínim per dos dispositius: un de mòbil i un d'escriptori. 
Històric de totes les transaccions fetes per un usuari.
Que disposant del codi de l'aplicació web i el contingut de la base de dades no es pugui recuperar la contrasenya d'usuari.
Altres parts opcionals proposades pels alumnes.
3. Documentació
Juntament amb el codi font caldrà lliurar un informe en format PDF amb la següent estructura:

Introducció. Presentació general de la pràctica i dels objectius.
Estructura de la pràctica. Per exemple, caldrà especificar l’estructura de projecte, dels fitxers i de la base de dades, entre d’altres.
Decisions de disseny. Quines alternatives heu considerat a l’hora de fer el projecte i perquè heu escollit l’alternativa escollida enfront de les altres. Aquí, entre altres coses, hauríeu d’explicar quin model dels vistos a classe heu fet servir, quines parts opcionals o millores addicionals heu fet i com heu decidit implementar-­les. Heu emprat eines i recursos externs?
Jocs de proves realitzats. Quines proves heu fet per assegurar­-vos que el vostre projecte funciona correctament en tots els casos possibles. Heu aplicat TDD i/o BDD?
Conclusions. A quines conclusions heu arribat en finalitzar aquest projecte. Què heu après? Creieu que us pot ser útil en el futur? Llisteu també tres elements de l’assignatura aplicats en aquesta pràctica que us han agradat més, i uns altres tres que us han agradat menys. Els elements estaran ordenats per prioritat, de forma que el primer element en cada llista serà el que més i menys t’hagi agradat, respectivament.
Manual d’instal∙lació. De forma breu, directa i clara, especificar els passos a seguir per tal de fer funcionar la vostra pràctica per part del professor, considerant que el professor ja disposa del vostre projecte NetBeans instal∙lat al NetBeans. 

4. Lliurament del projecte
El projecte s’entregarà via Moodle abans de la data màxima d’entrega que consti allà, la qual està prevista que sigui el 23 de gener de 2023.

Cal que entregueu un arxiu .zip anomenat SOB_P2_nom1_nom2.zip, on nom1 i nom2 seran el nom (i cognoms) de cada un dels components del grup que entrega la pràctica.

Aquest fitxer zip ha de contenir un fitxer anomenat documentacio.pdf amb la documentació de la pràctica que segueixi el format explicat en el punt anterior.

A més a més, hi ha d’haver una carpeta anomenada projecte on hi haurà tots els fitxers que formen el projecte en NetBeans, de manera que es pugui obrir directament en el mateix entorn del laboratori.

5. Avaluació
El procés per l'avaluació seguirà aquests passos (assegura't que funciona tot bé seguint-los):

Executarem el projecte en l'entorn escollit (en NetBeans, amb el Run project).
Tornarem a visitar l'índex del projecte i introduirem l'usuari sob i contrasenya sob per entrar a la vostra pràctica.
Si es desenvolupa correctament la part obligatòria, es podrà aconseguir fins a un 10 de la nota del projecte. Les parts opcionals serviran per compensar alguna mancança de la part obligatòria. També podeu posar altres ampliacions que considereu convenients, prèvia acceptació del vostre professor de laboratori.

Alguns dels aspectes que es valoraran són:

Funcionalitat correcta del projecte.
Estructuració de la pràctica i decisions de disseny preses.
Elegància de la solució proposada a nivell de programació.
Aspecte visual mitjançant CSS i usabilitat.
Seguretat i mantenibilitat de l’aplicatiu.
Compliment dels estàndards i convencions a l’hora de desenvolupar una aplicació web en Java+Netbeans o de la plataforma escollida.
Qualitat de la documentació presentada.
