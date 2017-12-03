package ae.lesson.first.calculator;

import ae.util.ConsoleHelpers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Calculator implements Runnable, OperandReader {

    protected boolean isRunning = false;
    protected ArrayList<AbstractOperator> operators = new ArrayList<>();

    public Calculator() {
        addVoidOperator("help", this::printAvailableOperators);
        addVoidOperator("exit", () -> isRunning = false);

        addUnaryOperator("±", a -> -a);
        addBinaryOperator("+", (a, b) -> a + b);
        addBinaryOperator("-", (a, b) -> a - b);
        addBinaryOperator("*", (a, b) -> a * b);
        addBinaryOperator("/", (a, b) -> a / b);
    }

    public void addVoidOperator(String name, VoidOperator.Handler handler) {
        operators.add(new VoidOperator(name, handler, this));
    }

    public void addUnaryOperator(String name, UnaryOperator.Handler handler) {
        operators.add(new UnaryOperator(name, handler, this));
    }

    public void addBinaryOperator(String name, BinaryOperator.Handler handler) {
        operators.add(new BinaryOperator(name, handler, this));
    }

    public double readOperand(String msg) {
        return ConsoleHelpers.readDouble(msg);
    }

    public void printAvailableOperators() {
        System.out.println("Available operators: " + operators.stream().map(o -> o.name).collect(Collectors.joining(", ")));
    }

    protected void handleInput() {
        final String operatorName = ConsoleHelpers.readNonEmptyString("Enter the operator: ");
        final Optional<AbstractOperator> wrappedOperator = operators.stream().filter(o -> o.name.equals(operatorName)).findFirst();

        if (!wrappedOperator.isPresent()) {
            System.out.println("Unrecognized operator");
            handleInput();
        } else {
            final AbstractOperator operator = wrappedOperator.get();

            if (operator.hasResult) System.out.println("Result = " + operator.handle());
            else operator.handle();
        }
    }

    public void run() {
        printAvailableOperators();

        isRunning = true;
        while (isRunning) {
            handleInput();
        }
    }
}
