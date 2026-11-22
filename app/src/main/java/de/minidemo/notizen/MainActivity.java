package de.minidemo.notizen;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Einziger Bildschirm der Demo:
 * - oben: Eingabefeld + Button "Hinzufügen"
 * - darunter: Liste aller Notizen (neueste zuerst)
 * - langer Tipp auf eine Notiz: Löschen mit Rückfrage
 */
public class MainActivity extends Activity {

    private NoteStore store;
    private ArrayAdapter<String> adapter;
    private final List<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        store = new NoteStore(getFilesDir());
        notes.addAll(store.load());

        EditText input = findViewById(R.id.note_input);
        Button add = findViewById(R.id.note_add);
        ListView list = findViewById(R.id.note_list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        list.setAdapter(adapter);
        refresh();

        add.setOnClickListener(v -> {
            String text = input.getText().toString().trim();
            if (text.isEmpty()) {
                Toast.makeText(this, R.string.empty_note, Toast.LENGTH_SHORT).show();
                return;
            }
            notes.add(0, new Note(System.currentTimeMillis(), text));
            store.save(notes);
            input.setText("");
            refresh();
        });

        list.setOnItemLongClickListener((parent, view, position, id) -> {
            Note note = notes.get(position);
            new AlertDialog.Builder(this)
                    .setTitle(R.string.delete_title)
                    .setMessage(getString(R.string.delete_message, note.getText()))
                    .setPositiveButton(R.string.delete_yes, (dialog, which) -> {
                        notes.remove(position);
                        store.save(notes);
                        refresh();
                    })
                    .setNegativeButton(R.string.delete_no, null)
                    .show();
            return true;
        });
    }

    /** Baut die Liste neu auf: Text + Datum, neueste Notiz oben. */
    private void refresh() {
        adapter.clear();
        DateFormat fmt = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        for (Note n : notes) {
            adapter.add(n.getText() + "\n" + fmt.format(new Date(n.getCreatedAt())));
        }
        adapter.notifyDataSetChanged();
    }
}
