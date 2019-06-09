
##test of comments:
#######
/##/
/#########/

/#first form of multiline comment#/
/#SecondFormOfMultiLineComment#/



/#
Third form of multiline comment
#/

/##FourthForm##/        /#
                         #first line
                         #second line
                         # third line
                         # fourth line
                         #/

/##
    ##hello////
    test#test##other test
    ##test
    ##/

/#h#b/#/


extern int ext_var;
bool otherVar=false;
bool logical_expr= true or otherVar;

record SingleVar ##with zero variable it faces error
 begin
        int structureType = 1000;
   end record;

char middle_char_var = '\n';

function void test_func(int a, char b);

record MuttiVar begin
        long long_valu;
        float twosComplement = 1.2;
        double onesComplement = 12e-12;
        auto var;
end
record;

function string test1() begin
    int a;
    print(a);
end

const string str_variable;
string str_literal = "\" and \' \b hello world \t \n and \r goodbay\'";

int array_dcl[1][2 + 3 * b];
char single_dimension_array[10] = array_dcl[2][3];

function long test (char ch , float number_1, string s1, void v)
begin
    double number_2 = 3.342 * 2 + 3 ;
    String s = " hello" ;
    for(;;)begin end ##infinity loop

    MuttiVar struct;

    for(struct.var = 2;;n++)
    begin
        print(struct.var.n.name);
    end

    ##complete for loop with if and else

    for(struct.longValue=0; struct.longValue < 10; ++struct.longValue)
    begin
        if(i < 10)
        begin
            if(i++ > 5)
            begin
                print(i);
            end
            else
            begin
                bool binary = ~a | b & (C ^d);
                bool b =  (a and b or c) not d;
            end
        end
        else
          begin
               if(i-- <= 5)
                begin
                    int expr = 1;
                    expr *= -((--i)/3+5)*((i++)%3 * 5 -1 +2);
                    expr -= 4;
                    expr /= 10 - 9 - 8 %4;
                    expr += ++i;
               end
           end
           break;
    end

    int loop_var = 0;
    repeat
        begin
        continue;
         switch(loop_var) of: ##cases should have default
            begin
                case 1:
                begin
                end
                case 50:
                begin
                    break;
                end
                case 10:
                begin
                    int i = loop_var++;
                    break;
                end
                default: begin
                    print("hello");
                end
            end
         end
    until(loop_var < 2);

    if((var +1)!=2 or var == 3)
        begin
        end
    else
        begin
        if(false or (var and a) and (~a | B))
            begin
                int result = factorial(a[var + 2][var * 3 - 5][var++ / 2 % 3]);
                f2('\n');
                f2(true);
                long l = deepFunction(1,2);##looks like our functions can't take more than two parameters
            end
        else
            begin
                if(true)
                begin
                    f1("goodbay");
                end
                f1();
            end
        end

end

function void f1() begin print("hello"); end
function void f2(char c) begin
    f1();
    print("world");
end

function int factorial(int n) begin
    if(n <2)
    begin
        return 1;
    end
    return n * factorial(n-1);
end

function char deepFunction()
begin
    f2('b');
    factorial(6);
    print("end");
    return 'a';
end

const boolean is_true, isFalse = false;
long number_3 = 12312 , number_4 = number_3 , number_5;
int method_call = test( 'f' , number_2);