import 'dart:io';
void main(){

  int n1;

  stdout.write("Enter a number:");
  n1=int.parse(stdin.readLineSync()!);

  if(n1>0){
      stdout.write("Number $n1 is Positive");
  }
  else if (n1<0){
      stdout.write("Number $n1 is negative");
  }
  else{
      stdout.write("Number $n1 is neutral ");
  }
}