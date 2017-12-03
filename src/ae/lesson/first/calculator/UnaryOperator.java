package ae.lesson.first.calculator;

class UnaryOperator extends AbstractOperator<UnaryOperator.Handler> {

    public interface Handler extends OperatorHandler {

        double handle(double a);

    }

    public UnaryOperator(String name, Handler handler, OperandReader reader) {
        super(name, handler, reader);
    }

    public double handle() {
        final double a = reader.readOperand("enter operand: ");

        return this.handler.handle(a);
    }

}
