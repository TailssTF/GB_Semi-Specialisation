package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;

    private MainMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start(){
        System.out.printf("Начало работы\n");
        while (work){
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            if (checkChoice(choice)){
                int choiceInt = Integer.parseInt(choice);
                menu.execute(choiceInt);
            }else errorInput();
        }
    }

    private boolean checkChoice(String choice){
        int size = menu.size();
        if (choice.matches("/[1-{size}]/")) return true;
        else return true;
    }

    private void errorInput() {
        System.out.println("Введено некорректное значение\n");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void finish() {
        scanner.close();
        System.out.println("Завершение работы");
        work = false;
    }

    public void createNote(){
        System.out.println("Введите заголовок заметки:");
        String header = scanner.nextLine();
        System.out.println("Введите текст заметки:");
        String text = scanner.nextLine();

        presenter.createNote(header, text);
    }

    public void changeNote(){
        System.out.println("Введите id заметки:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Выбранная заметка:");
        presenter.getNote(id);
        System.out.println("Введите новый заголовок заметки:");
        String header = scanner.nextLine();
        System.out.println("Введите новый текст заметки:");
        String text = scanner.nextLine();

        presenter.changeNote(id, header, text);
    }

    public void deleteNote(){
        System.out.println("Введите id заметки:");
        int id = Integer.parseInt(scanner.nextLine());

        presenter.deleteNote(id);
    }

    public void getNotes() {presenter.getNotes();}

    public void saveNotes() {presenter.saveNotes();}

    public void loadNotes() {presenter.loadNotes();}
}
