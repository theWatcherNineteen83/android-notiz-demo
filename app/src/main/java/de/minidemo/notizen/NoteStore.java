package de.minidemo.notizen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Speichert Notizen als JSON-Datei im app-privaten Verzeichnis.
 * Nutzt nur Bordmittel (org.json ist Teil von Android) – keine externen Bibliotheken.
 *
 * Siehe .specify/contracts/notestore.md für den Vertrag dieser Klasse.
 */
public class NoteStore {

    private final File file;

    public NoteStore(File dir) {
        this.file = new File(dir, "notes.json");
    }

    /** Lädt alle Notizen. Bei fehlender oder defekter Datei: leere Liste (kein Absturz). */
    public List<Note> load() {
        List<Note> result = new ArrayList<>();
        if (!file.exists()) {
            return result;
        }
        try {
            String json = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            JSONArray arr = new JSONArray(json);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                result.add(new Note(o.getLong("createdAt"), o.getString("text")));
            }
        } catch (IOException | JSONException e) {
            // Defekte Datei bewusst ignorieren: Die Demo startet lieber leer,
            // als abzustürzen. (Verbesserungsidee: Sicherungskopie anlegen.)
            return new ArrayList<>();
        }
        return result;
    }

    /** Speichert alle Notizen (überschreibt die Datei vollständig). */
    public void save(List<Note> notes) {
        JSONArray arr = new JSONArray();
        for (Note n : notes) {
            JSONObject o = new JSONObject();
            try {
                o.put("createdAt", n.getCreatedAt());
                o.put("text", n.getText());
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
            arr.put(o);
        }
        try {
            Files.write(file.toPath(), arr.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalStateException("Speichern fehlgeschlagen", e);
        }
    }
}
