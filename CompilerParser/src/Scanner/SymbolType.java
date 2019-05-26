package Scanner;

public enum SymbolType {

    WHITE_SPACE,
    COMMENT,
    KEYWORD,
    OPERATOR,
    CHARACTER_LITERAL,
    STRING_LITERAL,
    INTEGER_LITERAL,
    FLOATING_POINT_LITERAL,
    ID;

    public static SymbolType getByCode(int code) {
        switch (code) {
            case 1:
                return WHITE_SPACE;
            case 2:
                return COMMENT;
            case 70:
                return CHARACTER_LITERAL;
            case 71:
                return STRING_LITERAL;
            case 72:
                return INTEGER_LITERAL;
            case 73:
                return FLOATING_POINT_LITERAL;
            case 74:
                return ID;
            default:
                return 3 <= code && code <= 34 ? KEYWORD : OPERATOR;
        }//end switch-case
    }

}
