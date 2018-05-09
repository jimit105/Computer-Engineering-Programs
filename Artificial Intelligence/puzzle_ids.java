		/* 8 Puzzle using IDS */

import java.util.*;
import java.io.*;

class puzzle_ids {
    public static int limit = 0;
    
    public static void main(String args[]) {
        int number;
        int start[][] = {{3,2,1},{5,6,0},{7,8,4}};
        int goal[][] = {{0,3,2},{5,6,1},{7,8,4}};
        System.out.print("Enter Limit: ");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        System.out.println();
        ids(start, goal, number);
    }
    
    public static void ids(int start[][], int goal[][], int number) {
        int i, j;
        limit++;
        int count = 0;
        int a[][] = up(start, goal, limit);
        int b[][] = down(start, goal, limit);
        int c[][] = left(start, goal, limit);
        int d[][] = right(start, goal, limit);

        if (limit <= number) {
            again(a, goal);
            again(b, goal);
            again(c, goal);
            again(d, goal);
        }
    }
    
    public static void again(int a1[][], int goal[][]) {
        int a[][] = up(a1, goal, limit);
        int b[][] = down(a1, goal, limit);
        int c[][] = left(a1, goal, limit);
        int d[][] = right(a1, goal, limit);
        ids(a,goal,limit);
		ids(b,goal,limit);
		ids(c,goal,limit);
		ids(d,goal,limit);
    }
    
    public static int[][] up(int start[][], int goal[][], int limit) {
        int s;
        limit++;
        int a[][] = new int[5][5];
        int temp;
        int count = 0;
        int i, j;
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                a[i][j] = start[i][j];
            }
        }
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                if (a[i][j] == 0) {
                    s = i - 1;
                    if (s >= 0) {
                        temp = a[i][j];
                        a[i][j] = a[i - 1][j];
                        a[i - 1][j] = temp;
                        System.out.println("up");
                        for (i = 0; i <= 2; i++) {
                            for (j = 0; j <= 2; j++) {
                                System.out.print(a[i][j]);
                            }
                        }
                        System.out.println("");
                        break;
                    } else {
                        break;
                    }

                }
            }
        }
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                if (goal[i][j] == a[i][j]) {
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("\nGoal Achieved at Level: " + (limit-1));
            end();
        }
        return a;
    }
    
    public static int[][] down(int[][] start, int[][] goal, int limit) {
        int d[][] = new int[5][5];
        int a = start[2][2];
        int s1;
        int temp;
        int count = 0;
        int i, j;
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                d[i][j] = start[i][j];
            }
        }
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                if (start[i][j] == 0) {
                    s1 = i + 1;
                    if (s1 <= 2) {
                        temp = d[i][j];
                        d[i][j] = d[i + 1][j];
                        d[i + 1][j] = temp;
                        System.out.println("down");
                        for (i = 0; i <= 2; i++) {
                            for (j = 0; j <= 2; j++) {
                                System.out.print(d[i][j]);
                            }
                        }
                        System.out.println("");
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                if (goal[i][j] == d[i][j]) {
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("\nGoal Achieved at Level: " + (limit-1));
            end();
        }
        return (d);
    }

    public static int[][] left(int start[][], int goal[][], int limit) {
        int s2, i, j;
        int temp;
        int count = 0;
        int b[][] = new int[5][5];
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                b[i][j] = start[i][j];
            }
        }
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                if (b[i][j] == 0) {
                    s2 = j - 1;
                    if (s2 >= 0) {
                        temp = b[i][j];
                        b[i][j] = b[i][j - 1];
                        b[i][j - 1] = temp;
                        System.out.println("left");
                        for (i = 0; i <= 2; i++) {
                            for (j = 0; j <= 2; j++) {
                                System.out.print(b[i][j]);
                            }
                        }
                        System.out.println("");
                        break;
                    } else {
                        break;
                    }

                }
            }
        }
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                if (goal[i][j] == b[i][j]) {
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("\nGoal Achieved at Level: " + (limit-1));
            end();
        }
        return b;
    }

    public static int[][] right(int start[][], int goal[][], int limit) {
        int s3, i, j;
        int temp;
        int count = 0;
        int c[][] = new int[5][5];
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                c[i][j] = start[i][j];
            }
        }
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {

                if (c[i][j] == 0) {
                    s3 = j + 1;
                    if (s3 <= 2) {
                        temp = c[i][j];
                        c[i][j] = c[i][j + 1];
                        c[i][j + 1] = temp;
                        System.out.print("right");

                        for (i = 0; i <= 2; i++) {
                            for (j = 0; j <= 2; j++) {
                                System.out.print(c[i][j]);
                            }
                        }
                        System.out.println("");
                        break;
                    } else {
                        break;
                    }
                }
            }
        }
        for (i = 0; i <= 2; i++) {
            for (j = 0; j <= 2; j++) {
                if (goal[i][j] == c[i][j]) {
                    count++;
                }
            }
        }
        if (count == 9) {
            System.out.println("\nGoal Achieved at Level: " + (limit-1));
            end();
        }
        return c;
    }
    
    public static void end() {
        System.out.println("Search Complete!");
        System.exit(0);
    }
}

/* OUTPUT
 *
 *Enter Limit: 5

up
320561784
down
321564780
left
321506784
down
321560784
left
302561784
down
321560784
left
302561784
up
320561784
down
321564780
left
321506784
down
362501784
left
032561784

Goal Achieved at Level: 3
Search Complete!
*/
