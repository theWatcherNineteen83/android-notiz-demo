# E-Mail-Vorlage: Feature-Wunsch für die Notiz-Demo

Schick deine Idee **per E-Mail an Georg** — er leitet sie an Prometheus weiter,
den KI-Agenten hinter diesem Projekt. (Die Adresse von Prometheus ist bewusst
nicht öffentlich — Spamschutz. Georg kennt sie.)
Betreff: `Notiz-Demo: <kurzer Titel>`

Du musst nichts Technisches schreiben — beschreibe einfach, was du dir wünschst.
Je konkreter das Beispiel, desto besser. Vorlage zum Kopieren:

---

**Was wünsche ich mir?**
(z. B. „Ich möchte eine Notiz nachträglich ändern können.")

**Warum brauche ich das?**
(z. B. „Weil ich mich oft vertippe und die Notiz dann löschen und neu schreiben muss.")

**Beispiel / wie soll es aussehen?**
(z. B. „Wenn ich eine Notiz antippe, soll sich ein Bearbeitungsfeld öffnen.
Langer Tipp bleibt Löschen.")

**Wie wichtig ist es mir?**
(sehr wichtig / mittel / nice-to-have)

**Mein Handy / Android-Version (falls bekannt):**
(z. B. Samsung Galaxy S9, Android 10)

---

## Was dann passiert (Spec-Kit-Ablauf)

1. **Spec**: Prometheus macht aus deinem Wunsch eine User Story mit
   Akzeptanzszenarien („Gegeben … Wenn … Dann …") in `.specify/spec.md`.
2. **Plan + Tasks**: technischer Plan und Aufgabenliste entstehen.
3. **Freigabe**: Du bekommst Spec/Plan per E-Mail zurück und sagst OK
   (oder änderst etwas). Gebaut wird erst nach deinem OK.
4. **Umsetzung**: Code + Build + Test-Checkliste.
5. **Release**: Neue APK als GitHub-Release; den Link bekommst du per E-Mail
   über Georg zurück.

Du brauchst dafür **kein GitHub-Konto** — die Releases-Seite ist öffentlich
herunterladbar. Wer selbst mit einem KI-Agenten arbeiten will: einfach
`docs/spec-kit-deutsch-java.md` + den Ordner `.specify/` in den Agenten geben.
