# Notiz-Demo — Verfassung (Constitution)

**Version**: 1.0.0 · **Ratifiziert**: 2026-11-22 · **Zuletzt geändert**: 2026-11-22

Diese Regeln stehen über allen anderen Praktiken im Projekt. Änderungen erfordern
Dokumentation + Begründung.

## Kernprinzipien

1. **Wahrhaftigkeit (NICHT VERHANDELBAR)** — Keine Behauptung ohne Beleg.
   „Fertig / funktioniert / verfügbar" nur mit Build-Ergebnis oder durchgeführtem
   Test. Fehler sofort zugeben, nicht vertuschen.
2. **Einfachheit vor Vollständigkeit** — Keine externe Bibliothek, kein Framework,
   kein Build-System, solange es ohne geht. Jede neue Abhängigkeit braucht eine
   Begründung in `plan.md` (Komplexitäts-Nachverfolgung).
3. **Eine Sache zur Zeit (WIP = 1)** — Genau EINE User Story wird angefangen und
   fertiggestellt, bevor die nächste beginnt. Kleine Schritte, keine Revolution.
4. **Definition of Done** — Eine Story gilt erst als fertig, wenn:
   (a) `./build.sh` fehlerfrei durchläuft,
   (b) die manuelle Checkliste in `quickstart.md` für die Story bestanden ist,
   (c) `.specify/`-Doku und README den neuen Stand widerspiegeln.
   *Hinweis, ehrlich:* v1.0 hat keine automatisierten Tests — die Verifikation ist
   manuell. Automatisierte Tests sind Ausbaustufe T101 in `tasks.md`.
5. **Privatsphäre zuerst** — Die App bleibt offline und ohne Berechtigungen.
   Jede Funktion, die Daten das Gerät verlassen lässt (Internet, Export, Teilen),
   braucht eine eigene User Story mit ausdrücklichem Einverständnis der Nutzerin.
6. **Deutsch als Projektsprache** — Doku, Specs und Kommentare auf Deutsch,
   damit die Eigentümerin alles nachvollziehen kann. Code-Bezeichner englisch.

## Governance

- Die Verfassung steht über allen anderen Praktiken.
- Änderungen: dokumentieren + Freigabe der Eigentümerin + Migrationsplan.
- Spec-Kit-Referenz: `docs/spec-kit-deutsch-java.md` (verbindliche Vorlagen).
