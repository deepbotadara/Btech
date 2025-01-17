// WAP to accept a number and check whether the number is prime or not. Use metho`
import 'dart:io';

class primeChecker{
    int isprime(int number){
        for(int i=0; i <= number/2; i++){
            if(number % i == 0){
                return 0;
            }
        }
        return 1;
    }
}
                
void main(){
    primeChecker p = new primeChecker();
    print("Enter a number to check it's prime or not: ");
    int number = int.parse(stdin.readLineSync()!);
    if(p.isprime(number) == 1){
        print("$number is a prime number");
    }
    else{
        print("$number is not a prime number");
    }
}