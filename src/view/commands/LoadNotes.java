package view.commands;

import view.ConsoleUI;

public class LoadNotes extends Command{

    public LoadNotes(ConsoleUI consoleUI) {
        super("Загрузить заметки", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().loadNotes();
    }
}