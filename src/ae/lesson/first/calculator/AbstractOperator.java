package ae.lesson.first.calculator;

abstract class AbstractOperator<Handler extends OperatorHandler> {

    String name;
    boolean hasResult = true;

    Handler handler;
    OperandReader reader;

    public AbstractOperator(String name, Handler handler, OperandReader reader) {
        this.reader = reader;
        this.name = name;
        this.handler = handler;
    }

    abstract double handle();

}
