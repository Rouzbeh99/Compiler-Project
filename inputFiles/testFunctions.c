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

function int main() begin
        test(3,true,'c',23);
	int b = factorial(5);
	print(b);
	
end


function void test(int a, bool bole, char character, int tea)
    begin
    end