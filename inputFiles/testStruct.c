record Ali begin
    bool boool = true;
    double d_value = .2123;
    float f = 123.6;
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

function int main() begin
	Taghi taghi;
      	Ali ali;
      	ali.f = 45.3;
     	taghi.a = ali.f;

        c = 'd';
        double_global = 334.34;
    	print(ali.f); 

end