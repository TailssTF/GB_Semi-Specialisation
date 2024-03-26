package view.commands;

import view.ConsoleUI;

public class SaveNotes extends Command{

    public SaveNotes(ConsoleUI consoleUI) {
        super("Сохранить заметки", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().saveNotes();
    }
}