package de.minidemo.notizen;

/**
 * Eine Notiz: Text + Erstellungszeitpunkt.
 * Bewusst unveränderlich (immutable) – einfach und sicher.
 */
public class Note {

    private final long createdAt; // Millisekunden seit 1970 (Epoch)
    private final String text;

    public Note(long createdAt, String text) {
        this.createdAt = createdAt;
        this.text = text;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public String getText() {
        return text;
    }
}
