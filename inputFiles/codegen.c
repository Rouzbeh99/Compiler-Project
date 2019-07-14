record Ali begin
    bool boool = true;
    const int test = false;
    double d_value = .2123;
    float f = 123.;
    const double other = 1.213;
    const long lll = /#123e3#/ 123e-3;
    char character = '\n';
    int abc;
end record;

int global_int_var;
double double_global;
char c;

record Taghi begin
    double a;
end record;

float f_globe;
bool bol_global;

function void test(int a, bool bole, char character, int tea);

function int factorial(int n)
    begin
        if(n <= 1)
        begin
            return 1;
        end
        else
        begin
            return n * factorial(n - 1);
        end
    end

function int main()
    begin
        int a = 3;
        double b = 4, dab = 123.23;
        float f1, f2 = true, f3 = 13e2;
        char local_character = 'a', c3 = '\t';

        a = 4;
        bool aflas= false;

        Ali ali, taghi;

        a = (2.2+3)*4-2;
        ali.abc *= 10;
        b = ali.abc;

        string str = "ali alavi";
        int array[10];
        double darray[10 + 1];

        b = darray[1];
        darray[2] -= .0123;

        int heavy_expression = a + b * 10 %(a-- - 5) + darray[1] + ali.test;

        test(1, true+2*(5-1), 'a', 12);

        repeat
            begin
                a=2;
                a= 2*8 and 3;
            end
        until(a);

        if(false and true)
        begin
            b = .123;
        end
        else
        begin
            b = 123e3;
        end

        a = 0.0;

        for(a = -1; a > 3; a+=10)
        begin
            int var = 3;
            a *= 12 + 2;
        end

        switch(a) of :
            begin
                case 10:
                begin
                    if(a == 5)
                    begin
                    ##darray[1] = 1000 * darray[2] + (a or 4);
                    end
                    else
                    begin
                        int a = 10;
                    end
                end
                case 1:
                begin
                    int c = true;
                end
                case 5:
                begin
                end
                case 2:
                begin
                end
                default:
                begin
                    double d = 3e4;
                end
            end

            foreach(i in array)
            begin
            end

            int fact = factorial(6) + 10;
            factorial(7);

           global_int_var = 4 and a++;

            print(a);
            print(b);
            string other = str;
            print(other);

            int length = len("ali ali");
    end

long long_var;

function void test(int a, bool bole, char character, int tea)
    begin
    end

/#function double test(bool a, bool b, char c, int d)
    begin
    end wrong overloading#/

record Vali_vali begin
    bool bol;
end record;