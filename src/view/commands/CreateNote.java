package view.commands;

import view.ConsoleUI;

public class CreateNote extends Command{

    public CreateNote(ConsoleUI consoleUI) {
        super("Создать заметку", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().createNote();
    }
}