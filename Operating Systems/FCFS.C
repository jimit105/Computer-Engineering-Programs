/* FIRST COME, FIRST SERVE */

#include<stdio.h>
#include<conio.h>

int main()
{
    int bt[20],p[20],wt[20],tat[20],i,j,n,total=0,pos,temp;
    float avg_wt,avg_tat;
    clrscr();
    printf("Enter number of process:");
    scanf("%d",&n);

    printf("\nEnter Burst Time:\n");
    for(i=0;i<n;i++)
    {
	printf("p%d:",i+1);
	scanf("%d",&bt[i]);
	p[i]=i+1;           //contains process number
    }

     wt[0]=0;            //waiting time for first process will be zero

    //calculate waiting time
    for(i=1;i<n;i++)
    {
	wt[i]=0;
	for(j=0;j<i;j++)
	    wt[i]+=bt[j];

	total+=wt[i];
    }

    avg_wt=(float)total/n;      //average waiting time
    total=0;

    printf("\nProcess\t    Burst Time    \tWaiting Time\tTurnaround Time");
    for(i=0;i<n;i++)
    {
	tat[i]=bt[i]+wt[i];     //calculate turnaround time
	total+=tat[i];
	printf("\np%d\t\t  %d\t\t    %d\t\t\t%d",p[i],bt[i],wt[i],tat[i]);
    }

    avg_tat=(float)total/n;     //average turnaround time
    printf("\n\nAverage Waiting Time=%.2f",avg_wt);
    printf("\nAverage Turnaround Time=%.2f\n",avg_tat);

 getch();
 return 0;
}