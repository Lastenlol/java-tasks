package ae.lesson.first.calculator;

class BinaryOperator extends AbstractOperator<BinaryOperator.Handler> {

    public interface Handler extends OperatorHandler {

        double handle(double a, double b);

    }

    public BinaryOperator(String name, Handler handler, OperandReader reader) {
        super(name, handler, reader);
    }

    public double handle() {
        final double a = reader.readOperand("enter first operand: ");
        final double b = reader.readOperand("enter second operand: ");

        return this.handler.handle(a, b);
    }

}
