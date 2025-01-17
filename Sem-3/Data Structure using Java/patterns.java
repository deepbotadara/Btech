 class patterns {

        public static void main(String[] args) {
            // Pattern 1: Square of stars
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            System.out.println();
    
            // Pattern 2: Right angle triangle
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            System.out.println();
            for (int i = 5; i >= 1; i--) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            System.out.println();
    
            int n = 7; // Total height of the hourglass
        
            // Upper half + middle row
            for (int i = n; i > 0; i -= 2) {
                for (int j = 0; j < (n - i) / 2; j++) System.out.print(" ");
                for (int j = 0; j < i; j++) System.out.print("*");
                System.out.println();
            }
    
            // Lower half
            for (int i = 3; i <= n; i += 2) {
                for (int j = 0; j < (n - i) / 2; j++) System.out.print(" ");
                for (int j = 0; j < i; j++) System.out.print("*");
                System.out.println();
            }
    
            // Pattern 3: Pyramid pattern
            for (int i = 1; i <= 5; i++) {
                for (int j = i; j < 5; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            System.out.println();
            
             n = 5; // Maximum width (half of the diamond height)
        
            // Print the upper half of the diamond (including middle row)
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i; j++) System.out.print(" "); // Leading spaces
                for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
                System.out.println();
            }
            
            // Print the lower half of the diamond
            for (int i = n - 1; i >= 1; i--) {
                for (int j = 1; j <= n - i; j++) System.out.print(" "); // Leading spaces
                for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
                System.out.println();
            }
     

            // Pattern 4: Inverted Pyramid
            for (int i = 5; i >= 1; i--) {
                for (int j = i; j < 5; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            System.out.println();
    
            // Pattern 5: Horizontal line of stars
            for (int i = 1; i <= 5; i++) {
                System.out.print("* ");
            }
            System.out.println();
        
             n = 5; // Number of rows (height)
        
        // Print the upper triangle part
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Print the base line
        for (int i = 0; i < n + 2; i++) {
            System.out.print("*");
        }
        System.out.println();
    

            // Pattern 3: Diamond shape
            for (int i = 1; i <= 5; i++) {
                for (int j = i; j < 5; j++) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            for (int i = 4; i >= 1; i--) {
                for (int j = 5; j > i; j--) {
                    System.out.print(" ");
                }
                for (int j = 1; j <= (2 * i - 1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            System.out.println();
    
            // Pattern 4: Numbered pattern
            int number = 1;
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(number++ + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


