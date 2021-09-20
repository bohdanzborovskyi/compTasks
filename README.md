# compTasks
Projekt został napisany przy użyciu Java 11, Spring Boot.
Pierwsze zadanie polegało na tworzeniu struktury klass związanych z Drzewami.
Zostały utworzone następujące klasy:Pień(Trunk),Lisćie(Leave) oraz jego implementacje(Needle i Simple), 
Gałęzie(Branch) oraz jego implementacje(Needle i Deciduous), Drzewo(Tree) oraz jego implementacje(NeedleTree, DeciduousTree).

Drugie zadanie polegało na stworzneiu rest api dla zachowania gps lokalizacji: klasa gpsdto jest klasą przechowującą obiekty gps które będą trafiały do naszego API. Wszystkie obiekty zapisują się do Set(również można było stworzyć bazę danych postgresql i użyć JPA do mapowania się z nią i zapisywać do niej przy pomocy realizacji interfejsu crudrepository). Klasa kontroler pobiera dane gps i zapisuje ich jako obiekt. Została dodana prosta walidacja podanych danych oraz odpornośc na błędy i wypisania komunikató dla klienta o występującym błądzie.

Trzecie zadanie polegało na skorzystaniu Strpipe API dla tworzenia instancji Invoice dla klienta o podanym ID oraz pobieraniu danych o Invoice dla klienta o podanym ID. Została dodana prosta obsługa błędów z pobieraniem wiadomości o problemie od Stripe API i wypisaniem do klienta.


