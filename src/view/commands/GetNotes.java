package view.commands;

import view.ConsoleUI;

public class GetNotes extends Command{

    public GetNotes(ConsoleUI consoleUI) {
        super("Показать заметки", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().getNotes();
    }
}