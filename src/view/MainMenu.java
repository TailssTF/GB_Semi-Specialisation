package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new CreateNote(consoleUI));
        commandList.add(new GetNotes(consoleUI));
        commandList.add(new ChangeNote(consoleUI));
        commandList.add(new DeleteNote(consoleUI));
        commandList.add(new SaveNotes(consoleUI));
        commandList.add(new LoadNotes(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");

        for (int i = 0; i < commandList.size(); i++){
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int numCommand) {
        commandList.get(numCommand-1).execute();
    }

    public int size(){
        return commandList.size();
    }
}
