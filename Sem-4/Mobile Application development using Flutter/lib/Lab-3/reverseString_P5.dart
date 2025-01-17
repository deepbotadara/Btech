import 'dart:io';

void main(){
  String string;
  print("Enter a String: ");
  string = stdin.readLineSync()!;

  for(int i=string.length-1;i>=0;i--){
    stdout.write(string[i]); 
  }
}