package ae.lesson.first.calculator;

class VoidOperator extends AbstractOperator<VoidOperator.Handler> {

    public interface Handler extends OperatorHandler {

        void handle();

    }

    public VoidOperator(String name, Handler handler, OperandReader reader) {
        super(name, handler, reader);
        hasResult = false;
    }

    public double handle() {
        this.handler.handle();
        return 0;
    }

}
