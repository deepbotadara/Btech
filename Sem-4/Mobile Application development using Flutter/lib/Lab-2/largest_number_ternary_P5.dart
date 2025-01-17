import 'dart:io';

void main(){

  int n1,n2,n3;

  stdout.write("Enter number 1:");
  n1=int.parse(stdin.readLineSync()!);

  stdout.write("Enter number 2:");
  n2=int.parse(stdin.readLineSync()!);

  stdout.write("Enter number 3:");
  n3=int.parse(stdin.readLineSync()!);

  int answer = (n1>n2) ? (n1>n3) ? n1 : n3 : (n2>n3) ? n2 : n3;

  stdout.write("Largest number is: $answer");

}