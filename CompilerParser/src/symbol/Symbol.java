package symbol;

import symbol.descriptor.Descriptor;

import java.util.HashMap;
import java.util.Map;

public class Symbol {

    public static final int WHITE_SPACE = 1;
    public static final int COMMENT = 2;
    public static final int CONST = 3;
    public static final int RECORD = 4;
    public static final int BOOL = 5;
    public static final int CHAR = 6;
    public static final int INT = 7;
    public static final int LONG = 8;
    public static final int FLOAT = 9;
    public static final int DOUBLE = 10;
    public static final int STRING = 11;
    public static final int VOID = 12;
    public static final int TRUE = 13;
    public static final int FALSE = 14;
    public static final int EXTERN = 15;
    public static final int AUTO = 16;
    public static final int FUNCTION = 17;
    public static final int BEGIN = 18;
    public static final int END = 19;
    public static final int IF = 20;
    public static final int ELSE = 21;
    public static final int SWITCH = 22;
    public static final int OF = 23;
    public static final int CASE = 24;
    public static final int DEFAULT = 25;
    public static final int FOR = 26;
    public static final int FOR_EACH = 27;
    public static final int IN = 28;
    public static final int REPEAT = 29;
    public static final int UNTIL = 30;
    public static final int BREAK = 31;
    public static final int CONTINUE = 32;
    public static final int RETURN = 33;
    public static final int SIZEOF = 34;
    public static final int SEMI = 35;
    public static final int COL = 36;
    public static final int COMA = 37;
    public static final int DOT = 38;
    public static final int BINEGATE = 39;
    public static final int PLUS = 40;
    public static final int MINUS = 41;
    public static final int STAR = 42;
    public static final int SLASH = 43;
    public static final int PREC = 44;
    public static final int EQ = 45;
    public static final int BIAND = 46;
    public static final int BIOR = 47;
    public static final int HAT = 48;
    public static final int NOT = 49;
    public static final int AND = 50;
    public static final int OR = 51;
    public static final int LT = 52;
    public static final int GT = 53;
    public static final int CURBRACOP = 54;
    public static final int CURBRACCL = 55;
    public static final int BRACKOP = 56;
    public static final int BRACKCL = 57;
    public static final int PRANTOP = 58;
    public static final int PRANTCL = 59;
    public static final int PLUS2 = 60;
    public static final int MINUS2 = 61;
    public static final int PLUSEQ = 62;
    public static final int MINUSEQ = 63;
    public static final int STAREQ = 64;
    public static final int SLASHEQ = 65;
    public static final int NOTEQ = 66;
    public static final int EQEQ = 67;
    public static final int LTEQ = 68;
    public static final int GTEQ = 69;
    public static final int CHAR_LIT = 70;
    public static final int STR_LIT = 71;
    public static final int INT_LIT = 72;
    public static final int FLOAT_LIT = 73;
    public static final int ID = 74;

    private static final Map<String, Descriptor> SYMBOL_TABLE = new HashMap<>();

    private int code;
    private SymbolType type;

    public Symbol(int code) {
        type = SymbolType.getByCode(this.code = code);
    }

    public int getCode() {
        return code;
    }

    public SymbolType getType() {
        return type;
    }

}