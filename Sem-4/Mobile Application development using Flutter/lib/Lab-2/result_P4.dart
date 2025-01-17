import 'dart:io';

void main(){

  int s1,s2,s3,s4,s5;

  stdout.write("Enter marks of Subject 1:");
  s1=int.parse(stdin.readLineSync()!);

  stdout.write("Enter marks of Subject 2:");
  s2=int.parse(stdin.readLineSync()!);

  stdout.write("Enter marks of Subject 3:");
  s3=int.parse(stdin.readLineSync()!);

  stdout.write("Enter marks of Subject 4:");
  s4=int.parse(stdin.readLineSync()!);

  stdout.write("Enter marks of Subject 5:");
  s5=int.parse(stdin.readLineSync()!);

  double percentage=((s1+s2+s3+s4+s5)/500)*100;
  print("Percentage= $percentage");
  if(percentage>70){
    stdout.write("Distinct");
  }
  else if (percentage>60 && percentage<=70){
    stdout.write("First class");
  }
  else if (percentage>45 && percentage<=60){
    stdout.write("Second class");
  }
  else if(percentage>35 && percentage<=45){
    stdout.write("Pass");
  }
  else if(percentage<=35){
    stdout.write("Fail");
  }
}