import 'dart:io';

void main(){
  stdout.write("Enter number 1:");
  int n1=int.parse(stdin.readLineSync()!);

  stdout.write("Enter number 2:");
  int n2=int.parse(stdin.readLineSync()!);

  String user_choice=stdin.readLineSync()!;

  switch(user_choice){
    case '+':
      stdout.write("Addition is: ${n1+n2}");
      break;
    case '-':
      stdout.write("Subtraction is: ${n1-n2}");
      break;
    case '*':
      stdout.write("Multiplication is: ${n1*n2}");
      break;
    case '/':
      stdout.write("Division is: ${n1/n2}");
      break;
    default:
      stdout.write("Please enter a valid choice!");
  }
}