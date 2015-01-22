#include<unistd.h>
#include<stdio.h>
#include <sys/types.h>
#include<math.h>
main()
{
int t,i;
pid_t n;
n=fork();
if (n==0)
{
t=getpid()%10;
for(i=t;i>0;i--)
printf("le tepms restant est : %d\n",i);
printf("Terminaison fils\n");
}
else
{
printf("je suis le père\n");
wait();
}
}

