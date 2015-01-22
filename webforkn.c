int forkn(int n,char* argv[])
{
int i,nb;
for(i=1;i<=nb;i++)
switch(fork())
{
case 0:return i;execlp(argv[i]);
default:return -1;
}
return 0;
}
