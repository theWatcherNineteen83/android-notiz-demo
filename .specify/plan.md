# Implementierungsplan: Notiz-Demo v1.0

**Branch**: `main` · **Datum**: 2026-11-22 · **Status**: umgesetzt

## Technischer Kontext
- **Sprache/Version**: Java, Quelltext-Level 8 (`javac --release 8`), gebaut mit JDK 21
- **Primäre Abhängigkeiten**: keine — nur Android-Bordmittel (`org.json`)
- **Speicherung**: JSON-Datei `notes.json` im app-privaten `filesDir`
- **Testen**: manuelle Checkliste (`quickstart.md`); automatisierte Tests = T101
- **Zielplattform**: Android 8.0+ (minSdk 26, targetSdk 29 — wie S9-Vorbild)
- **Projekttyp**: Single-Activity-App, ein Bildschirm
- **Build**: `build.sh` (aapt2 → javac → d8 → zip → zipalign → apksigner), kein Gradle
- **Einschränkungen**: APK ≤ 100 KB (EK-004), 0 Permissions (FA-005)

## Projektstruktur
```
app/src/main/
├── AndroidManifest.xml
├── java/de/minidemo/notizen/
│   ├── MainActivity.java   # UI + Interaktion (Activity)
│   ├── Note.java           # Modell (immutable)
│   └── NoteStore.java      # Persistenz (JSON laden/speichern)
└── res/
    ├── layout/activity_main.xml
    └── values/strings.xml
```

Schichtenregel: `MainActivity` → `NoteStore` → `Note`. Modelle vor Speicher vor UI.
`NoteStore` kennt kein Android-UI; nur `java.io`/`java.nio`/`org.json` (dadurch
später leicht unit-testbar, siehe T101).

## Verfassungs-Check (Constitution Check)
- Wahrhaftigkeit: Build + Signaturprüfung laufen im Skript (`apksigner verify`). ✅
- Einfachheit: 0 Bibliotheken, 0 Frameworks, 3 Klassen. ✅
- WIP=1: v1 = US1+US2 (MVP), dann US3. ✅
- Definition of Done: Build grün + Checkliste + Doku aktuell. ✅
- Privatsphäre: Manifest enthält keine `<uses-permission>`. ✅
- Deutsch: Doku/Kommentare deutsch. ✅

## Komplexitäts-Nachverfolgung
| Verstoß | Warum nötig | Einfachere Alternative abgelehnt weil |
|---|---|---|
| (keine) | — | — |

## Phasen
1. **Phase 1 Einrichtung**: Projektstruktur, `build.sh`, Manifest — erledigt (T001–T003)
2. **Phase 2 Grundlagen**: `Note`, `NoteStore` — erledigt (T004–T005)
3. **Phase 3 US1+US2 (MVP)**: UI Anlegen + Persistenz — erledigt (T006–T008)
4. **Phase 4 US3**: Löschen mit Rückfrage — erledigt (T009)
5. **Phase 5 Feinschliff**: Doku, Release — erledigt (T010–T011)
6. **Nächste Phasen**: Ideen T101+ in `tasks.md` — offen, wartet auf Eigentümerin
