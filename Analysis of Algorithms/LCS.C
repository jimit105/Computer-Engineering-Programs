		/* LONGEST COMMON SUBSEQUENCE*/

#include<stdio.h>
#include<conio.h>
#include<string.h>
#include<stdlib.h>

int main()
{
 char x[50], y[50], s[50];
 int lcs[50][50];
 int i, j, n, m, k, p, t;
 char dir[50][50];	 //dir is for direction array
 clrscr();

 printf("Enter String 1: ");
 gets(x);
 printf("Enter String 2: ");
 gets(y);

 n=strlen(x);
 m=strlen(y);

 for(i=0;i<n;i++)
  for(j=0;j<m;j++)
   if(x[i]==y[j])
   {
    k=i-1;
    p=j-1;
    if(k==-1 || p==-1)
     lcs[i][j]=1;
    else
     lcs[i][j]=lcs[i-1][j-1]+1;
    dir[i][j]='d';
   }
   else
   {
    k=i-1;
    p=j-1;
    if(k==-1 && p==-1)
     lcs[i][j]=0;
    else if(k==-1)
    {
     lcs[i][j]=lcs[i][j-1];
     dir[i][j]='u';
    }
    else if(p==-1)
    {
     lcs[i][j]=lcs[i-1][j];
     dir[i][j]='l';
    }
    else
    {
     lcs[i][j]=max(lcs[i-1][j], lcs[i][j-1]);  //max is predefined in stdlib.h
     if(lcs[i-1][j] < lcs[i][j-1])
      dir[i][j]='u';
     else
      dir[i][j]='l';
    }
   }

 printf("\n");

 for(i=0;i<n+1;i++)
  printf("0\t");
 printf("\n");

 for(i=0;i<m;i++)
 {
  printf("0\t");
  for(j=0;j<n;j++)
  {
   printf("%d", lcs[j][i]);
   printf("%c\t", dir[j][i]);
  }
  printf("\n");
 }
 i=n-1;
 j=m-1;
 s[m-1+1]='\0';
 t=m-2+1;

 do
 {
  if(x[i]==y[j])
  {
   s[t--]=x[i];
   i--;
   j--;
  }
  else
  {
   k=i-1;
   p=j-1;
   if(k==-1 && p==-1)
    break;
   else if(k==-1)
    j--;
   else if(p==-1)
    i--;
   else if(lcs[i-1][j] > lcs[i][j-1])
    i--;
   else
    j--;
  }
 }while(i!=-1 && j!=-1);

 printf("\nLCS is %s", s);
 printf("\nLength is %d", strlen(s));

 getch();
 return 0;
}

/* OUTPUT

Enter String 1: aabggde
Enter String 2: abge                                                            
                                                                                
0       0       0       0       0       0       0       0                       
0       1d      1d      1l      1l      1l      1l      1l                      
0       1u      1l      2d      2l      2l      2l      2l                      
0       1u      1l      2u      3d      3d      3l      3l                      
0       1u      1l      2u      3u      3l      3l      4d                      
                                                                                
LCS is abge
Length is 4
*/
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
