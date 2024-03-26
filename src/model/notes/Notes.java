package model.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Notes<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private int noteId;
    private List<E> notes;

    public Notes(List<E> notes) {this.notes = notes;}

    public Notes() {this(new ArrayList<>());}

    public boolean add(E note) {
        if (note == null) return false;
        if (!notes.contains(note)) {
            notes.add(note);
            note.setId(noteId++);
            return true;
        }
        return false;
    }

    private E getById(int id) {
        for (E note : notes){
            if (note.getId() == id) return note;
        }
        return null;
    }

    public E getNote(int id) {
        return getById(id);
    }

    @Override
    public Iterator<E> iterator() {
        return new NoteIterator<>(notes);
    }

    public void remove(E note) {
        notes.remove(note);
    }
}
