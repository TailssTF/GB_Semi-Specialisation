package model.notes;

import java.util.Iterator;
import java.util.List;

public class NoteIterator<E extends TreeNode> implements Iterator<E> {
    private int index;
    private List<E> notes;
    public NoteIterator(List<E> notes) {
        this.notes = notes;
    }

    @Override
    public boolean hasNext() {
        return notes.size() > index;
    }

    @Override
    public E next() {
        return notes.get(index++);
    }
}
