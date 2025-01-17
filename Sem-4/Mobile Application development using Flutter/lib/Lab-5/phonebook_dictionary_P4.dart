import 'dart:io';

class PhoneBook{
  Map<String,int> map={};
 
  void inputData(){
    for(int i=0;i<3;i++){
      print("Enter your name for ${i+1}: ");
      String name=stdin.readLineSync()!;
      print("Enter your phone number: ${i+1} ");
      int number=int.parse(stdin.readLineSync()!);
      map[name]=number;
    }
  printData();    
}

  void printData(){
    print(map);
  }
}
void main(){
  PhoneBook p=new PhoneBook();
  p.inputData();
}