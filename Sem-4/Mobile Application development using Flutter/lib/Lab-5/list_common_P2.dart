import 'dart:io';

class commonList {
  List<int> list = [];
  List<int> list2 = [];
  List<int> common = [];

  void inputData() {
    print("Enter the first list of numbers");

    for (int i = 0; i < 5; i++) {
      print("Enter number ${i + 1}:");
      list.add(int.parse(stdin.readLineSync()!));
    }

    print("Enter the second list of numbers");
    for (int i = 0; i < 5; i++) {
      print("Enter number ${i + 1}:");
      list2.add(int.parse(stdin.readLineSync()!));
    }

    findCommon();
  }

  void findCommon() {
    for (int i = 0; i < list.length; i++) {
      for (int j = 0; j < list2.length; j++) {
        if (list[i] == list2[j]) {
          common.add(list[i]);
        }
      }
    }
    printList();
  }

  void printList() {
    print("CommonList Contains: ");
    for (int k = 0; k < common.length; k++) {
      print(common[k]);
    }
  }
}

void main() {
  commonList c1 = new commonList();
  c1.inputData();
}