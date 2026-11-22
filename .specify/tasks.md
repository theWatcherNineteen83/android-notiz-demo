# Aufgaben: Notiz-Demo

**Format:** `- [ ] [ID] [P?] [Story?] Beschreibung mit Dateipfad`
`[P]` = parallelisierbar · `[USx]` = User Story aus spec.md

## Erledigt — v1.0.0 (2026-11-22)

- [x] T001 Projektstruktur + `.gitignore` anlegen (gemäß plan.md)
- [x] T002 `build.sh` nach Vorbild S9-Bridge (aapt2/javac/d8/zipalign/apksigner)
- [x] T003 `app/src/main/AndroidManifest.xml` (minSdk 26, targetSdk 29, 0 Permissions)
- [x] T004 [US1] Modell `Note.java` (immutable: text + createdAt)
- [x] T005 [US2] Persistenz `NoteStore.java` + Vertrag `contracts/notestore.md`
- [x] T006 [US1] Layout `res/layout/activity_main.xml` + `res/values/strings.xml`
- [x] T007 [US1] `MainActivity.java`: Anlegen inkl. Leer-Abweisung (FA-003)
- [x] T008 [US2] Laden beim Start + Speichern bei jeder Änderung
- [x] T009 [US3] Löschen per langem Tipp mit AlertDialog-Rückfrage
- [x] T010 Spec-Kit-Bundle `.specify/` + README + docs (deutsch)
- [x] T011 Build auf miniedi + signierte APK als GitHub-Release v1.0.0

## Offen — Abnahme

- [ ] T012 Manuelle Checkliste `quickstart.md` auf dem Handy der Eigentümerin
      ausführen und Ergebnisse hier eintragen (Datum + Gerät). Erst danach gilt
      v1.0 als „auf Gerät verifiziert" (Wahrhaftigkeitsregel!).

## Ideen für Ausbaustufen (wartet auf deine Auswahl — E-Mail genügt!)

Reihenfolge = Vorschlag, nicht Pflicht. Jede Idee wird VOR dem Bauen zu einer
eigenen Spec (spec.md ergänzen) → plan.md → tasks.md. Immer nur EINE gleichzeitig.

- [ ] T101 [P] Automatisierte Tests für `NoteStore` (Round-Trip, defekte Datei)
      — macht spätere Änderungen sicher; braucht org.json als Test-Abhängigkeit.
- [ ] T102 [US-neu] Notiz bearbeiten (antippen statt langem Tipp) — Datenmodell
      braucht dann stabile IDs (siehe data-model.md, Migrationsplan nötig).
- [ ] T103 [P] Suche/Filter über den Notizen (Suchfeld oben).
- [ ] T104 [P] Kategorien/Farben (z. B. Einkaufen / Arbeit / Privat).
- [ ] T105 [P] Dark Mode (zweites Theme, umschaltbar).
- [ ] T106 Notizen teilen/exportieren (Text-Datei) — ACHTUNG: Verfassung
      Prinzip 5: erste Funktion, die Daten das Gerät verlassen lässt →
      eigene Story mit ausdrücklichem Einverständnis.
- [ ] T107 Erinnerungsfunktion (Benachrichtigung zu einer Notiz) — braucht
      POST_NOTIFICATIONS auf Android 13+, erste Permission → bewusst entscheiden.
- [ ] T108 Mehrsprachigkeit (englisch zusätzlich, `res/values-en/`).

## Next Actions
1. Eigentümerin installiert v1.0.0 und macht T012 (Abnahme).
2. Sie wählt EINE Idee (oder etwas ganz Eigenes) → E-Mail an Georg, der sie an
   Prometheus weiterleitet (Vorlage: `docs/feature-wunsch-vorlage.md`).
3. Prometheus schreibt Spec/Plan/Tasks, holt Freigabe ein, baut, released v1.1.
