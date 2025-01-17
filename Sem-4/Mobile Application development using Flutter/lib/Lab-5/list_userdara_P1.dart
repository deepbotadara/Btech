import 'dart:io';

class userData {
  List<int> numbers = [];

  void inputData() {
    for (int i = 0; i < 5; i++) {
      print("Enter number ${i + 1}:");
      numbers.add(int.parse(stdin.readLineSync()!));
    }
    Sorting();
  }

  void printData() {
    print("List Contains:");
    for (int j = 0; j < 5; j++) {
      print(numbers[j]);
    }
  }

  void Sorting() {
    for (int k = 0; k < 5; k++) {
      for (int l = 0; l < 5 - k - 1; l++) {
        if (numbers[l] > numbers[l + 1]) {
          int temp = numbers[l];
          numbers[l] = numbers[l + 1];
          numbers[l + 1] = temp;
        }
      }
      printData();
    }
  }
}

void main() {
  userData u = new userData();
  u.inputData();
}