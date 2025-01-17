import 'dart:io';

class addition {
  List<int> numbers = [];
  int sum = 0;

  void add(int size) {
    for (int i = 0; i < size; i++) {
      print("Enter ${i + 1} number: ");
      numbers.add(int.parse(stdin.readLineSync()!));
    }
    checkDivisible();
  }

  void checkDivisible() {
    for (var element in numbers) {
      if (element % 3 == 0 || element % 5 == 0) {
        sum = sum + element;
      }
    }
    printData(sum);
  }

  void printData(int sum) {
    stdout.write('\nSum of Number which are divisible by 3 or 5 is: $sum');
  }
}

void main() {
  addition a1 = new addition();
  stdout.write("Enter how many numbers you want to add in array: ");
  int s = int.parse(stdin.readLineSync()!);
  a1.add(s);
}