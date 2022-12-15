Code-Transfer zu TecRacer
========================
1. Große Teile dieser Anwendung sind generiert. Es kommt also relativ viel Code mit, von dem nicht alles relevant ist. Die KinoApp selbst befindet sich im Paket generated.kinoApp, alle anderen Pakete sind irrelevant. Im Paket generated.kinoApp gibt es zu Lernzwecken die Pakete proxies und commands, die ebenfalls nicht wichtig sind.
2. Wie man die Anwendung bedient, ist aus den Testfällen in der Klasse tests.KinoAppTest zu ersehen.
    a) Für jeden Testfall wird in setUp() ein Kinosaal, ein Film und ein Kunde eingerichtet.
    b) test1() prüft die korrekte Konfiguration des Saals
    c) test2() zeigt, wie man Reservierungen erstellt
    d) test3() wie man Reservierungen bucht
    e) test4(), test5() zeigt die Analysemethoden zur Ermittlung der Einnahmen
    f) Die genutzten Methoden sind alle in der (Singleton-)Klasse KinoApp enthalten (ganz unten im Editable Code mit der Kennung 80)
3.  Es gibt einige Vereinfachungen in der Anwendung selbst:
    a) Beträge haben keine Währung (oder immer Euro). Die Beträge sind rationale Zahlen (auch zu Lernzwecken, um optimale Genauigkeit zu haben)
    b) Reservierungen mit mehreren Plätzen können nichtzusammenhängend sein


