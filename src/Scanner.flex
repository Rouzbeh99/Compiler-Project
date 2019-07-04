%%

//Scanner class attributes
%class Scanner
%unicode
%line
%column
%public

//Scanner function definitions are compatible with cup
%cupsym Symbol
%cup
//The following comments are the equivalent of %cup
//%implements java_cup.runtime.Scanner
//%function next_token
//%type java_cup.runtime.Symbol
//%eofval{
//return new java_cup.runtime.Symbol(<CUPSYM>.EOF);
//%eofval}
//%eofclose

//Scanner class code includings
%{

    public int ICV;
    public double RCV;
    public StringBuilder string = new StringBuilder();

    private Symbol token(int code){
//        System.out.println(yytext());//debug
        return new Symbol(code, yytext());
    }

    private void parseRCV(String text){
        int index = text.indexOf("e");
        if(index > 0){
            int base = Integer.parseInt(text.substring(0, index));
            int exp = Integer.parseInt(text.substring(index + 1));
            RCV = base * Math.pow(10, exp);
        }else if(index < 0)
            RCV = Double.parseDouble(text);
        else
            throw new NumberFormatException();
    }

%}


//Micros
LineTerminator = \r|\n|\r\n
EndOfLineComment = ##[^\n\r]+{LineTerminator}
MultipleLineComment = \/#[^#]*#+([^\/#][^#]*#+)?*\/
//MultipleLineComment = \/#((#[^\/])+ | [^#]+)*#\/


SimpleCharacter = [^\n\r\\]
SpecialCharacter = \\[abfnrtv\\\'\"]
Character = {SimpleCharacter} | {SpecialCharacter}
CharacterLiteral = \'{Character}\'

StringLiteral = \"{Character}*\"

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
"foreach" { return token(Symbol.FOREACH); }
"in" { return token(Symbol.IN); }
"repeat" { return token(Symbol.REPEAT); }
"until" { return token(Symbol.UNTIL); }
"break" { return token(Symbol.BREAK); }
"continue" { return token(Symbol.CONTINUE); }
"return" { return token(Symbol.RETURN); }

/*other keywords*/
"sizeof" { return token(Symbol.SIZEOF); }

/*operators*/
";" { return token(Symbol.SEMI); }
":" { return token(Symbol.COL); }
"," { return token(Symbol.COMA); }
"." { return token(Symbol.DOT); }
"~" { return token(Symbol.BINOT); }
"+" { return token(Symbol.PLUS); }
"-" { return token(Symbol.MINUS); }
"*" { return token(Symbol.MULT); }
"/" { return token(Symbol.DIVIDE); }
"%" { return token(Symbol.MOD); }
"=" { return token(Symbol.ASSIGN); }
"&" { return token(Symbol.BIAND); }
"|" { return token(Symbol.BIOR); }
"^" { return token(Symbol.BIEXOR); }
"not" { return token(Symbol.NOT); }
"and" { return token(Symbol.AND); }
"or" { return token(Symbol.OR); }
"<" { return token(Symbol.LT); }
">" { return token(Symbol.GT); }
"[" { return token(Symbol.BRACKOP); }
"]" { return token(Symbol.BRACKCL); }
"(" { return token(Symbol.PRANTOP); }
")" { return token(Symbol.PRANTCL); }
"++" { return token(Symbol.PREFPLUS2); }
"--" { return token(Symbol.PREFMINUS2); }
"+=" { return token(Symbol.PLUSASSIGN); }
"-=" { return token(Symbol.MINUSASSIGN); }
"*=" { return token(Symbol.MULTASSIGN); }
"/=" { return token(Symbol.DIVASSIGN); }
"!=" { return token(Symbol.NOTEQ); }
"==" { return token(Symbol.EQEQ); }
"<=" { return token(Symbol.LTEQ); }
">=" { return token(Symbol.GTEQ); }

/*character literal*/
{CharacterLiteral} { string.setLength(0); string.append(yytext()); return token(Symbol.CHAR_LIT); }

/*string literals*/
{StringLiteral} { string.setLength(0); string.append(yytext()); return token(Symbol.STR_LIT); }

/*integer literals*/
{IntegerLiteral} { ICV = Integer.parseInt(yytext()); return token(Symbol.INT_LIT); }

/*floating point literals*/
{FloatingPointLiteral} { parseRCV(yytext()); return token(Symbol.FLOAT_LIT); }

/*identifiers*/
{Identifier} { return token(Symbol.ID); }

}//end YYINITIAL