//factorial of given number
import 'dart:io';
void main(){

  int num,fact=1;
  
  print("Enter a number: ");
  num=int.parse(stdin.readLineSync()!);

  for(int i=1;i<=num;i++){
      fact *= i;
  }

  stdout.write("Factorial of $num is $fact");
}