package model.service;

import model.note.Note;
import model.notes.Notes;
import model.writer.FileHandler;

import java.util.TreeMap;

public class Service {
    private int idNote;
    private Notes<Note> notes;

    public Service() {
        notes = new Notes();
    }

    public void createNote(String text){
        Note note = new Note(text);
        notes.add(note);
        System.out.println("Заметка создана");
    }

    public String getNotes() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Заметки:\n");
        for (Note note : notes){
            stringBuilder.append(note);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void changeNote(int id, String text) {
        notes.getNote(id).setText(text);
        System.out.println("Заметка изменена");
    }

    public void deleteNote(int id) {
        notes.remove(notes.getNote(id));
        System.out.println("Заметка удалена");
    }

    public void saveNotes(){
        String filePath = "src/model/notes/data/notes.out";
        FileHandler fileHandler = new FileHandler();

        fileHandler.save(notes, filePath);
        System.out.println("Заметки сохранены");
    }

    public void loadNotes(){
        String filePath = "src/model/notes/data/notes.out";
        FileHandler fileHandler = new FileHandler();

        notes = (Notes) fileHandler.read(filePath);
        System.out.println("Заметки загружены");
    }
}
