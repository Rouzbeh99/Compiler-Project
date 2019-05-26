import symbol.*;

%%

//Scanner class attributes
%class Scanner
%unicode
%line
%column
%public

//Scanner function definitions
%function scan
%type Symbol


//Scanner class code includings
%{

    public int ICV;
    public double RCV;
    public StringBuilder string = new StringBuilder();

    private Symbol token(int code){
        return new Symbol(code, yytext());
    }

    private void generateText(String text){
        StringBuilder temp = new StringBuilder(text);
        string.setLength(0); string.append(temp);
    }

    private void parseRCV(String text){
        int index = text.indexOf("e");
        if(index > 0){
            int base = Integer.parseInt(text.substring(0, index));
            int exp = Integer.parseInt(text.substring(index));
            RCV = base * Math.pow(10, exp);
        }else
            RCV = Double.parseDouble(text);
    }

%}


//Micros
LineTerminator = \r|\n|\r\n
EndOfLineComment = ##[^\n\r]+{LineTerminator}
MultipleLineComment = \/#((#[^\/])+ | [^#]+)*#\/


SimpleCharacter = [^\\]
SpecialCharacter = \\[abfnrtv\\\'\"]
Character = {SimpleCharacter} | {SpecialCharacter}
CharacterLiteral = \'{Character}\'

StringLiteral = \"{Character}+\"

IntegerLiteral = [1-9]\d*

DecimalFloatingPointAfterDot = \.\d+
DecimalFloatingPointBeforeAfterDot = \d+\.\d*
DecimalFloatingPointSicentific = e(\+ | -)\d+
FloatingPointLiteral = (({DecimalFloatingPointAfterDot} | {DecimalFloatingPointBeforeAfterDot}){DecimalFloatingPointSicentific}?) | ({IntegerLiteral}{DecimalFloatingPointSicentific})

Identifier = [_\w][_\w\d]*


//State declarations
%state ENDOFLINECOMMENT
%state MULTIPLELINECOMMENT
%state STRING

%%


<YYINITIAL> {

/*white space*/
" " {}
"\t" {}
{LineTerminator} {}

/*comments*/
{EndOfLineComment} {}
{MultipleLineComment} {}

/*type and variable keywords*/
"const" { return token(Symbol.CONST); }
"record" { return token(Symbol.RECORD); }
"bool" { return token(Symbol.BOOL); }
"char" { return token(Symbol.CHAR); }
"int" { return token(Symbol.INT); }
"long" { return token(Symbol.LONG); }
"float" { return token(Symbol.FLOAT); }
"double" { return token(Symbol.DOUBLE); }
"string" { return token(Symbol.STRING); }
"void" { return token(Symbol.VOID); }
"true" { return token(Symbol.TRUE); }
"false" { return token(Symbol.FALSE); }
"extern" { return token(Symbol.EXTERN); }
"auto" { return token(Symbol.AUTO); }
"function" { return token(Symbol.FUNCTION); }

/*flow control keywords*/
"begin" { return token(Symbol.BEGIN); }
"end" { return token(Symbol.END); }
"if" { return token(Symbol.IF); }
"else" { return token(Symbol.ELSE); }
"switch" { return token(Symbol.SWITCH); }
"of" { return token(Symbol.OF); }
"case" { return token(Symbol.CASE); }
"default" { return token(Symbol.DEFAULT); }
"for" { return token(Symbol.FOR); }
"foreach" { return token(Symbol.FOR_EACH); }
"in" { return token(Symbol.IN); }
"repeat" { return token(Symbol.REPEAT); }
"until" { return token(Symbol.UNTIL); }
"break" { return token(Symbol.BREAK); }
"continue" { return token(Symbol.CONTINUE); }
"return" { return token(Symbol.RETURN); }

/*other keywords*/
"sizeof" { return new Symbol(Symbol.SIZEOF); }

/*operators*/
";" { return token(Symbol.SEMI); }
":" { return token(Symbol.COL); }
"," { return token(Symbol.COMA); }
"." { return token(Symbol.DOT); }
"~" { return token(Symbol.BINEGATE); }
"+" { return token(Symbol.PLUS); }
"-" { return token(Symbol.MINUS); }
"*" { return token(Symbol.STAR); }
"/" { return token(Symbol.SLASH); }
"%" { return token(Symbol.PREC); }
"=" { return token(Symbol.EQ); }
"&" { return token(Symbol.BIAND); }
"|" { return token(Symbol.BIOR); }
"^" { return token(Symbol.HAT); }
"not" { return token(Symbol.NOT); }
"and" { return token(Symbol.AND); }
"or" { return token(Symbol.OR); }
"<" { return token(Symbol.LT); }
">" { return token(Symbol.GT); }
"{" { return token(Symbol.CURBRACOP); }
"}" { return token(Symbol.CURBRACCL); }
"[" { return token(Symbol.BRACKOP); }
"]" { return token(Symbol.BRACKCL); }
"(" { return token(Symbol.PRANTOP); }
")" { return token(Symbol.PRANTCL); }
"++" { return token(Symbol.PLUS2); }
"--" { return token(Symbol.MINUS2); }
"+=" { return token(Symbol.PLUSEQ); }
"-=" { return token(Symbol.MINUSEQ); }
"*=" { return token(Symbol.STAREQ); }
"/=" { return token(Symbol.SLASHEQ); }
"!=" { return token(Symbol.NOTEQ); }
"==" { return token(Symbol.EQEQ); }
"<=" { return token(Symbol.LTEQ); }
">=" { return token(Symbol.GTEQ); }

/*character literal*/
{CharacterLiteral} { generateText(yytext()); return token(Symbol.CHAR_LIT); }

/*string literals*/
{StringLiteral} { generateText(yytext()); return token(Symbol.STR_LIT); }

/*integer literals*/
{IntegerLiteral} { ICV = Integer.parseInt(yytext()); return token(Symbol.INT_LIT); }

/*floating point literals*/
{FloatingPointLiteral} { parseRCV(yytext()); return token(Symbol.FLOAT_LIT); }

/*identifiers*/
{Identifier} { return token(Symbol.ID); }

}//end YYINITIAL