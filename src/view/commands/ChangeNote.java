package view.commands;

import view.ConsoleUI;

public class ChangeNote extends Command{

    public ChangeNote(ConsoleUI consoleUI) {
        super("Редактировать заметку", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().changeNote();
    }
}