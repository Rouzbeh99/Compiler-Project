package ast.type;

import cg.Logger;

import static ast.type.FunctionType.*;

public class TypeChecker {

    private TypeChecker() {
    }

    public static Type unaryExprTypeCheck(Type t) {
        if (!isValidExprType(t))
            Logger.error("type mismatch");

        if (t == DOUBL)
            return StructureType.DOUBL;
        else if (t == FLOAT)
            return StructureType.FLOAT;
        else if (t == LONG)
            return StructureType.LONG;
        else
            return StructureType.INT;
    }

    public static Type binaryExprTypeCheck(Type t1, Type t2) {
        if (!(isValidExprType(t1) && isValidExprType(t2)))
            Logger.error("type mismatch");

        if (t1 == DOUBL || t2 == DOUBL)
            return StructureType.DOUBL;
        else if (t1 == FLOAT || t2 == FLOAT)
            return StructureType.FLOAT;
        else if (t1 == LONG || t2 == LONG)
            return StructureType.LONG;
        else
            return StructureType.INT;
    }

    public static boolean isValidExprType(Type type) {
        return type == BOOL || type == CHAR || type == INT || type == LONG || type == FLOAT || type == DOUBL;
    }

    public static boolean isValidVariableType(Type type) {
        return isValidExprType(type) || type == VariableType.STRING || type == VariableType.AUTO;
    }

    public static boolean isValidSwitchType(Type type) {
        return type == BOOL || type == CHAR || type == INT;
    }

    public static Type getAutoType(Object value) {
        if (value instanceof Double)
            return VariableType.DOUBL;
        else if (value instanceof Integer)
            return VariableType.INT;
        else if (value instanceof Character)
            return VariableType.CHAR;
        else if (value instanceof Boolean)
            return VariableType.BOOL;
        else if (value instanceof String)
            return VariableType.STRING;
        return null;
    }

}