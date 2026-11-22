# Quickstart: Bauen & manuell testen

## APK bauen

```bash
export ANDROID_HOME=/pfad/zum/android-sdk   # Standard: ~/android-sdk
./build.sh
```

Erwartete Ausgabe am Ende: `=== FERTIG: .../build/NotizDemo.apk ===`
(vorher läuft `apksigner verify` — schlägt die Signaturprüfung fehl, bricht das Skript ab).

Voraussetzungen: build-tools ≥ 30, `platforms/android-29`, JDK 11+, `zip`.

## Installieren

```bash
adb install -r build/NotizDemo.apk
```
oder APK aufs Handy kopieren und dort öffnen („unbekannte Quellen" einmalig erlauben).

## Manuelle Test-Checkliste (Definition of Done für v1.0)

App öffnen:
- [ ] CHK001 App startet ohne Absturz, Titel „Notiz-Demo", leere Liste beim ersten Start.

US1 — Anlegen:
- [ ] CHK002 „Milch kaufen" eingeben → „Hinzufügen" → Notiz erscheint mit Datum oben, Feld wird leer.
- [ ] CHK003 Leeres Feld + „Hinzufügen" → Hinweis „Bitte erst Text eingeben.", keine Notiz.
- [ ] CHK004 Nur Leerzeichen eingeben → wie CHK003.
- [ ] CHK005 Zweite Notiz anlegen → neue steht ÜBER der ersten.

US2 — Persistenz:
- [ ] CHK006 App aus dem Verlauf schließen, neu öffnen → beide Notizen noch da.
- [ ] CHK007 (optional, adb) `notes.json` beschädigen → App startet mit leerer Liste, kein Absturz.

US3 — Löschen:
- [ ] CHK008 Notiz lange antippen → Rückfrage mit Notiztext → „Löschen" → sofort weg.
- [ ] CHK009 Neustart nach Löschen → Notiz bleibt weg.
- [ ] CHK010 Rückfrage mit „Abbrechen" → Notiz bleibt.

Datenschutz / Schlankheit:
- [ ] CHK011 Einstellungen → Apps → Notiz-Demo: Berechtigungen = keine.
- [ ] CHK012 APK-Größe ≤ 100 KB (`ls -lh build/NotizDemo.apk`).

## Ehrlicher Verifikationsstand v1.0.0

- Build + Signaturprüfung: ausgeführt auf miniedi (Ubuntu 24.04, JDK 21, build-tools 37.0.0).
- Manuelle Checkliste auf einem echten Gerät: wird mit der Eigentümerin abgenommen
  (siehe tasks.md T012) — bis dahin NICHT als „auf Gerät getestet" behaupten.
