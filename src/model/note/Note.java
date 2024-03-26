package model.note;

import model.notes.TreeNode;

import java.io.Serializable;

public class Note implements Serializable, TreeNode<Note> {
    private int id;
    private String text;

    public Note(String text) {
        id = -1;
        this.text = text;
    }

    public int getId() {return id;}

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) { this.text = text; }

    public void setId(int id) {this.id = id;}

    @Override
    public String toString() {
        return id +": " + text;
    }
}
