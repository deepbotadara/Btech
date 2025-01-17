import 'dart:io';

void main() {
  double n1, n2;

  stdout.write("Enter Number 1: ");
  n1 = double.parse(stdin.readLineSync()!);

  stdout.write("Enter Number 2: ");
  n2 = double.parse(stdin.readLineSync()!);

  maxChecker(n1: n1);
  maxChecker(n2: n2);
}

void maxChecker({double? n1 = 10, double n2 = 50}) {
  if (n1! > n2) {
    print('Max number is: $n1');
  } else if (n1 == n2) {
    print("Equal numbers");
  } else {
    print('Max number is: $n2');
  }
}
