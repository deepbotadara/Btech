import 'dart:io';

void main(){
  
  int num;
  
  bool flag = true ;

  print("Enter a number: ");
  num=int.parse(stdin.readLineSync()!);

  for(int i=2;i<=num;i++){

    if(num%i==0){
      flag = false;
      break;
    }

  }

  if(flag){
      print("Number $num is prime");
  }
  else{
    print("Number $num is not prime");
  }

}