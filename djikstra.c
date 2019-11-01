#include<stdio.h>
void djk(int,int [][10],int);
#define INFINITY 999
void main()
{
int c[10][10],i,j,v,n,s;
printf("enter the no.of vertices\n");
scanf("%d",&v);
printf("Enter the adjacency matrix\n");
for(i=0;i<v;i++)
{
for(j=0;j<v;j++)
{scanf("%d",&c[i][j]);
if( c[i][j]==0)
c[i][j]=INFINITY;
}
}
printf("enter the starting node\n");
scanf("%d",&s);
djk(v,c,s);
}
void djk(int v,int c[10][10],int s)
{
int dist[10],pred[10],nextnode;
int visited[10],count,i,j,mindistance;
for(i=0;i<v;i++)
{
dist[i]=c[s][i];
pred[i]=s;
visited[i]=0;}

dist[s]=0;
visited[s]=1;
count=1;
while(count<v-1)
{
mindistance=INFINITY;
for(i=0;i<v;i++)
if(dist[i]<mindistance &&!visited[i])
{
mindistance=dist[i];
nextnode=i;
}
visited[nextnode]=1;
for(i=0;i<v;i++)
if(!visited[i])
if(mindistance+c[nextnode][i]<dist[i])
{
dist[i]=mindistance+c[nextnode][i];
pred[i]=nextnode;
}
count++;
}
for(i=0;i<v;i++)
if(i!=s)
{
printf("DISTANCE OF NODE %d = %d",i,dist[i]);
printf("\npath=%d",i);
j=i;
do{
j=pred[j];
printf("<- %d",j);
}while(j!=s);
}
}


Output:
enter the no.of vertices                                                                                                        
4                                                                                                                               
Enter the adjacency matrix                                                                                                      
0                                                                                                                               
1                                                                                                                               
0                                                                                                                               
2                                                                                                                               
1                                                                                                                               
0                                                                                                                               
3                                                                                                                               
5                                                                                                                               
0                                                                                                                               
3                                                                                                                               
0                                                                                                                               
8                                                                                                                               
2                                                                                                                               
5                                                                                                                               
8                                                                                                                               
0                                                                                                                               
enter the starting node                                                                                                         
3                                                                                                                               
DISTANCE OF NODE 0 = 2                                                                                                          
path=0<- 3DISTANCE OF NODE 1 = 3                                                                                                
path=1<- 0<- 3DISTANCE OF NODE 2 = 6                                                                                                     
path=2<- 1<- 0<- 3   