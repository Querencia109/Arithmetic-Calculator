import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberSystemArithmetic {
    static Scanner in = new Scanner(System.in);
    
    static int displayMenu() {
        System.out.println("===Number System and Arithmetic Operation===");
        System.out.println("1. Binary Number");
        System.out.println("2. Octal Number");
        System.out.println("3. Hexadecimal Number");
        System.out.println("4. Exit");
        System.out.print("\nChoice: ");
        return in.nextInt();
    }
    
    static int displayOperation() {
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Back");
        System.out.print("\nChoice: ");
        return in.nextInt();
    }
    
    static boolean isBinaryNumber(long nums) {
        int a = 0;
        String num = Long.toString(nums);
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i); //Gets the character/digit of the string
            //Checks if the binary number only contains 0 or 1
            if (ch == '0' || ch == '1') { a++; } 
        }
        if(a == num.length()) return true;
        else return false;
    }
    
    static boolean isOctalNumber(long nums) {
        int a = 0;
        String num = Long.toString(nums);
        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i); //Gets the character/digit of the string
            //Checks if the octal number only contains 0 to 7
            if (ch >= '0' && ch <= '7') { a++; }
        }
        if(a == num.length()) return true;
        else return false;
    }
    
    static boolean isHexadecimalNumber(String nums) {
        for (int i = 0; i < nums.length(); i++) {
            char ch = nums.charAt(i); //Gets the character of the string
             //Check if the character is not 0 to 9 or A to F
            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F') && (ch < 'a' || ch > 'f')) { return false; }
        }
        return true;
    }
    
    static int convertBinaryToDecimal(String num) {
        int pos = 0, dec = 0, x = 0, temp = 0;
        
        for(int i = num.length() - 1; i >= 0; i--) {
            if(num.charAt(i) == '1') {
                dec = dec + (int)Math.pow(2, x);
            }
            x++;
        }
        return dec;
    }
    
    static long convertHexadecimalToDecimal(String num) {
        int dec = 0, i, check = 0;
        String hex = "0123456789ABCDEF";            // All the values of hexadecimal
        
        for(i = 0; i < num.length(); i++) {
            char c = num.charAt(i);                 // Gets the digit or letter in that index;
            
            if(c == '-') {                          // If the number has negative sign
                check++;
            }
            else {
                int n = hex.indexOf(c);             // Compares the digit or letter to the index of the hex string, ex. B is in index 11;
                dec = (dec*16) + n;                 // Multiplies the decimal number by 16 then add the index of the equivalent hex;
            }
        }
        if(check == 1) {                            // If the checker is one
            return dec *= -1;                       // Multiply the number by -1 for the negative value
        }
        else
            return dec;
    }
    
    static void binary_addition(long a, long b) {
        long bin1 = a, bin2 = b;
        long temp;
        int i = 0, rem = 0;
        int sum[] = new int[50];
        
        //a is less than b
        if (a < b) {
            temp = b;
            b = a;
            a = temp;
            for (; a != 0 || b != 0; a /= 10, b /= 10) {    // continue to loop until the value is not 0. Divide the number by 10
                sum[i] = (int) (((a + b) % 10 + rem) % 2);  // get the modulus of two binary numbers and adding both of them with remainder then get the modulus of it with 2
                rem = (int) (((a + b) % 10 + rem) / 2);     // get the modulus of two binary numbers and add the remainder then the sum of it will be divided by 2
                i++;
            }

            //this process is only used if there is a remainder that needs to bring down.
            if (rem != 0)                                   // the remainder should not be equal to 0
            {
                sum[i] = rem;                               // the remainder will be stored in the sum array
		i++;
            }

            // Display
            System.out.print("\n" + bin1 + " + " + bin2 + " = ");
            i--;
            while (i >= 0) {
                System.out.print(sum[i]);
		i--;
            }
            System.out.println("\n");

            //a is greater than b.
        } else if (a > b || a != 0 && b != 0 && a == b) {
            for (; a != 0 || b != 0; a /= 10, b /= 10) {    // continue to loop until the value is not 0. Divide the number by 10
                sum[i] = (int) (((a + b) % 10 + rem) % 2);  // get the modulus of two binary numbers and adding both of them with remainder then get the modulus of it with 2
                rem = (int) (((a + b) % 10 + rem) / 2);     // get the modulus of two binary numbers and add the remainder then the sum of it will be divided by 2
                i++;
            }

            //this process is only used if there is a remainder that needs to bring down.
            if (rem != 0)                                   // the remainder should not be equal to 0
            {
                sum[i] = rem;                               // the remainder will be stored in the sum array
		i++;
            }
            
            // Display
            System.out.print("\n" + bin1 + " + " + bin2 + " = ");
            i--;
            while (i >= 0) {
                System.out.print(sum[i]);
		i--;
            }
            System.out.println("\n");

        } else if (a == 0 && b == 0) {
            // Display
            System.out.print(bin1 + " + " + bin2 + " = 0 " + "\n");
            System.out.println("\n");
        }
    }
    
    static String binary_subtraction(String bin1, String bin2) {
        String diff = "";
        char checknumber = '0';
        int lengthbinary1 = bin1.length(), lengthbinary2 = bin2.length();
        
        //check the length of the subtrahend. if the minuend is less than subtrahend it will proceed in this condition
        if (lengthbinary1 < lengthbinary2) {
            //looping statement. this loop makes the minuend equal to the number of digits of subtrahend using 0
            for (int val = 1; val <= lengthbinary2 - lengthbinary1; val++) {
                bin1 = '0' + bin1;
            }
       //check the length of the minuend. if the subtrahend is less than minuend it will proceed in this condition
        } else if (lengthbinary2 < lengthbinary1) {
           //looping statement. this loop makes the subtrahend equal to the number of digits of minuend using 0
            for (int val = 1; val <= lengthbinary1 - lengthbinary2; val++) {
                bin2 = '0' + bin2;
            }
        }

        //assign the value of val to the length of binary_number1.length minus 1
        int val = bin1.length() - 1;
        //this process will check each index of the binary_number1 and binary_number2 to using val and print the diff of each index of them
        while (val >= 0) {
            if (bin1.charAt(val) == '1' && bin2.charAt(val) == '0') {
                if (checknumber == '1') {
                    diff = '0' + diff;
                    checknumber = '0';
                } else {
                    diff = '1' + diff;
                }
            } else if (bin1.charAt(val) == bin2.charAt(val) && bin2.charAt(val) == '1') {
                if (checknumber == '1') {
                    diff = '1' + diff;
                    checknumber = '1';
                } else {
                    diff = '0' + diff;
                }
            } else if (bin1.charAt(val) == '0' && bin2.charAt(val) == '1') {
                if (checknumber == '1') {
                    diff = '0' + diff;
                } else {
                    diff = '1' + diff;
                    checknumber = '1';
                }
            } else {
                if (checknumber == '1') {
                    diff = '1' + diff;
                } else {
                    diff = '0' + diff;
                }
            }
             val--;
        }
        return diff;
    }
    
    static int binary_mul_addition(long a, long b) {
        int i = 0, remainder = 0, product_result = 0;
        int sum[] = new int[50];

        for (; a != 0 || b != 0; a /= 10, b /= 10) {                // continue to loop until the value is not 0. Divide the number by 10
            sum[i] = (int) (((a + b) % 10 + remainder) % 2);        // get the modulus of two binary numbers and adding both of them with remainder then get the modulus of it with 2
            remainder = (int) (((a + b) % 10 + remainder) / 2);     // get the modulus of two binary numbers and add the remainder then the sum of it will be divided by 2
            i++;
        }

        if (remainder != 0) {                                       // condition should not be equal to 0
            sum[i] = remainder;                                     // the remainder will be stored in the sum array
            i++;
        }
        i--;                                                        // decrease by 1
        while (i >= 0) {                                            // the value should not be less than to 0 to continue looping
            product_result *= 10;                                   // multiply to 10 and stored the value to the variable itself
            product_result += sum[i];                               // add the sum[increment] to itself and stored the value to itself also
            i--;
        }
        return product_result;                                      // return the value
    }
    
    static int binary_multiplication(long a, long b) {
        int multiply = 0, factor = 1;

        //looping statement
        for (; b != 0; b /= 10) {                                   // the condition is set as not equal to 0. after the looping it will be divided by 2 then check again the condition set
            if (b % 10 == 1) {                                      // check the condition if the binarynumber2 modulo by 10 is equal to1
                a *= factor;                                        // variable binary_number multiply to 1 and stored the value to itself
                multiply = binary_mul_addition(a, multiply);        // pass the value to perform addition
            } else {
                a *= factor;                                        //variable binary_number multiply to 1 and stored the value to itself
            }
            factor = 10;
        }
        return multiply;
    }
    
    static String binary_division(long a, long b) {
        String bin1 = Long.toString(a), bin2 = Long.toString(b);    // convert the long to string
        String temp = "", quo = "", tempSub;
        int i = 0, divisor = 0, dividend = 0;
        
        if(a == 0)
            return "0";
        
        if(b == 0)
            return "Error: can't divide by 0";
        
        temp = temp + bin1.charAt(i);                               // store the first digit of the binary to temp
        for(i = 0; i < bin1.length(); i++) {                        // index increments until it is equal to the length of the first number
            divisor = convertBinaryToDecimal(bin2);                 // converts the second number to decimal for checking
            dividend = convertBinaryToDecimal(temp);                // converts the temp number to decimal for checking
            if(dividend >= divisor) {                               // if the temp number is greater than or equal to the second number
                quo = quo + "1";                                    // add 1 to the quotient
                tempSub = binary_subtraction(temp, bin2);           // do the binary sub for subtracting the temp number and the second number
                if(i == bin1.length() - 1)                          // checks if the digit is the last digit of the first number
                    temp = tempSub + bin1.charAt(i);                // bring down the last digit
                else                                                // if the digit is not the last digit of the first number
                    temp = tempSub + bin1.charAt(i+1);              // bring down the next digit
            }
            else {                                                  // if the temp number is less than the second number
                quo = quo + "0";                                    // add 0 to the quotient
                if(i == bin1.length() - 1)                          // checks if the digit is the last digit of the first number 
                    temp = temp + bin1.charAt(i);                   // bring down the last digit
                else                                                // if the digit is not the last digit of the first number
                    temp = temp + bin1.charAt(i+1);                 // bring down the next digit
            }
//            System.out.println(i + " - " + quo);
        }
        return quo;                                                 // return the quotient
    }
    
    static int octal_addition(int a, int b) {
        int oct1 = a, oct2 = b, sum = 0, carry = 0, d, pos = 1;         // initialization, d = digit, pos = place value
        while(a != 0 || b != 0 || carry != 0) {				// continue to loop until a, b and carry turns into 0
            d = carry + (a % 10) + (b % 10);                            // d = carry + the LSD of 1st numebr + the LSD of the 2nd number
            a /= 10;                                                    // divide the first number by 10 for the next digit
            b /= 10;                                                    // divide the second number by 10 for the next digit
		
            if(d > 7) {                                                 // if the digit is greater than 7
                carry = 1;                                              // increment the carry by 1
                d = d % 8;                                              // get the modulus of digit by 8
            } 
            else {                                                      // if the digit is less than or equal to 0
                carry = 0;                                              // make the carry as 0
            }
        sum += d * pos;                                                 // sum = sum + (digit * position)
        pos *= 10;                                                      // multiply the pos by 10 for the next digit
        }
        return sum;                                                     // return the sum
    }
    
    static int octal_subtraction(int a, int b) {
        int diff = 0, d, pos = 1;                                       // initialization, d = digit, pos = place value
        while(a != 0 || b != 0) {                                       // loops while a or b is not equal to 0
            if((b % 10) > (a % 10)) {                                   // checks if the second number is greater than the first number
                d = ((a % 10) + 8) - (b % 10);                          // digit = (mod of a + 8) - mod of b
                a = (a / 10) - 1;                                       // get the next digit minus 1 since we borrowed
                b /= 10;                                                // get the next digit
            }
            else {                                                      // if first number is greater than the second number
                d = (a % 10) - (b % 10);                                // digit = mod of a - mod of b
                a /= 10;                                                // get the next digit
                b /= 10;                                                // get the next digit
            }
            diff += d * pos;                                            // diff = diff + (digit * position)
            pos *= 10;                                                  // multiply the pos by 10 for the next digit
        }
        return diff;                                                    // return the difference
    }
    
    static int octal_mul(int a, int b) {
        int tempA, tempB, prod, total = 0, carry = 0, pos = 1, powT;            // initialization of variables
        int aSize = (int)Math.log10(a) + 1;                                     // get the length of the first number
        int aSizeMax = aSize;                                                   // have a copy of the length
        
        tempB = b % 10;                                                         // store the last digit of second number to tempB
        b /= 10;                                                                // divide the second number by 10 for the next digit
        
        while(aSize != 0) {                                                     // loops while the length of the first number is not 0
            tempA = a % 10;                                                     // store the last digit of first number to tempA
            a /= 10;                                                            // divide the first number by 10 for the next digit
            
            prod = (tempA * tempB) + carry;                                     // get the prod of tempA and tempB + carry
            
            if(prod >= 8) {                                                     // if the prod is greater than or equal to 8
                carry = prod / 8;                                               // get the carry by dividing 8 to the product
                prod %= 8;                                                      // prod modulus 8 for the value
            }
            else {                                                              // if the prod is in octal range
                carry = 0;                                                      // set the carry to 0
            }
                
            if(aSize == 1) {                                                    // if the length is now 1
                if(aSizeMax < 3) {                                              // if the max length of first number is less than 3
                    prod = (carry * pos) + (prod % 8);                          // set the prod to (carry * power) + (prod mod 8)
                }
                else {                                                          // if 3 or more
                    powT = (int)(Math.pow(10, aSizeMax) / 100);                 // get the power of ten by 10^aSizeMax / 100
                    prod = (carry * (pos / powT)) + (prod % 8);                 // set the prod to (carry * (position / power of ten)) + (prod mod 8)
                }
            }
            total = total + (prod * pos);                                       // get the total by multiplying the prod to the position
            pos *= 10;                                                          // set the next position
            aSize--;                                                            // get the next digit
        }
        return total;                                                           // return the multiplied total
    }
    
    static int octal_mul_addition(int a, int b) {
        int tempA, tempB, sum, total = 0, carry = 0, pos = 1;                   // initialization of variables
        
        do {                                                                    // loops while a or b or carry is greater than 0
            tempA = a % 10;                                                     // store the first digit of first number to tempA
            a /= 10;                                                            // get the next digit
            tempB = b % 10;                                                     // store the first digit of second number to tempB
            b /= 10;                                                            // get the next digit
            
            sum = tempA + tempB + carry;                                        // get the sum of tempA, tempB and carry
            
            carry = sum / 8;                                                    // get the carry by dividing 8 to the sum
            sum %= 8;                                                           // set the value to sum mod 8
            
            total = total + (sum * pos);                                        // add the prod of sum and position to the total
            pos *= 10;                                                          // set the next position
        }while(a > 0 || b > 0 || carry > 0);
        return total;                                                           // return the total sum
    }
    
    static int octal_multiplication(int a, int b) {
        int prod = 0, pos = 1, temp, tempProd, i;                               // initialiaztion of variables
        int bSize = (int)Math.log10(b) + 1;                                     // get the length of second number
        
        // for all the multiplication part
        int[] prodArr = new int [bSize];                                        // create an array of products with the size of second number
        for(i = 0; i < bSize; i++) {                                            // loops until i is equal to size of second number
            temp = b % 10;                                                      // store the first digit of second number to temp
            b /= 10;                                                            // get the next digit
            tempProd = octal_mul(a, temp);                                      // do the multiplication of the first number and the digit from temp
            prodArr[i] = tempProd * pos;                                        // store the product from function above to the array * position
            pos *= 10;                                                          // set the next position
        }
        
        // for all the addition part
        int sum = prodArr[0];                                                   // set the first sum as the first product in the product array
        for(i = 1; i < bSize; i++) {                                            // loops until i is equal to size of second number
            sum = octal_mul_addition(sum, prodArr[i]);                          // do the addition of the sum and product in the product array
        }
        return prod = sum;                                                      // return the product
    }
    
    static int octal_division(int a, int b) {
        int quo = 0;
        
        return quo;
    }
    
    static int Value(char x) {                              // Retutn the value of the Hexadecimal
        if(x== 'A' || x == 'a') { return 10; }
        if(x == 'B' || x == 'b') { return 11; }
        if(x == 'C' || x == 'c') { return 12; }
        if(x == 'D' || x == 'd') { return 13; }
        if(x == 'E' || x == 'e') { return 14; }
        if(x == 'F' || x == 'f') { return 15; }
        return  x - '0';
    }
    
    static String hexadecimal_addition(String a, String b) {
        int n = a.length(), m = b.length();                                             // get the lengths of first and second number
        int i = n-1, j = m-1;                                                           // base the index to the length minus 1
        int temp, carry = 0;
        String sum = "";
        char[] hexaValue = {'0','1','2','3','4','5','6', '7',                           // values of hex
                            '8','9','A','B','C','D','E','F'};
        while(i >= 0 || j >= 0) {                                                       // loops while i and j still has value
            if(i >= 0 && j >= 0) {                                                      // checks if i and j has value
                temp = Value(a.charAt(i)) + Value(b.charAt(j)) + carry;                 // stores the sum of values of first and second digit and carry
                i--;                                                                    // decrement to get the next digit
                j--;                                                                    // decrement to get the next digit
            }
            else if(i >= 0) {                                                           // checks if i still has value
                temp = Value(a.charAt(i)) + carry;                                      // stores the sum of value of first digit and carry
                i--;                                                                    // decrement to get the next digit
            }
            else {                                                                      // checks if j still has value
                temp = Value(b.charAt(j)) + carry;                                      // stores the sum of value of second digit and carry
                j--;                                                                    // decrement to get the next digit
            }
            sum = hexaValue[(temp % 16)] + sum;                                         // sum = sum + hex value of the temp mod 16
            carry = temp / 16;                                                          // divide the temp by 16 to get the carry
        }
        if(carry != 0) {                                                                // if there's a carry left
            sum = hexaValue[carry] + sum;                                               // add it to the sum
        }
        return sum;                                                                     // return the sum
    }
    
    static String hexadecimal_subtraction(String a, String b) {
        int n = a.length(), m = b.length();                                             // get the length of both numbers
        int i = n-1, j = m-1;                                                           // use the length for finding the next digit
        int temp = 0, borrow = 0;                                                       // temp for storing the digit, borrow used as a flag
        String diff = "";                                                               // where the result of each iteration is stored
        StringBuilder sb = new StringBuilder(diff);                                     // for inserting the digit into result
        char[] hexaValue = {'0','1','2','3','4','5','6','7',                            // getting the equivalent hex value of the temp digit
                            '8','9','A','B','C','D','E','F'};
        while(i >= 0 || j >= 0) {                                                       // loops if the i or j is equal to 0 meaning there's still a digit left
            if(i >= 0 && j >= 0 && Value(b.charAt(j)) > Value(a.charAt(i))) {           // checks if the digit from the 2nd number is greater than the 1st
                if(borrow == 1) {                                                       // checks if we borrowed from the next digit from the last iteration
                    temp = (Value(a.charAt(i)) - 1 + 16) - Value(b.charAt(j));          // get the value of the 1st digit then -1 and +16 because we borrowed from the next digit from the last iteration - 2nd digit
                    borrow = 1;                                                         // sets the borrow to 1 because we borrowed
                }
                else {                                                                  // if we didn't borrowed yet
                    temp = (Value(a.charAt(i)) + 16) - Value(b.charAt(j));              // get the value of the 1st digit then +16 because we borrowed from the next digit - 2nd digit
                    borrow = 1;                                                         // sets the borrow to 1 because we borrowed
                }
            }
            
            else if(i >= 0 && j >= 0 && Value(a.charAt(i)) > Value(b.charAt(j))) {      // checks if the digit from the 1st number is greater than the 2nd
                if(borrow == 1) {                                                       // checks if we borrowed from the next digit form the last iteration
                    temp = (Value(a.charAt(i)) - 1) - Value(b.charAt(j));               // get the value of the 1st digit then -1 because we borrowed from the next digit from the last iteration - 2nd digit
                    borrow = 0;                                                         // sets the borrow to 0 because we didn't borrowed
                }
                else {                                                                  // if we didn't borrowed yet
                    temp = Value(a.charAt(i)) - Value(b.charAt(j));                     // get the value of the 1st digit - 2nd digit
                    borrow = 0;                                                         // sets the borrow to 0 because we didn't borrowed
                }
            }
            
            else if(i >= 0 && j >= 0 && Value(a.charAt(i)) == Value(b.charAt(j))) {     // checks if the digit from the 1st number is equal to the 2nd
                temp = Value(a.charAt(i)) - Value(b.charAt(j)) ;                        // get the value of the 1st digit - 2nd digit
                borrow = 0;                                                             // sets the borrow to 0 because we didn't borrowed
            }
            
            else if(i >= 0) {                                                           // checks if there's still a digit remaining from the 1st number
                if(borrow == 1)                                                         // checks if we borrowed from the next digit form the last iteration
                    temp = Value(a.charAt(i)) - 1;                                      // get the value of the 1st digit then -1
                else                                                                    // if we didn't borrowed
                    temp = Value(a.charAt(i));                                          // get the value of the 1st digit
            }
            
            i--;                                                                        // proceed to the next digit
            j--;                                                                        // proceed to the next digit
            
            sb.insert(0, hexaValue[(temp % 16)]);                                       // insert the hex value of the temp digit to the result
        }
        return sb.toString();                                                           // return the difference
    }
            
    static String hexadecimal_multiplication(String a, String b) {
        int Hexsixtn = 16;

        ArrayList<Character> arr1 = new ArrayList<>();                              // Store Char
        ArrayList<Character> arr2 = new ArrayList<>();                              // Store Char
        ArrayList<Long> Arr1Long = new ArrayList<>();                                  // Store Long
        ArrayList<Long> Arr2Long = new ArrayList<>();                                  // Store Long
        String hexa1 = a;
        String hexa2 = b;
        for (char ch : hexa1.toCharArray()) {                                              // Add
            arr1.add(ch);
        }
        for (char ch : hexa2.toCharArray()) {
            arr2.add((ch));
        }

        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) == 'A' || arr1.get(i) == 'B' || arr1.get(i) == 'C' || arr1.get(i) == 'D' || arr1.get(i) == 'E' || arr1.get(i) == 'F') // determine if there are letter in the 1st number given and convert it hex to decimal
            {
                Arr1Long.add(convertHexadecimalToDecimal(Character.toString(arr1.get(i))));
            } else {
                Arr1Long.add(Long.valueOf(Character.toString(arr1.get(i)))); //convert to long
            }
        }
        for (int i = 0; i < arr2.size(); i++) {
            if (arr2.get(i) == 'A' || arr2.get(i) == 'B' || arr2.get(i) == 'C' || arr2.get(i) == 'D' || arr2.get(i) == 'E' || arr2.get(i) == 'F') { // determine if there are letter in the 2nd number given and convert it hex to decimal
                Arr2Long.add(convertHexadecimalToDecimal(Character.toString(arr2.get(i))));
            } else {
                Arr2Long.add(Long.valueOf(Character.toString(arr2.get(i)))); //convert to long
            }
        }

        int lengthArr1 = Arr1Long.size(); // get the length size of numbers
        int lengthArr2 = Arr2Long.size(); // get the length size of numbers
        long digit = 0;
        long multi = 0;

        ArrayList<Long> Add = new ArrayList<>();            //  246
        ArrayList<Long> Add2 = new ArrayList<>();           // 123
        ArrayList<Long> Add3 = new ArrayList<>();
        ArrayList<Long> Add4 = new ArrayList<>();
        ArrayList<Long> Add5 = new ArrayList<>();
        ArrayList<Long> Add6 = new ArrayList<>();
        ArrayList<Long> Add7 = new ArrayList<>();
        ArrayList<Long> Add8 = new ArrayList<>();
        ArrayList<Long> Add9 = new ArrayList<>();
        ArrayList<Long> Add10 = new ArrayList<>();    

        for (int i = lengthArr2 - 1; i >= 0; i--) {
            long d2 = Arr2Long.get(i);
            long carry = 0;

            for (int j = lengthArr1 - 1; j >= 0; j--) {
                multi = Arr1Long.get(j);
                digit = d2 * multi + carry;
                carry = digit / Hexsixtn;
                digit = digit % Hexsixtn;

                if (i == lengthArr2 - 1) {
                    Add.add(digit);
                } else if (i == lengthArr2 - 2) {
                    Add2.add(digit);
                } else if (i == lengthArr2 - 3) {
                    Add3.add(digit);
                } else if (i == lengthArr2 - 4) {
                    Add4.add(digit);
                } else if (i == lengthArr2 - 5) {
                    Add5.add(digit);
                } else if (i == lengthArr2 - 6) {
                    Add6.add(digit);
                } else if (i == lengthArr2 - 7) {
                    Add7.add(digit);
                } else if (i == lengthArr2 - 8) {
                    Add8.add(digit);
                } else if (i == lengthArr2 - 9) {
                    Add9.add(digit);
                } else if (i == lengthArr2 - 10) {
                    Add10.add(digit);
                }
            }
            if (i == lengthArr2 - 1) {          // 0234
                if (carry > 0) {                // 123
                    Add.add(carry);             // 1464
                }
            } else if (i == lengthArr2 - 2) {
                if (carry > 0) {
                    Add2.add(carry);
                }
            } else if (i == lengthArr2 - 3) {
                if (carry > 0) {
                    Add3.add(carry);
                }
            } else if (i == lengthArr2 - 4) {
                if (carry > 0) {
                    Add4.add(carry);
                }
            } else if (i == lengthArr2 - 5) {
                if (carry > 0) {
                    Add5.add(carry);
                }
            } else if (i == lengthArr2 - 6) {
                if (carry > 0) {
                    Add6.add(carry);
                }
            } else if (i == lengthArr2 - 7) {
                if (carry > 0) {
                    Add7.add(carry);
                }
            } else if (i == lengthArr2 - 8) {
                if (carry > 0) {
                    Add8.add(carry);
                }
            } else if (i == lengthArr2 - 9) {
                if (carry > 0) {
                    Add9.add(carry);
                }
            } else if (i == lengthArr2 - 10) {
                if (carry > 0) {
                    Add10.add(carry);
                }
            }
        }
        Add2.add(0, Long.valueOf(0));
        Add3.add(0, Long.valueOf(0));
        Add3.add(1, Long.valueOf(0));
        Add4.add(0, Long.valueOf(0));
        Add4.add(1, Long.valueOf(0));
        Add4.add(2, Long.valueOf(0));
        Add5.add(0, Long.valueOf(0));
        Add5.add(1, Long.valueOf(0));
        Add5.add(2, Long.valueOf(0));
        Add5.add(3, Long.valueOf(0));
        Add6.add(0, Long.valueOf(0));
        Add6.add(1, Long.valueOf(0));
        Add6.add(2, Long.valueOf(0));
        Add6.add(3, Long.valueOf(0));
        Add6.add(4, Long.valueOf(0));
        Add7.add(0, Long.valueOf(0));
        Add7.add(1, Long.valueOf(0));
        Add7.add(2, Long.valueOf(0));
        Add7.add(3, Long.valueOf(0));
        Add7.add(4, Long.valueOf(0));
        Add7.add(5, Long.valueOf(0));
        Add8.add(0, Long.valueOf(0));
        Add8.add(1, Long.valueOf(0));
        Add8.add(2, Long.valueOf(0));
        Add8.add(3, Long.valueOf(0));
        Add8.add(4, Long.valueOf(0));
        Add8.add(5, Long.valueOf(0));
        Add8.add(6, Long.valueOf(0));
        Add9.add(0, Long.valueOf(0));
        Add9.add(1, Long.valueOf(0));
        Add9.add(2, Long.valueOf(0));
        Add9.add(3, Long.valueOf(0));
        Add9.add(4, Long.valueOf(0));
        Add9.add(5, Long.valueOf(0));
        Add9.add(6, Long.valueOf(0));
        Add9.add(7, Long.valueOf(0));
        Add10.add(0, Long.valueOf(0));
        Add10.add(1, Long.valueOf(0));
        Add10.add(2, Long.valueOf(0));
        Add10.add(3, Long.valueOf(0));
        Add10.add(4, Long.valueOf(0));
        Add10.add(5, Long.valueOf(0));
        Add10.add(6, Long.valueOf(0));
        Add10.add(7, Long.valueOf(0));
        Add10.add(8, Long.valueOf(0));

        Add.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        Add2.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        Add3.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        Add4.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        Add5.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        Add6.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        Add7.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        Add8.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        Add9.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        Add10.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        long[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        long carry2 = 0;
        long Dfinal = 0;
        ArrayList<Long> Final = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr[i] = Add.get(i) + Add2.get(i) + Add3.get(i) + Add4.get(i) + Add5.get(i) + Add6.get(i) + Add7.get(i) + Add8.get(i) + Add9.get(i) + Add10.get(i);
            Dfinal = carry2 + arr[i];
            carry2 = Dfinal / Hexsixtn;
            Dfinal = Dfinal % Hexsixtn;

            Final.add((Dfinal));
        }
        if (carry2 > 0) {
            Final.add(carry2);
        }
        String FinalStr = "";
        for (int i = 0; i < Final.size(); i++) {
            if (Final.get(i) == 10) {
                FinalStr = FinalStr + "A";
            } else if (Final.get(i) == 11) {
                FinalStr = FinalStr + "B";
            } else if (Final.get(i) == 12) {
                FinalStr = FinalStr + "C";
            } else if (Final.get(i) == 13) {
                FinalStr = FinalStr + "D";
            } else if (Final.get(i) == 14) {
                FinalStr = FinalStr + "E";
            } else if (Final.get(i) == 15) {
                FinalStr = FinalStr + "F";
            } else {
                FinalStr = FinalStr + Final.get(i);
            }

        }
        String Rev = new StringBuffer(FinalStr).reverse().toString();   // 831C000000 -> 000000C138
        String NZ = Rev.replaceFirst("^0+(?!$)", "");                   // 0 -> "" or blank
        return NZ;
    }
    
    static String hexadecimal_division(String a, String b) {                
        long div = convertHexadecimalToDecimal(b);
        String hexa1 = a;
        String End = "";
        String Quo = "", QuoTimeDiv = "";
        String Subtract;
        int IS = 0;

        int i = 0;
        while (convertHexadecimalToDecimal(End) < div) {        // 12 -> 18
            char endChar = hexa1.charAt(i);
            End = End + endChar;
            IS = 1;
            i++;
        }
        ArrayList<String> FinalQuot = new ArrayList<>();
        String FStr = "";
        for (int j = IS; j < hexa1.length(); j++) {
            if (convertHexadecimalToDecimal(End) >= div) {
                Quo = Long.toString(convertHexadecimalToDecimal(End) / div);
                if (Quo.equals("10") || Quo.equals("11") || Quo.equals("12") || Quo.equals("13") || Quo.equals("14") || Quo.equals("15")) {
                    switch (Quo) {
                        case "10":
                            Quo = "A";
                            break;
                        case "11":
                            Quo = "B";
                            break;
                        case "12":
                            Quo = "C";
                            break;
                        case "13":
                            Quo = "D";
                            break;
                        case "14":
                            Quo = "E";
                            break;
                        case "15":
                            Quo = "F";
                            break;
                    }
                }
                FinalQuot.add(Quo);

                QuoTimeDiv = hexadecimal_multiplication(Quo, b);
                if (j == hexa1.length() - 1) {
                    Subtract = hexadecimal_subtraction(End, QuoTimeDiv);
                } else {
                    Subtract = hexadecimal_subtraction(End, QuoTimeDiv) + hexa1.charAt(j + 1);
                }

                End = Subtract;
                FStr += Quo;
            }
        }
        return FStr;
    }
    
    public static void main(String[] args) {
        int mainchoice, mainoperation;
        
        try {
            do {
                // Initialization of input values
                long bin1, bin2;
                int oct1, oct2;
                String hex1, hex2;

                // Display the number system menu
                mainchoice = displayMenu();
                System.out.println("");

                if(mainchoice == 1) {       // if Binary
                    do {
                        System.out.println("===Binary Number Operation===");
                        mainoperation = displayOperation();
                        System.out.println("");

                        if(mainoperation == 1) {        // if Addition
                            do {
                                System.out.print("Enter First Binary Number: ");
                                bin1 = in.nextInt();
                                if(isBinaryNumber(bin1) == false)
                                    System.out.println("\nEntered number is not a Binary number!\n");
                            }while(isBinaryNumber(bin1) == false);
                            do {
                                System.out.print("\nEnter Second Binary Number: ");
                                bin2 = in.nextInt();
                                if(isBinaryNumber(bin2) == false)
                                    System.out.println("\nEntered number is not a Binary number!\n");
                            }while(isBinaryNumber(bin2) == false);
                            binary_addition(bin1, bin2);
                        }

                        if(mainoperation == 2) {        // if Subtraction
                            do {
                                System.out.print("Enter First Binary Number: ");
                                bin1 = in.nextInt();
                                if(isBinaryNumber(bin1) == false)
                                    System.out.println("\nEntered number is not a Binary number!\n");
                            }while(isBinaryNumber(bin1) == false);
                            do {
                                System.out.print("\nEnter Second Binary Number: ");
                                bin2 = in.nextInt();
                                if(isBinaryNumber(bin2) == false){
                                    System.out.println("\nEntered number is not a Binary number!\n");
                                }
                            }while(isBinaryNumber(bin2) == false);
                            String bin1Copy = Long.toString(bin1), bin2Copy = Long.toString(bin2);
                            if(bin1Copy.length() > bin2Copy.length())       // if the First number is greater than the Second number
                                System.out.println("\n" + bin1 + " - " + bin2 + " = " + binary_subtraction(bin1Copy, bin2Copy));
                            else
                                System.out.println("\n" + bin2 + " - " + bin1 + " = " + binary_subtraction(bin2Copy, bin1Copy));
                            System.out.println("\n");
                        }        

                        if(mainoperation == 3) {        // if Multiplication
                            do {
                                System.out.print("Enter First Binary Number: ");
                                bin1 = in.nextInt();
                                if(isBinaryNumber(bin1) == false)
                                    System.out.println("\nEntered number is not a Binary number!\n");
                            }while(isBinaryNumber(bin1) == false);
                            do {
                                System.out.print("\nEnter Second Binary Number: ");
                                bin2 = in.nextInt();
                                if(isBinaryNumber(bin2) == false)
                                    System.out.println("\nEntered number is not a Binary number!\n");
                            }while(isBinaryNumber(bin2) == false);
                            System.out.println("\n" + bin1 + " * " + bin2 + " = " + binary_multiplication(bin1, bin2));
                            System.out.println("\n");
                        }      

                        if(mainoperation == 4) {        // if Division
                            do {
                                System.out.print("Enter First Binary Number: ");
                                bin1 = in.nextLong();
                                if(isBinaryNumber(bin1) == false)
                                    System.out.println("\nEntered number is not a Binary number!\n");
                            }while(isBinaryNumber(bin1) == false);
                            do {
                                System.out.print("\nEnter Second Binary Number: ");
                                bin2 = in.nextLong();
                                if(bin2 == 0)
                                    System.out.println("\nError: can't divide by 0");
                                if(isBinaryNumber(bin2) == false)
                                    System.out.println("\nEntered number is not a Binary number!\n");
                            }while(isBinaryNumber(bin2) == false || bin2 == 0);
                            if(convertBinaryToDecimal(Long.toString(bin1)) > convertBinaryToDecimal(Long.toString(bin2)))
                                System.out.println("\n" + bin1 + " / " + bin2 + " = " + binary_division(bin1, bin2));
                            else
                                System.out.println("\n" + bin2 + " / " + bin1 + " = " + binary_division(bin2, bin1));
                            System.out.println("\n");
                        }        
                    }while(mainoperation != 5);
                }    

                if(mainchoice == 2) {       // if Octal
                    do {
                        System.out.println("===Octal Number Operation===");
                        mainoperation = displayOperation();
                        System.out.println("");

                        if(mainoperation == 1) {        // if Addition
                            do {
                                System.out.print("Enter First Octal Number: ");
                                oct1 = in.nextInt();
                                if(isOctalNumber(oct1) == false)
                                    System.out.println("\nEntered number is not an Octal number!\n");
                            }while(isOctalNumber(oct1) == false);
                            do {
                                System.out.print("\nEnter Second Octal Number: ");
                                oct2 = in.nextInt();
                                if(isOctalNumber(oct2) == false)
                                    System.out.println("\nEntered number is not an Octal number!\n");
                            }while(isOctalNumber(oct2) == false);
                            System.out.print("\n" + oct1 + " + " + oct2 + " = " + octal_addition(oct1, oct2));
                            System.out.println("\n");
                        }

                        if(mainoperation == 2) {        // if Subtraction
                            do {
                                System.out.print("Enter First Octal Number: ");
                                oct1 = in.nextInt();
                                if(isOctalNumber(oct1) == false)
                                    System.out.println("\nEntered number is not an Octal number!\n");
                            }while(isOctalNumber(oct1) == false);
                            do {
                                System.out.print("\nEnter Second Octal Number: ");
                                oct2 = in.nextInt();
                                if(isOctalNumber(oct2) == false)
                                    System.out.println("\nEntered number is not an Octal number!\n");
                            }while(isOctalNumber(oct2) == false);
                            if(oct1 > oct2)       // if the First number is greater than the Second number
                                System.out.print("\n" + oct1 + " - " + oct2 + " = " + octal_subtraction(oct1, oct2));
                            else
                                System.out.print("\n" + oct2 + " - " + oct1 + " = " + octal_subtraction(oct2, oct1));
                            System.out.println("\n");
                        }

                        if(mainoperation == 3) {        // if Multiplication
                            do {
                                System.out.print("Enter First Octal Number: ");
                                oct1 = in.nextInt();
                                if(isOctalNumber(oct1) == false)
                                    System.out.println("\nEntered number is not an Octal number!\n");
                            }while(isOctalNumber(oct1) == false);
                            do {
                                System.out.print("\nEnter Second Octal Number: ");
                                oct2 = in.nextInt();
                                if(isOctalNumber(oct2) == false)
                                    System.out.println("\nEntered number is not an Octal number!\n");
                            }while(isOctalNumber(oct2) == false);
                                System.out.print("\n" + oct1 + " * " + oct2 + " = " + octal_multiplication(oct1, oct2));
                            System.out.println("\n");
                        }

                        if(mainoperation == 4) {        // if Division
                            do {
                                System.out.print("Enter First Octal Number: ");
                                oct1 = in.nextInt();
                                if(isOctalNumber(oct1) == false)
                                    System.out.println("\nEntered number is not an Octal number!\n");
                            }while(isOctalNumber(oct1) == false);
                            do {
                                System.out.print("\nEnter Second Octal Number: ");
                                oct2 = in.nextInt();
                                if(isOctalNumber(oct2) == false)
                                    System.out.println("\nEntered number is not an Octal number!\n");
                            }while(isOctalNumber(oct2) == false || oct2 == 0);
                            if(oct1 > oct2)
                                System.out.print("\n" + oct1 + " / " + oct2 + " = " + octal_division(oct1, oct2));
                            else
                                System.out.print("\n" + oct2 + " / " + oct1 + " = " + octal_division(oct2, oct1));
                            System.out.println("\n");
                        }
                    }while(mainoperation != 5);
                }        

                if(mainchoice == 3) {       // if Hexadecimal
                    do {
                        System.out.println("===Hexadecimal Number Operation===");
                        mainoperation = displayOperation();
                        System.out.println("");

                        if(mainoperation == 1) {        // if Addition
                            do {
                                System.out.print("Enter First Hexadecimal Number: ");
                                hex1 = in.next().toUpperCase();
                                if(isHexadecimalNumber(hex1) == false)
                                    System.out.println("\nEntered number is not a Hexadecimal number!\n");
                            }while(isHexadecimalNumber(hex1) == false);
                            do {
                                System.out.print("\nEnter Second Hexadecimal Number: ");
                                hex2 = in.next().toUpperCase();
                                if(isHexadecimalNumber(hex2) == false)
                                    System.out.println("\nEntered number is not a Hexadecimal number!\n");
                            }while(isHexadecimalNumber(hex2) == false);
                            System.out.println("\n" + hex1 + " + " + hex2 + " = " + hexadecimal_addition(hex1, hex2));
                            System.out.println("\n");
                        }

                        if(mainoperation == 2) {        // if Subtraction
                            do {
                                System.out.print("Enter First Hexadecimal Number: ");
                                hex1 = in.next().toUpperCase();
                                if(isHexadecimalNumber(hex1) == false){
                                    System.out.println("\nEntered number is not a Hexadecimal number!\n");
                                }
                            }while(isHexadecimalNumber(hex1) == false);
                            do {
                                System.out.print("\nEnter Second Hexadecimal Number: ");
                                hex2 = in.next().toUpperCase();
                                if(isHexadecimalNumber(hex2) == false)
                                    System.out.println("\nEntered number is not a Hexadecimal number!\n");
                            }while(isHexadecimalNumber(hex2) == false);
                            if(convertHexadecimalToDecimal(hex1) > convertHexadecimalToDecimal(hex2))       // if the First number is greater than the Second number
                                System.out.println("\n" + hex1 + " - " + hex2 + " = " + hexadecimal_subtraction(hex1, hex2));
                            else
                                System.out.println("\n" + hex2 + " - " + hex1 + " = " + hexadecimal_subtraction(hex2, hex1));
                            System.out.println("\n");
                        }

                        if(mainoperation == 3) {        // if Multiplication
                            do {
                                System.out.print("Enter First Hexadecimal Number: ");
                                hex1 = in.next().toUpperCase();
                                if(isHexadecimalNumber(hex1) == false)
                                    System.out.println("\nEntered number is not a Hexadecimal number!\n");
                            }while(isHexadecimalNumber(hex1) == false);
                            do {
                                System.out.print("\nEnter Second Hexadecimal Number: ");
                                hex2 = in.next().toUpperCase();
                                if(isHexadecimalNumber(hex2) == false)
                                    System.out.println("\nEntered number is not a Hexadecimal number!\n");
                            }while(isHexadecimalNumber(hex2) == false);
                            System.out.println("\n" + hex1 + " * " + hex2 + " = " + hexadecimal_multiplication(hex1, hex2));
                            System.out.println("\n");
                        }

                        if(mainoperation == 4) {        // if Division
                           do {
                                System.out.print("Enter First Hexadecimal Number: ");
                                hex1 = in.next().toUpperCase();
                                if(isHexadecimalNumber(hex1) == false)
                                    System.out.println("\nEntered number is not a Hexadecimal number!\n");
                            }while(isHexadecimalNumber(hex1) == false);
                            do {
                                System.out.print("\nEnter Second Hexadecimal Number: ");
                                hex2 = in.next().toUpperCase();
                                if(hex2 == "0")
                                    System.out.println("\nCannot divide by 0!");
                                if(isHexadecimalNumber(hex2) == false)
                                    System.out.println("\nEntered number is not a Hexadecimal number!\n");
                            }while(isHexadecimalNumber(hex2) == false || hex2 == "0");
                            System.out.println("\n" + hex1 + " / " + hex2 + " = " + hexadecimal_division(hex1, hex2));
                            System.out.println("\n");
                        }
                    }while(mainoperation != 5);
                }        
            }while(mainchoice != 4);
        } catch (Exception e) {
            System.out.println("\nError: " + e);
        }
    }
}
