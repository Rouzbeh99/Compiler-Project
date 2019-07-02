import Nodes.DCL.Type;
import Nodes.ExpressionNodes.Block;
import Nodes.ExpressionNodes.*;
import Nodes.Operations.Binary.*;
import Nodes.DCL.VariableNode;

import java.util.concurrent.locks.Condition;

public class Main {

    public static void main(String[] args) {

    Block mainBlock = new Block();
    VariableCall var = new VariableCall("sgd");
    Add add = new Add
            (new Div(new IntConstNode(23),var),new IntConstNode(34));
    ExpressionNode cond = new GreaterThan(new VariableCall("f"),new IntConstNode(54));
    AssignmentNode assignment = new DirectAssignment("sdd",new IntConstNode(1));
    Block ifBlock = new Block();
    ifBlock.addToBlock(add);
    ifBlock.addToBlock(assignment);
    IFNode ifNode = new IFNode(cond,ifBlock,ifBlock);
    Block loopBlock = new Block();
    loopBlock.addToBlock(ifNode);
    mainBlock.addToBlock(new ForLoop(cond,loopBlock));
    mainBlock.compile();

    }

}
