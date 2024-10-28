package Commands;

import Menu.Menu;

public class GoToMenuCommand extends Command {

    private Menu menu;
    public GoToMenuCommand(String title, Menu menu) {
        super(title);
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.startMenu();
    }
}
