# Modul Diskrete Stochastik

## Aufgabe 1: Spam-Filter nach Bayes
Ziel der Aufgabe ist es, einen Bayes-Spam-Filter zu programmieren und die Funktionsweise darzustellen.
Folgende Schritte werden erwartet:
1. Sie verschaffen sich einen Überblick über die Funktionsweise, etwa via
   - http://www.math.kit.edu/ianm4/~ritterbusch/seite/spam/de
   - https://en.wikipedia.org/wiki/Naive_Bayes_spam_filtering.
2. Sie erstellen ein Java-Programm, was folgendes leistet:
   - Die Emails aus ham-anlern.zip bzw. spam-anlern.zip werden nacheinander eingelesen
und als Ham bzw. Spam markiert. Dabei wird für jedes Wort in einer Ham- bzw. Spam-Mail gezählt, in wie vielen Ham- bzw. Spam-Mails das Wort vorkommt. Ein Wort muss dabei kein sinnvolles Wort sein. Sie können also jeweils die gesamte Mail, inklusive Header, einlesen und ein Leerzeichen als Worttrennungssymbol verwenden.
   - Sie implementieren eine Funktion, die für eine gegebene Mail die Spamwahrscheinlich- keit gemäss der in der obigen Quelle hergeleiteten Formel berechnet. (Dabei können Sie alle Wörter (und nicht nur die signifikantesten Wo ̈rter) zur Berechnung hinzu- ziehen.)
Falls ein Wort, etwa money in der Anlernphase nur in Ham-Mails vorkam, dann hat ei- ne Mail, die das Wort money enthält, eine Spamwahrscheinlichkeit von 0 (Begründen Siedies!),selbstdann,wenndieMailauchViagra, enlargement, Kenia, win,... enthält. Dies ist natürlich unerwünscht. Fügen Sie deshalb in der Anlernphase jedes Wort, was in einer der Ham-Mails aber in keiner Spam-Mail vorkommt, mit einer “Anzahl” α (sehr klein (< 1)) in den Spam-Korpus ein und umgekehrt für jedes Wort, welches in einer Spam- aber keine Ham-Mail vorkommt.
   - Bestimmen Sie geeignete Werte für den Schwellenwert, wann eine Mail als Spam klassifiziert werden soll und für obiges α, so dass ihr Spamfilter gut arbeitet. Nutzen Sie dazu die Mails in ham-kalibrierung.zip und spam-kalibrierung.zip.
   - Geben Sie an, wie viel Prozent der Mails in ham-test.zip bzw. spam-test.zip korrekt klassifiziert wurden.
3. Erwartet wird eine Abgabe, bei der nach dem Ausführen des Programms eine Zusammen- fassung aller Werte (Schwellenwert, α, Erkennungsraten) angezeigt wird.
4. Bevorzugt wird ein Eclpipse-Projet abgegeben, welches ich einfach importieren kann.

## Aufgabe 2: Bloom-Filter
Ziel der Aufgabe ist es, einen Bloom-Filter zu programmieren und die Funktionsweise darzu- stellen.
Folgende Schritte werden erwartet:
1. Sie verschaffen sich einen Überblick über die Funktionsweise, etwa unter https://en.wikipedia.org/wiki/Bloom_filter.
2. Sie erstellen ein Java-Programm, was folgendes leistet:
   - Bei einer gegebenen Anzahl n an zu erwartenden Elementen, die in der Datenstruktur
gespeichert werden und einer Fehlerwahrscheinlichkeit p wird eine geeignete Filter- grösse m und die optimale Anzahl k an Hashfunktionen berechnet.
   - Die Datenstruktur wird implementiert, mit den Methoden zum Einfügen von Strings und dem Test, ob ein String enthalten ist. Als Hash-Funktionen soll murmur3 128 (etwa in Guava enthalten: https://github.com/google/guava/wiki/Release19) verwendet werden mit jeweils einem anderen Seed.
   - Lassen Sie das Programm, welches eine Fehlerwahrscheinlichkeit p als Eingabe erhält, die Wörter aus words.txt einlesen und in einen Boom-Filter geeigneter Grösse einfügen. überprüfen Sie die Fehlerwahrscheinlichkeit, in dem Sie für eine grosse Anzahl an nicht enthaltenden Strings testen, ob sie enthalten sind. Die so experi- mentell bestimmte Fehlerwahrscheinlichkeit soll zusammen mit den Parametern der Datenstruktur ausgegeben werden.
   - Bitte räumen Sie ihr Projekt so auf, dass ich keine speziellen Pakete nachladen oder komplizierte Pfadanpassungen machen muss.
3. Sie erstellen mit LATEX (https://www.latex-project.org/) eine Zusammenfassung von ein bis zwei Seiten, welche folgendes enthält:
   - Idee des Bloom-Filters, mit Vor- und Nachteilen
   - ein konkretes Beispiel aus der Praxis, wo der Bloom-Filter verwendet wird mit kurzer Beschreibung dieses Programms
   - Eine Beschreibung, wie Sie die Fehlerwahrscheinlichkeit ihrer Datenstruktur getestet haben und welche Resultate dabei erzielt worden sind.
4. Senden Sie mir bitte per Mail sowohl das Java-Projekt als auch den LATEX-Quellcode (und das fertige pdf) zu.
