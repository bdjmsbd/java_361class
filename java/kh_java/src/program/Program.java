package program;

public interface Program {

	void printMenu();

	void runMenu(int menu);

	void run();

	default void save(String fileName) {
	}

	default void load(String fileName) {
	}

}
