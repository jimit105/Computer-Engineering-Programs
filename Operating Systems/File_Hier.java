import java.util.*;

class Directory{
        String name;
        //String parent;
        Vector<String> v;
        Vector<Directory> d;
        public Directory(String x){
            this.name = x;
            v = new Vector<String>();
            d = new Vector<Directory>();
        }
        public void insertf(String x){
           /* if(v.contains(x)){
                x= x+"(1)";
            }*/
            for(String a:v){
                if(a.equals(x)){
                    //flag = 1;
                    x = x+"(1)";
                    break;
                }
            }
            v.addElement(x);
        }
        public boolean searchf(String x){
            //Directory a;
            for(Directory a:d){
            if(a.searchf(x)){
                return true;
            }
        }
            return v.contains(x);
        }
        public void insert(String x){
            for(Directory a:d){
                if(a.name.equals(x)){
                    x = x+"(1)";
                    break;
                }
            }
            Directory n = new Directory(x);
            d.addElement(n);
        }
        public void delf(String x){
            int flag = 0;
            for(String a:v){
                if(a.equals(x)){
                    flag = 1;
                    v.removeElement(a);
                    break;
                }
            }
            if(flag == 0){
                System.out.println("File "+x+" doesn't even exist bro!");
            }
            else{
                System.out.println("File "+x+" was deleted!Hope you're happy!");
            }
        }
        public void del(String x){
            int flag = 0;
            for(Directory a:d){
                if(a.name.equals(x)){
                    flag = 1;
                    d.removeElement(a);
                    break;
                }
            }
            if(flag == 0){
                System.out.println("Directory "+x+" doesn't even exist bro!");
            }
            else{
                System.out.println("Directory "+x+" was deleted!Hope you're happy!");
            }
        }
    }


public class File_Hier {

   
    public static void main(String[] args) {
        Directory s = new Directory("root");
        Stack<Directory> st = new Stack<Directory>();
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        String tp;
        // TODO code application logic here
        while(ch != 8){
            System.out.println("The current Directory is "+s.name);
            if(s.d.isEmpty() && s.v.isEmpty()){
                System.out.println(s.name+" is an empty directory.");
            }
            else{
                if(!(s.d.isEmpty())){
                    System.out.println("The List of directories in "+s.name+" are:");
                    for(Directory a:s.d){
                        System.out.println(a.name);
                    }
                }
                if(!(s.v.isEmpty())){
                    System.out.println("The List of files in "+s.name+" are:");
                    for(String a:s.v){
                        System.out.println(a);
                    }
                }
            }
            System.out.println("Please Enter your choice:");
            System.out.println("1.Add Directory");
            System.out.println("2.Select Directory");
            System.out.println("3.Delete Directory");
            System.out.println("4.Add File");
            System.out.println("5.Search File");
            System.out.println("6.Delete File");
            System.out.println("7.Go back");
            System.out.println("8.Exit");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter the name of the Directory");
                    tp = sc.next();
                    s.insert(tp);
                    break;
                case 2:
                    System.out.println("Enter the name of the Directory");
                    int f = 0;
                    tp = sc.next();
                    for(Directory p:s.d){
                        if(p.name.equals(tp)){
                            f = 1;
                            st.push(s);
                            s = p;
                            break;
                        }
                    }
                    if(f == 0){
                        System.out.println("No such Directory exists!");
                    }
                    break;
                case 3:
                    System.out.println("Enter the name of the Directory");
                    tp = sc.next();
                    s.del(tp);
                    break;
                case 4:
                    System.out.println("Enter the name of the File");
                    tp = sc.next();
                    s.insertf(tp);
                    break;
                case 5:
                    System.out.println("Enter the name of the File");
                    tp = sc.next();
                    if(s.searchf(tp)){
                        System.out.println("File "+tp+" Exists within or within the directories of "+s.name+"!");
                    }
                    break;
                case 6:
                    System.out.println("Enter the name of the File");
                    tp = sc.next();
                    s.delf(tp);
                    break;
                case 7:
                    if(st.isEmpty()){
                        System.out.println("Woah there!You can't go back");
                    }
                    else{
                        s = st.pop();
                    }
                    break;
                case 8:
                    System.out.println("Exit Successful");
                    break;
                default:
                    System.out.println("Invalid Input!Try again");
            }
        }
    }
   }




/*------OUTPUT------
The current Directory is root
root is an empty directory.
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
1
Enter the name of the Directory
abc
The current Directory is root
The List of directories in root are:
abc
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
1
Enter the name of the Directory
pqr
The current Directory is root
The List of directories in root are:
abc
pqr
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
2
Enter the name of the Directory
abc
The current Directory is abc
abc is an empty directory.
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
1
Enter the name of the Directory
xyz
The current Directory is abc
The List of directories in abc are:
xyz
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
2
Enter the name of the Directory
xyz
The current Directory is xyz
xyz is an empty directory.
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
4
Enter the name of the File
test
The current Directory is xyz
The List of files in xyz are:
test
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
2
Enter the name of the Directory
pqr
No such Directory exists!
The current Directory is xyz
The List of files in xyz are:
test
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
4
Enter the name of the File
test1
The current Directory is xyz
The List of files in xyz are:
test
test1
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
5
Enter the name of the File
test
File test Exists within or within the directories of xyz!
The current Directory is xyz
The List of files in xyz are:
test
test1
Please Enter your choice:
1.Add Directory
2.Select Directory
3.Delete Directory
4.Add File
5.Search File
6.Delete File
7.Go back
8.Exit
8
Exit Successful!


*/