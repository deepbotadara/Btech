class replaceListElements {
  List<String> list = ['Delhi', 'Mumbai', 'Bangalore', 'Hydrabad', 'Ahmedabad'];

  void ReplaceElement() {
    int index = list.indexOf('Ahmedabad');
    list[index] = 'Surat';
    printList();
  }

  void printList() {
    print("\nList after Replacement:");
    for (int k = 0; k < list.length; k++) {
      print(list[k]);
    }
  }
}

void main() {
  replaceListElements r1 = new replaceListElements();
  print("\nList before Replacement:");
  r1.printList();
  r1.ReplaceElement();
}