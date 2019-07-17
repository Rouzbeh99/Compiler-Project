
function int main()
begin
   int number1 = 243 + 343 * 23;
   long number2 = 34 + number1;
   char local_character = 'a', c3 = '\t';
   string str = "ali alavi";
   int array[10];
   int a;
   double darray[10 + 1];

  

    repeat
          begin
                number1=2;
                number1= 2*8 and 3;
            end
        until(number1 < 12);
	
	
    
   for(a = -1; a < 100; a+=10)
        begin
            int var = a;
            print(a);
            print(var * 3) ;
	    
        end  
	

        switch(a) of :
          begin
                case 10:
                begin
                   if(a == 5)
                    begin
                    a = 3;
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
		    print(d);
                end 
            end  

end