# Spec-Kit — Deutsche Version für Java-Projekte

> Ein eigenständiges, agent-taugliches Dokument. Gib diese Datei einem KI-Agenten.
> Er kann damit deine Vorgaben im Spec-Kit-Format ablegen und ausformulieren — **ohne Scripts auszuführen**.
> Quellen: Fork von github/spec-kit · Java-Ausrichtung · Wissen aus Scrum/Kanban/Prompting · OpenClaw-Regeln (Wahrhaftigkeit & Güte).

---

## 1. Was ist Spec-Kit (SDD)?

**Spec-Driven Development (SDD)** = du beschreibst ein Feature in natürlicher Sprache;
der Agent erzeugt daraus strukturierte Artefakte in festgelegter Reihenfolge:

```
Spec (Was) → Plan (Wie) → Tasks (Schritte) → Implementierung → Analyse/Konvergenz
```

Die Artefakte (alle als Markdown):
1. **spec.md**       — Die Spezifikation: User Stories, Anforderungen, Erfolgskriterien.
2. **plan.md**       — Der technische Plan: Stack, Struktur, Phasen.
3. **data-model.md** — Datenmodell: Entitäten, Felder, Beziehungen.
4. **contracts/**    — Schnittstellen-Verträge (REST-Endpunkte, Klassen-APIs).
5. **quickstart.md** — Validierungs-/Laufanleitung (kein Implementierungs-Code).
6. **tasks.md**      — Aufgabenliste, nach User Story gruppiert und priorisiert.

---

## 2. Verhaltensregeln für den Agenten (verbindlich)

Vor jeder Behauptung muss der Agent prüfen — **Wahrhaftigkeit & Güte**:

1. **Sprich wahr — oder prüfe erst.** Keine Behauptung ohne Beleg.
2. **Kein Marketing als Realität.** „verfügbar / funktioniert" nur mit Test/Beweis.
3. **KI ist Software, keine Magie.** Keine Fähigkeit behaupten, die nicht getestet wurde.
4. **Wem nützt es?** Eine Antwort soll nützen, nie schaden (Güte, Mettā).
5. **Fehler sofort zugeben**, nicht vertuschen. Kritik annehmen.
6. **Nicht handeln aus** Gier, Hass, Verwirrung oder Angst.
7. **Selbstprüfung vor jeder Antwort:** Stimmt es? Ist es belegt? Nützt es?

---

## 3. Prinzipien aus Scrum & Kanban (gelten für die Arbeitsweise)

- **Fokus:** genau EINE Aufgabe zur Zeit (weniger Multitasking).
- **Definition of Done:** Jedes Inkrement hat einen Qualitätsmaßstab (getestet, dokumentiert).
- **WIP begrenzen:** „Stop starting, start finishing." — Durchlaufzeit ≈ WIP / Durchsatz.
- **Evolutionär verbessern:** kleine Schritte, keine Revolution.
- **Regeln explizit machen:** WIP-Limits, Pull-Kriterien, Definition of Done.
- **Empirismus:** Transparenz → Überprüfung → Anpassung.

---

## 4. Ablauf im Überblick

Der Agent arbeitet in **Phasen**. Jede Phase schließt ab, bevor die nächste beginnt.

**Phase A — Spec erstellen (spec.md):**
Aus der Feature-Beschreibung eine strukturierte Spezifikation ableiten (Abschnitt 5).

**Phase B — Plan (plan.md):**
Technischen Kontext klären, Verfassung prüfen, Struktur festlegen (Abschnitt 6).

**Phase C — Aufgaben (tasks.md):**
Anforderungen in priorisierte, abhängigkeitsgeordnete Aufgaben zerlegen (Abschnitt 7).

---

## 5. Template: spec.md (Spezifikation)

### Feature-Spezifikation: [FEATURE-NAME]

**Status**: Entwurf · **Erstellt**: [DATUM]

#### Nutzerszenarien & Tests *(verpflichtend)*
User Stories als Nutzerszenarien priorisieren (P1 = kritisch). Jede Story muss **unabhängig testbar** sein (eine Story allein = ein funktionsfähiges MVP).

**User Story 1 - [Kurztitel] (Priorität: P1)**
- **Warum diese Priorität**: [Wert + Begründung]
- **Unabhängiger Test**: [Wie eigenständig testbar]
- **Akzeptanzszenarien**:
  1. **Gegeben** [Zustand], **Wenn** [Aktion], **Dann** [Ergebnis]

#### Randfälle (Edge Cases)
- Was passiert bei [Grenzbedingung]? · Wie behandelt das System [Fehlerszenario]?

#### Anforderungen *(verpflichtend)*
- **FA-001**: Das System MUSS [Fähigkeit]
- **FA-002**: Das System MUSS [Fähigkeit]
- Unklare Anforderung kennzeichnen: **FA-006**: … via [KLÄRUNG NÖTIG: …]

#### Schlüssel-Entitäten
- **[Entität]**: [Bedeutung, Attribute ohne Implementierungsdetails]

#### Erfolgskriterien *(verpflichtend, messbar, technologie-agnostisch)*
- **EK-001**: [messbare Metrik, z.B. „in unter 2 Minuten abschließbar"]

#### Annahmen
- [z.B. „Bestehendes Authentifizierungssystem wird wiederverwendet"]

**Regeln:** Fokus auf WAS und WARUM, nicht WIE. Max. 3 `[KLÄRUNG NÖTIG]`-Marker.

---

## 6. Template: plan.md (Implementierungsplan)

### Implementierungsplan: [FEATURE]

**Branch**: `[###-feature-name]` · **Datum**: [DATUM]

#### Technischer Kontext
- **Sprache/Version**: Java 21 (oder KLÄRUNG NÖTIG)
- **Primäre Abhängigkeiten**: Maven/Gradle, Spring Boot, JUnit 5
- **Speicherung**: PostgreSQL / H2 / N/A
- **Testen**: JUnit 5, Mockito, Testcontainers
- **Zielplattform**: JVM / Linux-Server / Desktop
- **Projekttyp**: Bibliothek / CLI / Web-Service / Desktop-App
- **Leistungsziele**: [z.B. 1000 req/s]
- **Einschränkungen**: [z.B. <200ms p95]

#### Projektstruktur (Java)
```
src/main/java/
├── model/      # Entitäten
├── service/    # Geschäftslogik
└── api/        # Controller/Endpunkte
src/test/java/
├── contract/   # Vertragstests
├── integration/
└── unit/
```

#### Verfassungs-Check (Constitution Check)
*GATE: vor der Recherche bestehen, nach dem Design erneut prüfen.*

#### Komplexitäts-Nachverfolgung
| Verstoß | Warum nötig | Einfachere Alternative abgelehnt weil |
|---|---|---|

---

## 7. Template: tasks.md (Aufgaben)

### Aufgaben: [FEATURE]

**Format:** `- [ ] [ID] [P?] [Story?] Beschreibung mit Dateipfad`
- **[P]** = parallelisierbar (verschiedene Dateien, keine Abhängigkeiten)
- **[Story]** = zugehörige User Story (US1, US2, …)

**Phasen:**
1. **Phase 1 Einrichtung** — Projektstruktur, Build (Maven/Gradle).
2. **Phase 2 Grundlagen** — blockierende Infrastruktur (DB, Auth, Routing).
3. **Phase 3+ je User Story** — in Prioritäts-Reihenfolge (P1 → P2 → P3).
   - Innerhalb: Tests → Modelle → Services → Endpunkte → Integration.
4. **Letzte Phase Feinschliff** — Doku, Refactoring, Security, Performance.

**Beispiel:**
```
- [ ] T001 Projektstruktur gemäß plan.md anlegen
- [ ] T005 [P] Authentifizierung in src/main/java/security/ implementieren
- [ ] T012 [P] [US1] User-Modell in src/main/java/model/User.java erstellen
- [ ] T014 [US1] UserService in src/main/java/service/UserService.java (hängt ab T012)
```

**Reihenfolge-Regeln:** Modelle vor Services · Services vor Endpunkten · Tests (falls gefordert) zuerst schreiben und scheitern lassen (TDD).

**MVP-Strategie:** Setup → Grundlagen → User Story 1 → STOPP & validieren → erst dann weitere Stories.

---

## 8. Template: Konstitution (constitution.md)

### [PROJEKTNAME] Verfassung

#### Kernprinzipien
1. **[Prinzip 1]** — [nicht verhandelbare Regel]
2. **[Prinzip 2]** — [nicht verhandelbare Regel]
3. **Test-First (NICHT VERHANDELBAR)** — TDD: Tests → scheitern → implementieren (Red-Green-Refactor).
4. **Integrationstests** — für Vertragsänderungen und service-übergreifende Kommunikation.

#### Governance
- Die Verfassung steht über allen anderen Praktiken.
- Änderungen erfordern Dokumentation + Freigabe + Migrationsplan.
**Version**: [X.Y.Z] · **Ratifiziert**: [DATUM] · **Zuletzt geändert**: [DATUM]

---

## 9. Template: Checkliste (checklist.md)

### [TYP] Checkliste: [FEATURE]
- [ ] CHK001 [Kriterium]
- [ ] CHK002 [Kriterium]

`[x]` = Kriterium geprüft und erfüllt — nicht „Implementierung fertig".

---

## 10. Qualitäts- & Konsistenzprüfung (Analyse)

Der Agent prüft nach der Aufgaben-Generierung **quer über spec.md, plan.md, tasks.md**:
- **Duplikate**, **Mehrdeutigkeiten** („schnell", „sicher" ohne Messwert), **Lücken**.
- **Verfassungs-Konflikte** = automatisch KRITISCH (nie stillschweigend ignorieren).
- Ergebnis als Tabelle: `| ID | Kategorie | Schwere | Fundort | Zusammenfassung | Empfehlung |`

**Schweregrade:** KRITISCH (verletzt Verfassung) · HOCH (widersprüchlich) · MITTEL (Begriffsklärung) · NIEDRIG (Stil).

---

## 11. Abschluss-Checklist für den Agenten

Vor Abschluss einer Arbeit:
- [ ] Artefakte vollständig (spec, plan, tasks)
- [ ] Alle `[KLÄRUNG NÖTIG]` aufgelöst (max. 3)
- [ ] Erfolgskriterien messbar und technologie-agnostisch
- [ ] Jede User Story unabhängig testbar
- [ ] Keine unbelegten Behauptungen (Wahrhaftigkeit)
- [ ] Quellen angegeben (wo Fakten belegt sind)
