package view.commands;

import view.ConsoleUI;

public class DeleteNote extends Command{

    public DeleteNote(ConsoleUI consoleUI) {
        super("Удалить заметку", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().deleteNote();
    }
}