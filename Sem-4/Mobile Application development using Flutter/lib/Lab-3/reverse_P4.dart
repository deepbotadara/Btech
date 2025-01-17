//reverse a number 
import 'dart:io';

void main(){

  int num;

  print("Enter a number:");
  num= int.parse(stdin.readLineSync()!);
  
  int last, rev=0;
  while(num > 0){
  last = num % 10;
  rev = rev * 10 + last;
  num = num ~/ 10;
  }
  print("Reverse number: $rev");
}