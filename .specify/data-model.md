# Datenmodell: Notiz-Demo

## Entität: Note

| Feld | Typ | Bedeutung | Regeln |
|---|---|---|---|
| `text` | String | Inhalt der Notiz | nicht leer (nach Trim), keine Längenbegrenzung in v1 |
| `createdAt` | long | Erstellungszeitpunkt, ms seit Epoch | wird beim Anlegen gesetzt, unveränderlich |

- Eine Note ist **immutable** (keine Änderung nach Anlegen — „Bearbeiten" wäre
  eine neue User Story, siehe T102 in `tasks.md`).
- Keine IDs in v1: Die Liste ist klein, Löschen passiert über die Position.
  Sobald Bearbeiten/Sortieren dazukommt, sollte eine `id` (z. B. UUID) eingeführt
  werden — dann Migrationsplan in `plan.md` ergänzen.

## Persistenz: notes.json

Speicherort: app-privates `filesDir` (kein Zugriff für andere Apps, keine Permission nötig).

Format: JSON-Array, neueste Notiz zuerst:

```json
[
  { "createdAt": 1763812800000, "text": "Milch kaufen" },
  { "createdAt": 1763809200000, "text": "Reifen aufpumpen" }
]
```

- Schreiben: vollständiges Überschreiben der Datei (bei Demo-Größenordnung okay).
- Lesen: fehlende/defekte Datei → leere Liste, kein Absturz (US2.2).
- Kein Schema-Versionierung in v1; bei Modelländerungen (z. B. `id`, Kategorien)
  Migration mitdenken und hier dokumentieren.
