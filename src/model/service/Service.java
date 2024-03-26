package model.service;

import model.note.Note;
import model.notes.Notes;
import model.writer.FileHandler;

import java.util.Date;
import java.util.List;

public class Service {
    private int idNote;
    private Notes<Note> notes;

    public Service() {
        notes = new Notes();
    }

    public void createNote(String header, String text){
        Note note = new Note(header, text);
        notes.add(note);
        System.out.println("Заметка создана");
    }

    public String getNote(int id) {
        return notes.getNote(id).toString();
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

    public void changeNote(int id, String header, String text) {
        Note note = notes.getNote(id);
        note.setHeader(header);
        note.setText(text);
        note.setDate(new Date());
        System.out.println("Заметка изменена");
    }

    public void deleteNote(int id) {
        notes.remove(notes.getNote(id));
        System.out.println("Заметка удалена");
    }

    public void saveNotes(){
        String filePath = "src/model/notes/data/notes.json";
        FileHandler fileHandler = new FileHandler();

        fileHandler.save(notes.getNotes(), filePath);
        System.out.println("Заметки сохранены");
    }

    public void loadNotes(){
        String filePath = "src/model/notes/data/notes.json";
        FileHandler fileHandler = new FileHandler();

        notes = new Notes((List) fileHandler.read(filePath));
        System.out.println("Заметки загружены");
    }
}
