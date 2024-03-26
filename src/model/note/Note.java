package model.note;

import model.notes.TreeNode;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Note implements Serializable, TreeNode<Note> {
    private int id;
    private String header;
    private String text;
    private Date date;

    public Note(String header,String text) {
        id = -1;
        this.header = header;
        this.text = text;
        this.date = new Date();
    }

    public int getId() {return id;}

    public String getHeader() { return header; }

    public void setHeader(String header) { this.header = header; }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) { this.text = text; }

    public Date getDate() { return date; }

    public void setDate(Date date) {
        this.date = date; }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        return id +": " + df.format(date) + "\n" + header + "\n" + text;
    }
}
