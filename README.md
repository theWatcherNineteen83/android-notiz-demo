# Notiz-Demo 📝 — deine erste eigene Android-App

Eine winzige, funktionierende Android-App als Startpunkt: **Notizen anlegen, anzeigen,
löschen** — mehr nicht. Sie ist bewusst einfach gehalten (3 Java-Klassen, keine
externen Bibliotheken, kein Gradle), damit du sie vollständig verstehen und mit der
**Spec-Kit-Methode** Schritt für Schritt zu *deiner* App ausbauen kannst.

Technisches Vorbild war die „S9 Bridge"-App für ein Samsung Galaxy S9: gleiche
schlanke Bauweise (reines Java + Android-SDK-Werkzeuge), gleiche Mindestversion
Android 8.0 — läuft also auch auf einem Galaxy S9.

## Schnellstart (ohne Programmierkenntnisse)

1. Lade die aktuelle APK herunter: [Releases](../../releases) → `NotizDemo.apk`
2. Öffne die Datei auf deinem Android-Handy.
3. Erlaube ggf. „Installation aus unbekannten Quellen" (nur für diese eine Datei).
4. Fertig: Die App heißt **Notiz-Demo** und liegt im App-Drawer.

**Datenschutz:** Die App hat *keinerlei* Berechtigungen — kein Internet, kein Speicher,
keine Kamera. Alle Notizen bleiben ausschließlich auf deinem Gerät.

## Was die App kann (Version 1.0)

- Notiz eintippen und mit „Hinzufügen" speichern (neueste zuerst)
- Notizen bleiben nach App-Neustart erhalten (lokale JSON-Datei)
- Langer Tipp auf eine Notiz → Löschen mit Rückfrage
- Leere Eingaben werden abgefangen (freundlicher Hinweis statt leerer Notiz)

## Projektstruktur

```
android-notiz-demo/
├── app/src/main/
│   ├── AndroidManifest.xml      # App-Grunddaten (keine Permissions!)
│   ├── java/de/minidemo/notizen/
│   │   ├── MainActivity.java    # Bildschirm: Eingabe, Liste, Löschen
│   │   ├── Note.java            # Datenmodell: Text + Zeitpunkt
│   │   └── NoteStore.java       # Speichern/Laden als JSON
│   └── res/                     # Layout + Texte (deutsch)
├── build.sh                     # Baut die APK ohne Gradle
├── .specify/                    # Spec-Kit-Artefakte (das Herzstück!)
│   ├── constitution.md          # Spielregeln des Projekts
│   ├── spec.md                  # WAS soll die App können (User Stories)
│   ├── plan.md                  # WIE wird es gebaut
│   ├── data-model.md            # Datenmodell
│   ├── contracts/notestore.md   # Vertrag der Speicher-Klasse
│   ├── quickstart.md            # Bauen + manuelle Test-Checkliste
│   └── tasks.md                 # Aufgaben: erledigte + Ideen für dich
└── docs/
    ├── spec-kit-deutsch-java.md # Die Spec-Kit-Anleitung (deutsch)
    └── feature-wunsch-vorlage.md # E-Mail-Vorlage für Änderungswünsche
```

## Selber bauen (für Entwickler:innen)

Voraussetzungen: Android SDK (build-tools ≥ 30, `platforms/android-29`), JDK 11+, `zip`.

```bash
export ANDROID_HOME=/pfad/zum/android-sdk   # Standard: ~/android-sdk
./build.sh
# Ergebnis: build/NotizDemo.apk (debug-signiert, direkt installierbar)
```

Kein Gradle, kein Android Studio nötig — das Skript nutzt direkt `aapt2`, `javac`,
`d8`, `zipalign` und `apksigner`. Jeder Schritt ist im Skript kommentiert.

## Weiterentwickeln mit Spec-Kit 🧭

**Spec-Driven Development:** Du beschreibst in natürlicher Sprache, WAS du willst —
ein KI-Agent (oder Mensch) macht daraus zuerst eine Spezifikation, dann einen Plan,
dann Aufgaben, und erst dann Code. So bleibt die App immer nachvollziehbar.

Der Ablauf für jedes neue Feature:

```
Deine Idee (E-Mail) → spec.md ergänzen → plan.md → tasks.md → Code → neue APK
```

1. Lies `docs/spec-kit-deutsch-java.md` (die komplette Anleitung, deutsch).
2. Schau in `.specify/tasks.md` — dort liegen schon **Ideen für Ausbaustufen**
   (z. B. Notizen bearbeiten, Suche, Kategorien, Export, Dark Mode).
3. Such dir EINE Sache aus („Stop starting, start finishing").
4. Du kannst das selbst mit einem KI-Agenten machen: Gib ihm die Datei
   `docs/spec-kit-deutsch-java.md` plus den Ordner `.specify/` — jeder gute Agent
   kann damit nach den Regeln arbeiten.
5. **Oder lass es bauen** — schick deinen Wunsch **per E-Mail an Georg**
   (seine Adresse hast du ja). Er leitet ihn an Prometheus weiter, den KI-Agenten
   hinter diesem Projekt.
   Betreff: `Notiz-Demo: <dein Wunsch>` · Vorlage: `docs/feature-wunsch-vorlage.md`

   Prometheus antwortet mit Spec/Plan/Tasks zur Freigabe, baut es nach dem OK und
   veröffentlicht die neue APK als GitHub-Release. Die Antwort kommt über Georg
   zurück. Absender-Adressen bleiben bewusst unveröffentlicht (Spamschutz);
   du brauchst kein GitHub-Konto.

## Technische Eckdaten

| Punkt | Wert |
|---|---|
| Sprache | Java (Quelltext-Level 8), keine externen Bibliotheken |
| Mindest-Android | 8.0 (API 26) — u. a. Samsung Galaxy S9 |
| Ziel-SDK | 29 (bewusst, wie das S9-Vorbild; Demo zum Selber-Installieren, nicht für den Play Store) |
| Build | `build.sh` mit Android-SDK-Werkzeugen, kein Gradle |
| Speicherung | JSON-Datei im app-privaten Bereich (`notes.json`) |
| Berechtigungen | keine |

## Lizenz

MIT — mach damit, was du willst. Viel Spaß beim Ausbauen! 🔥
