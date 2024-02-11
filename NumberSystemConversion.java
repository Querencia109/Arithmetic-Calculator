import java.util.Scanner;

public class NumberSystemConversion {
    public static Scanner in = new Scanner(System.in);
    public static int z, y;
    
    public static boolean isBinaryNumber(String num)
    {
        int a = 0;
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i); //Gets the character/digit of the string
            //Checks if the binary number only contains 0, 1 or has a negative sign
            if ((ch == '0' || ch == '1') || ch == '-') {
                a++;
            } 
        }
        if(a == num.length())
            return true;
        else
            return false;
    }
    
    public static boolean isDecimalNumber(String num)
    {
        int a = 0;
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i); //Gets the character/digit of the string
            //Checks if the decimal number only contains 0 to 9 or has a negative sign
            if ((ch >= '0' && ch <= '9') || ch == '-') {
                a++;
            } 
        }
        if(a == num.length())
            return true;
        else
            return false;
    }
    
    public static boolean isOctalNumber(String num)
    {
        int a = 0;
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i); //Gets the character/digit of the string
            //Checks if the octal number only contains 0 to 7 or has a negative sign
            if ((ch >= '0' && ch <= '7') || ch == '-') {
                a++;
            }
        }
        if(a == num.length())
            return true;
        else
            return false;
    }
    
    public static boolean isHexadecimalNumber(String num)
    {
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i); //Gets the character of the string
            //Check if the character has a negative sign
            if(ch == '-') {
                continue;
            }
             //Check if the character is not 0 to 9 or A to F
            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F')) {
                return false;
            }
        }
        return true;
    }
    
    public static String[] convertDecimalToBinary(int num) {
        int temp, check = 0;
	String bin[] = new String[20];
	y = 0;
        
        if(num == 0) { //If the number is zero
            bin[y] = "0"; //Store "0" to the binary array
            y++; //Increments the z variable by one for the display
            return bin;
        }
        
        if(num < 0) { //If the number is a negative
            num *= -1; //Multiply the number by -1
            check++; //Increments the checker for adding a negative sign later
        }
        
	while(num != 0) { //If the number is not zero
            temp = num % 2; //Stores the value of num mod 2 to temp			
            bin[y] = Integer.toString(temp); //Converts the temp value to a string then store it in the bin array
            num /= 2; //Then divide the number by two to get the value of the next digit
            y++; //Increments the z variable by one for the display
	}
        if(check == 1) { //If the checker is oen
            bin[y++] = "-"; //Add a negative sign at the end
            return bin;
        }
        else
            return bin;
    }
    
    public static int convertBinaryToDecimal(int num) {
        int dec = 0, temp, base = 1, check = 0;
			
        if(num == 0) //If the number is zero
            return dec;
        
        if(num < 0) { //If the number is a negative
            num *= -1; //Multiply the number by -1
            check++; //Increments the checker for adding a negative sign later
        }
        
	while(num != 0) {
		temp = num % 10; //Stores the value of num mod 10 to temp
		dec += (temp * base); //Adds the value from the temp multiplied by the base
		base *= 2; //Then mutiply the base by two
		num /= 10; //Then divide the number by 10 to get the value of the next digit
	}
        
        if(check == 1) { //If the checker is one
            return dec *= -1; //Multiply the number by -1 for the negative value
        }
        else
            return dec;
    }

    public static int convertDecimalToOctal(int num) {
        int oct = 0, temp, base = 1;
	
        if(num == 0) //If the number is zero
            return oct;
        
	while(num != 0) {
		temp = num % 8; //Stores the value of num mod 10 to temp 
		oct += (temp * base); //Adds the value from the temp multiplied by the base
                base *= 10; //Then multiply the base by 10 
                num /= 8; //Then divide the number by eight to get the value of the next digit
	}
	return oct;
    }
    
    public static int convertOctalToDecimal(int num) { //123
        int dec = 0, base = 0;
        
        if(num == 0) //If the number is zero
            return dec;
        
        while(num != 0) { 
            dec += (num % 10) * Math.pow(8, base); //Adds the value got from num mod 10 multiplied by 8 to the power of the base 
            num /= 10; //Then divide the number by 10 to get the value of the next digit
            base++; //Increments the base by one
            
            //dec = dec + (123 % 10) * 1 = 3
            //123 / 10 = 12
            //base++ base = 1
            
            //dec = 3 + (12 % 10) * 8 = 3 + 16 = 19
            //12 / 10 = 1
            //base++ base = 2
            
            //dec = 19 + (1 % 10) * 64 = 19 + 64 = 83
            //1 / 10 = 0
            //base++ base = 3
	}
        return dec; //83
    }
    
    public static char[] convertDecimalToHexadecimal(int num) {
        int temp, check = 0;
	char hex[] = new char[20];
	z = 0;
        
        if(num == 0) {//If the number is zero
            hex[z] = '0'; //Store '0' to the hex array
            z++; //Increments the z variable by one for the display
            return hex;
        }
        
        if(num < 0) { //If the number is a negative
            num *= -1; //Multiply the number by -1
            check++; //Increments the checker for adding a negative sign later
        }
        
	while(num != 0) {
            temp = num % 16; //Stores the value of num mod 16 to temp 
						
            if(temp < 10) //If temp is less than 10, convert to ASCII equivalent of the number (0-9)
                temp += 48;
            else //If temp is more than or equal to 10, convert to ASCII of the hexadecimal (A-F)
                temp += 55;
							
            hex[z] = (char)temp; //Converts the temp to a character to store in the character array
            num /= 16; //Divide the number by 16 to get the value of the next digit
            z++; //Increments the z variable by one for the display
	}
        if(check == 1) { //If the checker is one
            hex[z++] = '-'; //Add a negative sign at the end
            return hex;
        }
        else
            return hex;
    }
    
    public static int convertHexadecimalToDecimal(String hexNum2Copy) {
        int dec = 0, i, check = 0;
        String hex = "0123456789ABCDEF"; //All the values of hexadecimal
        
        for(i = 0; i < hexNum2Copy.length(); i++) {
            char c = hexNum2Copy.charAt(i); //Gets the digit or letter in that index;
            
            if(c == '-') { //If the number has negative sign
                check++;
            }
            else {
                int n = hex.indexOf(c); //Compares the digit or letter to the index of the hex string, ex. B is in index 11;
                dec = (dec*16) + n; //Multiplies the decimal number by 16 then add the index of the equivalent hex;
            }
        }
        if(check == 1) { //If the checker is one
            return dec *= -1; //Multiply the number by -1 for the negative value
        }
        else
            return dec;
    }
    
    public static void main(String[] args) {
        int num, numCopy, dec, oct;
        String hexNum2, hexNum2Copy, decCopy, octCopy, binCopy;
	char hexNum[] = new char[20];
        String bin[] = new String[50];
	char choice1, choice2, choice3;
        
        do {
            System.out.println("NUMBER SYSTEM CONVERSION");
            System.out.println("=======|M E N U|=======");
            System.out.println("1. Binary");
            System.out.println("2. Decimal");
            System.out.println("3. Octal");
            System.out.println("4. Hexadecimal");
            System.out.println("5. Exit");
            System.out.print("\nEnter choice: ");
            choice1 = in.next().charAt(0);
            
            //Input Binary Number
            if(choice1 == '1') {
                //Checks if the entered number is a Binary
                do {
                    System.out.print("\nEnter a Binary Number: ");
                    binCopy = in.next();
                    if(isBinaryNumber(binCopy) == false){
                        System.out.println("\nEntered number is not a Binary number!");
                    }
                }while(isBinaryNumber(binCopy) == false);
                
                num = Integer.parseInt(binCopy);
                numCopy = num;
                System.out.println("");
                
                do {
                    System.out.println("======|M E N U|======");
                    System.out.println("1. Binary to Decimal");
                    System.out.println("2. Binary to Octal");
                    System.out.println("3. Binary to Hexadecimal");
                    System.out.println("4. Back");
                    System.out.print("\nEnter choice: ");
                    choice2 = in.next().charAt(0);
                    
                    //Binary to Decimal
                    if(choice2 == '1') {
                        //Convert Binary to Decimal
                        dec = convertBinaryToDecimal(numCopy);
                        
                        //Display
                        System.out.println("\nBinary: " + num);
                        System.out.println("Decimal: " + dec);
                        
                        do {
                            System.out.print("\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                    
                    //Binary to Octal
                    if(choice2 == '2') {
                        //Convert to Decimal First
                        dec = convertBinaryToDecimal(numCopy);
                        
                        //Then Convert Decimal to Octal
                        oct = convertDecimalToOctal(dec);
                        
                        //Display
                        System.out.println("\nBinary: " + num);
                        System.out.println("Octal: " + oct);
                        
                        do {
                            System.out.print("\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                    
                    //Binary to Hexadecimal
                    if(choice2 == '3') {
                        //Convert to Decimal First
                        dec = convertBinaryToDecimal(numCopy);
                        
                        //Then Convert Decimal to Hexadecimal
                        hexNum = convertDecimalToHexadecimal(dec);
                        
                        //Display
                        System.out.println("\nBinary: " + num);
                        System.out.print("Hexadecimal: ");
                        for(z -= 1; z >= 0; z--) {
                            System.out.print(hexNum[z]);
                        }
                        
                        do {
                            System.out.print("\n\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                }while(choice2 != '4');
            }
            
            //Input Decimal Number
            else if(choice1 == '2') {
                //Checks if the entered number is a Decimal
                do {
                    System.out.print("\nEnter a Decimal Number: ");
                    decCopy = in.next();
                    
                    if(isDecimalNumber(decCopy) == false){
                        System.out.println("\nEntered number is not a Decimal number!");
                    }
                }while(isDecimalNumber(decCopy) == false);
                
                num = Integer.parseInt(decCopy);
                numCopy = num;
                System.out.println("");
                
                do {
                    System.out.println("======|M E N U|======");
                    System.out.println("1. Decimal to Binary");
                    System.out.println("2. Decimal to Octal");
                    System.out.println("3. Decimal to Hexadecimal");
                    System.out.println("4. Back");
                    System.out.print("\nEnter choice: ");
                    choice2 = in.next().charAt(0);
                    
                    //Decimal to Binary
                    if(choice2 == '1') {
                        //Convert Decimal to Binary
                        bin = convertDecimalToBinary(numCopy);
                        
                        //Display
                        System.out.println("\nDecimal: " + num);
                        System.out.print("Binary: ");
                        for(y -= 1; y >= 0; y--) {
                            System.out.print(bin[y]);
                        }
                        
                        do {
                            System.out.print("\n\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                    
                    //Decimal to Octal
                    if(choice2 == '2') {
                        //Convert Decimal to Octal
                        oct = convertDecimalToOctal(numCopy);
                        
                        //Display
                        System.out.println("\nDecimal: " + num);
                        System.out.println("Octal: " + oct);
                        
                        do {
                            System.out.print("\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                    
                    //Decimal to Hexadecimal
                    if(choice2 == '3') {
                        //Convert Decimal to Hexadecimal
                        hexNum = convertDecimalToHexadecimal(numCopy);
                        
                        //Display
                        System.out.println("\nDecimal: " + num);
                        System.out.print("Hexadecimal: ");
                        for(z -= 1; z >= 0; z--) {
                            System.out.print(hexNum[z]);
                        }
                        
                        do {
                            System.out.print("\n\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                }while(choice2 != '4');
            }
            
            //Input Octal Number
            else if(choice1 == '3') {
                //Checks if the entered number is an Octal
                do {
                    System.out.print("\nEnter an Octal Number: ");
                    octCopy = in.next();
                    
                    if(isOctalNumber(octCopy) == false){
                        System.out.println("\nEntered number is not an Octal number!");
                    }
                }while(isOctalNumber(octCopy) == false);
                
                num = Integer.parseInt(octCopy);
                numCopy = num;
                System.out.println("");
                
                do {
                    System.out.println("======|M E N U|======");
                    System.out.println("1. Octal to Binary");
                    System.out.println("2. Octal to Decimal");
                    System.out.println("3. Octal to Hexadecimal");
                    System.out.println("4. Back");
                    System.out.print("\nEnter choice: ");
                    choice2 = in.next().charAt(0);
                    
                    //Octal to Binary
                    if(choice2 == '1') {
                        //Convert Octal to Decimal First
                        dec = convertOctalToDecimal(numCopy);
                        
                        //Then Convert Decimal to Binary
                        bin = convertDecimalToBinary(dec);
                        
                        //Display
                        System.out.println("\nOctal: " + num);
                        System.out.print("Binary: ");
                        for(y -= 1; y >= 0; y--) {
                            System.out.print(bin[y]);
                        }
                        
                        do {
                            System.out.print("\n\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                    
                    //Octal to Decimal
                    if(choice2 == '2') {
                        //Convert Decimal to Octal
                        oct = convertOctalToDecimal(numCopy);
                        
                        //Display
                        System.out.println("\nOctal: " + num);
                        System.out.println("Decimal: " + oct);
                        
                        do {
                            System.out.print("\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                    
                    //Octal to Hexadecimal
                    if(choice2 == '3') {
                        //Convert Octal to Decimal First
                        dec = convertOctalToDecimal(numCopy);
                        
                        //Then Convert Decimal to Hexadecimal
                        hexNum = convertDecimalToHexadecimal(dec);
                        
                        //Display
                        System.out.println("\nOctal: " + num);
                        System.out.print("Hexadecimal: ");
                        for(z -= 1; z >= 0; z--) {
                            System.out.print(hexNum[z]);
                        }
                        
                        do {
                            System.out.print("\n\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                }while(choice2 != '4');
            }
            
            //Input Hexadecimal Number
            else if(choice1 == '4') {
                //Checks if the entered number is a Hexadecimal
                do {
                    System.out.print("\nEnter a Hexadecimal Number: ");
                    hexNum2 = in.next().toUpperCase(); //Converts the entered hexadecimal to uppercase
                    if(isHexadecimalNumber(hexNum2) == false){
                        System.out.println("\nEntered number is not a Hexadecimal number!");
                    }
                }while(isHexadecimalNumber(hexNum2) == false);
                
                hexNum2Copy = hexNum2;
                System.out.println("");
                
                do {
                    System.out.println("======|M E N U|======");
                    System.out.println("1. Hexadecimal to Binary");
                    System.out.println("2. Hexadecimal to Decimal");
                    System.out.println("3. Hexadecimal to Octal");
                    System.out.println("4. Back");
                    System.out.print("\nEnter choice: ");
                    choice2 = in.next().charAt(0);
                    
                    //Hexadecimal to Binary
                    if(choice2 == '1') {
                        //Convert Hexadecimal to Decimal First
                        dec = convertHexadecimalToDecimal(hexNum2Copy);;
                        
                        //Then Convert Decimal to Binary
                        bin = convertDecimalToBinary(dec);
                        
                        //Display
                        System.out.println("\nHexadecimal: " + hexNum2);
                        System.out.print("Binary: ");
                        for(y -= 1; y >= 0; y--) {
                            System.out.print(bin[y]);
                        }
                        
                        do {
                            System.out.print("\n\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                    
                    //Hexadecimal to Decimal
                    if(choice2 == '2') {
                        //Convert Hexadecimal to Decimal
                        dec = convertHexadecimalToDecimal(hexNum2Copy);
                        
                        //Display
                        System.out.println("\nHexadecimal: " + hexNum2);
                        System.out.println("Decimal: " + dec);
                        
                        do {
                            System.out.print("\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                    
                    //Hexadecimal to Octal
                    if(choice2 == '3') {
                        //Convert Hexadecimal to Decimal
                        dec = convertHexadecimalToDecimal(hexNum2Copy);
                        
                        //Then Convert Decimal to Octal
                        oct = convertDecimalToOctal(dec);
                        
                        //Display
                        System.out.println("\nHexadecimal: " + hexNum2);
                        System.out.print("Octal: " + oct);
                        
                        do {
                            System.out.print("\n\nConvert to another number system? (Y/N): ");
                            choice3 = in.next().toUpperCase().charAt(0);
                            System.out.println("");
                            
                            if(choice3 == 'N')
                                System.exit(0);
                        }while(choice3 != 'Y');
                    }
                    System.out.println("");
                }while(choice2 != '4');
            }
            System.out.println("");
        }while(choice1 != '5');
    }
}