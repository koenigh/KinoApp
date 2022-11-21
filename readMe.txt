1. Gro�e Teile dieser Anwendung sind generiert. Es kommt also relativ viel Code mit, von dem nicht alles relevant ist. Die KinoApp selbst befindet sich im Paket generated.kinoApp, alle anderen Pakete sind irrelevant. Im Paket generated.kinoApp gibt es zu Lernzwecken die Pakete proxies und commands, die ebenfalls nicht wichtig sind.
2. Wie man die Anwendung bedient, ist aus den Testf�llen in der Klasse tests.KinoAppTest zu ersehen.
    a) F�r jeden Testfall wird in setUp() ein Kinosaal, ein Film und ein Kunde eingerichtet.
    b) test1() pr�ft die korrekte Konfiguration des Saals
    c) test2() zeigt, wie man Reservierungen erstellt
    d) test3() wie man Reservierungen bucht
    e) test4(), test5() zeigt die Analysemethoden zur Ermittlung der Einnahmen
    f) Die genutzten Methoden sind alle in der (Singleton-)Klasse KinoApp enthalten (ganz unten im Editable Code mit der Kennung 80)
3.  Es gibt einige Vereinfachungen in der Anwendung selbst:
    a) Betr�ge haben keine W�hrung (oder immer Euro). Die Betr�ge sind rationale Zahlen (auch zu Lernzwecken, um optimale Genauigkeit zu haben)
    b) Reservierungen mit mehreren Pl�tzen werden k�nnen nichtzusammenh�ngend sein


