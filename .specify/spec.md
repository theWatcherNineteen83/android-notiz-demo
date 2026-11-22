# Feature-Spezifikation: Notiz-Demo v1.0

**Status**: Implementiert (v1.0.0) · **Erstellt**: 2026-11-22

## Nutzerszenarien & Tests

### User Story 1 — Notiz anlegen (Priorität: P1)
- **Warum diese Priorität**: Kernwert der App — ohne Anlegen keine Notiz-App.
- **Unabhängiger Test**: App öffnen, Text eingeben, „Hinzufügen" tippen → Notiz
  erscheint sofort in der Liste.
- **Akzeptanzszenarien**:
  1. **Gegeben** die App ist offen, **Wenn** ich „Milch kaufen" eintippe und
     „Hinzufügen" drücke, **Dann** erscheint „Milch kaufen" mit Datum oben in der
     Liste und das Eingabefeld wird leer.
  2. **Gegeben** das Eingabefeld ist leer (oder nur Leerzeichen), **Wenn** ich
     „Hinzufügen" drücke, **Dann** erscheint ein Hinweis „Bitte erst Text eingeben."
     und es wird keine Notiz angelegt.

### User Story 2 — Notizen bleiben erhalten (Priorität: P1)
- **Warum diese Priorität**: Notizen, die verschwinden, sind wertlos.
- **Unabhängiger Test**: Notiz anlegen, App vollständig schließen und neu öffnen →
  Notiz ist noch da.
- **Akzeptanzszenarien**:
  1. **Gegeben** ich habe eine Notiz angelegt, **Wenn** ich die App schließe und
     neu starte, **Dann** ist die Notiz unverändert in der Liste.
  2. **Gegeben** die Speicherdatei ist defekt, **Wenn** die App startet, **Dann**
     startet sie mit leerer Liste statt abzustürzen.

### User Story 3 — Notiz löschen (Priorität: P2)
- **Warum diese Priorität**: Aufräumen können — wichtig, aber die App ist auch
  ohne Löschen schon nutzbar (MVP = US1 + US2).
- **Unabhängiger Test**: Lange auf eine Notiz tippen → Rückfrage → Löschen →
  Notiz ist weg und bleibt nach Neustart weg.
- **Akzeptanzszenarien**:
  1. **Gegeben** eine Notiz in der Liste, **Wenn** ich sie lange antippe und
     „Löschen" bestätige, **Dann** ist sie sofort weg und nach Neustart noch weg.
  2. **Gegeben** die Lösch-Rückfrage, **Wenn** ich „Abbrechen" tippe, **Dann**
     bleibt die Notiz unverändert.

## Randfälle (Edge Cases)
- Leere/Whitespace-Eingabe → Hinweis, keine Notiz (US1.2).
- Defekte `notes.json` → leere Liste, kein Absturz (US2.2).
- Sehr lange Notiz → wird gespeichert und umbricht in der Liste (kein Limit in v1;
  bewusst einfach gehalten).
- Mehrere Notizen → neueste steht oben.

## Anforderungen
- **FA-001**: Das System MUSS Notizen als Text mit Erstellungszeitpunkt speichern.
- **FA-002**: Das System MUSS Notizen lokal auf dem Gerät persistieren (JSON-Datei
  im app-privaten Bereich).
- **FA-003**: Das System MUSS leere Eingaben abweisen und einen Hinweis zeigen.
- **FA-004**: Das System MUSS Notizen mit Rückfrage löschbar machen (langer Tipp).
- **FA-005**: Das System MUSS ohne jegliche Android-Berechtigung auskommen und
  offline funktionieren.
- **FA-006**: Das System MUSS auf Android 8.0+ (API 26) laufen, u. a. Galaxy S9.

## Schlüssel-Entitäten
- **Note**: Text + Erstellungszeitpunkt. Details: `data-model.md`.

## Erfolgskriterien (messbar, technologie-agnostisch)
- **EK-001**: Eine Notiz anzulegen dauert ≤ 10 Sekunden (App offen → gespeichert).
- **EK-002**: 100 % der Notizen überleben einen App-Neustart (Stichprobe: 10 Notizen).
- **EK-003**: Die App benötigt 0 Berechtigungen (prüfbar in den Android-Einstellungen).
- **EK-004**: Die APK ist ≤ 100 KB groß (Schlankheits-Beweis der Demo).

## Annahmen
- Einzige Nutzerin ist die Eigentümerin; kein Login, keine Mehrbenutzerfähigkeit.
- Notizen sind kurz (Einkaufszettel-Größe); keine Anhänge/Bilder in v1.
- Installation per Sideload (APK), nicht über den Play Store.
