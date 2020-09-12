package Duke;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public String saveDataFormat() {
        return "T | " + (isDone? "1" : "0") + " | " + description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
