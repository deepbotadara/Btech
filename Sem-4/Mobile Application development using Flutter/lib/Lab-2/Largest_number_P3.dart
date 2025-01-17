import 'dart:io';

void main(){

  int n1,n2,n3;

  stdout.write("Enter number 1:");
  n1=int.parse(stdin.readLineSync()!);

  stdout.write("Enter number 2:");
  n2=int.parse(stdin.readLineSync()!);

  stdout.write("Enter number 3:");
  n3=int.parse(stdin.readLineSync()!);

  if(n1>n2) {
    if (n1 > n3) {
      stdout.write("$n1 is largest number");
    }
  }
  else if(n2>n3){
        stdout.write("$n2 is largest number");
  }
  else{
      stdout.write("$n3 is largest number");
  }

}