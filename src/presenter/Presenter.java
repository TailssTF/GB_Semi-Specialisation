package presenter;

import model.service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void getNotes(){ view.printAnswer(service.getNotes());}

    public void createNote(String header, String text){
        service.createNote(header, text);
    }

    public void getNote(int id) {
        service.getNote(id);
    }

    public void changeNote(int id, String header, String text){
        service.changeNote(id, header, text);
    }

    public void deleteNote(int id){
        service.deleteNote(id);
    }

    public void saveNotes() {service.saveNotes();}

    public void loadNotes() {
        service.loadNotes();
        getNotes();
    }
}
