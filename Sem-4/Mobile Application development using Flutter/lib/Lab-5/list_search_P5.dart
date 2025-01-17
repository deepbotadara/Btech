import 'dart:io';

class SearchList{
  
  Map<String,int> map = {};
  String search='';
  String name='';
  int? number;
   void inputData(){
    for(int i=0;i<3;i++){
      print("Enter your name for ${i+1}: ");
      String name=stdin.readLineSync()!;
      print("Enter your Roll number: ${i+1} ");
      int number=int.parse(stdin.readLineSync()!);
      map[name]=number;
    }
   // searchOperation();
  //printData();    
  }

  void searchOperation(){
    print('Enter what you want to Search: ');
    search = stdin.readLineSync()!;
    for(var element in map.entries){
      if(element.key.contains(search) || element.value.toString().contains(search)){
          printResult('${element.key} . ${element.value}');
      }
    }
  }

  void printResult(String result){
    print(result);
  } 

  void printData(){
    for(var element in map.entries){
      print('${element.key} . ${element.value}');
    }
  }
}
void main(){
  SearchList s1 = new SearchList();
  s1.inputData();
  s1.printData();
  s1.searchOperation();
 // s1.printData();
}