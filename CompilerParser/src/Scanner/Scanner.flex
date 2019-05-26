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

    int ICV;
    double RCV;
    StringBuilder string = new StringBuilder();

    private void generateText(String text){
        StringBuilder temp = new StringBuilder(text);
        temp.deleteCharAt(0);
        temp.deleteCharAt(temp.length()-1);
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
"const" { return new Symbol(Symbol.CONST); }
"record" { return new Symbol(Symbol.RECORD); }
"bool" { return new Symbol(Symbol.BOOL); }
"char" { return new Symbol(Symbol.CHAR); }
"int" { return new Symbol(Symbol.INT); }
"long" { return new Symbol(Symbol.LONG); }
"float" { return new Symbol(Symbol.FLOAT); }
"double" { return new Symbol(Symbol.DOUBLE); }
"string" { return new Symbol(Symbol.STRING); }
"void" { return new Symbol(Symbol.VOID); }
"true" { return new Symbol(Symbol.TRUE); }
"false" { return new Symbol(Symbol.FALSE); }
"extern" { return new Symbol(Symbol.EXTERN); }
"auto" { return new Symbol(Symbol.AUTO); }
"function" { return new Symbol(Symbol.FUNCTION); }

/*flow control keywords*/
"begin" { return new Symbol(Symbol.BEGIN); }
"end" { return new Symbol(Symbol.END); }
"if" { return new Symbol(Symbol.IF); }
"else" { return new Symbol(Symbol.ELSE); }
"switch" { return new Symbol(Symbol.SWITCH); }
"of" { return new Symbol(Symbol.OF); }
"case" { return new Symbol(Symbol.CASE); }
"default" { return new Symbol(Symbol.DEFAULT); }
"for" { return new Symbol(Symbol.FOR); }
"foreach" { return new Symbol(Symbol.FOR_EACH); }
"in" { return new Symbol(Symbol.IN); }
"repeat" { return new Symbol(Symbol.REPEAT); }
"until" { return new Symbol(Symbol.UNTIL); }
"break" { return new Symbol(Symbol.BREAK); }
"continue" { return new Symbol(Symbol.CONTINUE); }
"return" { return new Symbol(Symbol.RETURN); }

/*other keywords*/
"sizeof" { return new Symbol(Symbol.SIZEOF); }

/*operators*/
";" { return new Symbol(Symbol.SEMI); }
":" { return new Symbol(Symbol.COL); }
"," { return new Symbol(Symbol.COMA); }
"." { return new Symbol(Symbol.DOT); }
"~" { return new Symbol(Symbol.BINEGATE); }
"+" { return new Symbol(Symbol.PLUS); }
"-" { return new Symbol(Symbol.MINUS); }
"*" { return new Symbol(Symbol.STAR); }
"/" { return new Symbol(Symbol.SLASH); }
"%" { return new Symbol(Symbol.PREC); }
"=" { return new Symbol(Symbol.EQ); }
"&" { return new Symbol(Symbol.BIAND); }
"|" { return new Symbol(Symbol.BIOR); }
"^" { return new Symbol(Symbol.HAT); }
"not" { return new Symbol(Symbol.NOT); }
"and" { return new Symbol(Symbol.AND); }
"or" { return new Symbol(Symbol.OR); }
"<" { return new Symbol(Symbol.LT); }
">" { return new Symbol(Symbol.GT); }
"{" { return new Symbol(Symbol.CURBRACOP); }
"}" { return new Symbol(Symbol.CURBRACCL); }
"[" { return new Symbol(Symbol.BRACKOP); }
"]" { return new Symbol(Symbol.BRACKCL); }
"(" { return new Symbol(Symbol.PRANTOP); }
")" { return new Symbol(Symbol.PRANTCL); }
"++" { return new Symbol(Symbol.PLUS2); }
"--" { return new Symbol(Symbol.MINUS2); }
"+=" { return new Symbol(Symbol.PLUSEQ); }
"-=" { return new Symbol(Symbol.MINUSEQ); }
"*=" { return new Symbol(Symbol.STAREQ); }
"/=" { return new Symbol(Symbol.SLASHEQ); }
"!=" { return new Symbol(Symbol.NOTEQ); }
"==" { return new Symbol(Symbol.EQEQ); }
"<=" { return new Symbol(Symbol.LTEQ); }
">=" { return new Symbol(Symbol.GTEQ); }

/*character literal*/
{CharacterLiteral} { generateText(yytext()); return new Symbol(Symbol.CHAR_LIT); }

/*string literals*/
{StringLiteral} { generateText(yytext()); return new Symbol(Symbol.STR_LIT); }

/*integer literals*/
{IntegerLiteral} { ICV = Integer.parseInt(yytext()); return new Symbol(Symbol.INT_LIT); }

/*floating point literals*/
{FloatingPointLiteral} { parseRCV(yytext()); return new Symbol(Symbol.FLOAT_LIT); }

/*identifiers*/
{Identifier} { return new Symbol(Symbol.ID); }

}//end YYINITIAL