# Vertrag: NoteStore

Klasse: `de.minidemo.notizen.NoteStore` · Quelle: `app/src/main/java/de/minidemo/notizen/NoteStore.java`

## Konstruktor

```java
NoteStore(File dir)
```
- `dir`: app-privates Verzeichnis (in der App: `getFilesDir()`).
- Die Datei heißt immer `notes.json` in diesem Verzeichnis.

## Methoden

### `List<Note> load()`
- Liefert alle gespeicherten Notizen in Dateireihenfolge (neueste zuerst).
- Datei existiert nicht → leere Liste.
- Datei defekt (kein JSON / falsche Felder / Lesefehler) → leere Liste, **kein Absturz**.
- Verändert die Datei nicht.

### `void save(List<Note> notes)`
- Schreibt die komplette Liste als JSON-Array (Format: `data-model.md`).
- Überschreibt die Datei vollständig; Reihenfolge bleibt erhalten.
- Bei Schreibfehler: `IllegalStateException` (darf in der UI nicht unbehandelt bleiben).

## Zusagen (Contracts)
1. `load()` nach `save(list)` liefert inhaltlich dieselben Notizen (Round-Trip).
2. Beide Methoden nutzen nur `java.io`, `java.nio`, `org.json` — kein Android-UI,
   dadurch JVM-unit-testbar (Ausbaustufe T101).
3. Es werden niemals Daten außerhalb des übergebenen Verzeichnisses geschrieben.
