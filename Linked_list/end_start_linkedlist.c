#include<stdio.h>
#include<stdlib.h>
struct node
{
    int info;
    struct node *link; 
};
struct node *start=NULL;
struct node* createNode(){
    struct node *n;
    n=(struct node *)malloc(sizeof(struct node));
    return(n);
}

                    // INSERT NODE
void insertNode(){
    struct node *temp,*first,*t;
    temp=createNode();
    
    if(start==NULL){
         printf("Enter your number : ");
        scanf("%d",&temp->info);
        temp->link=NULL;
        start=temp;
    }
   else{
    first=start;
    if(first->link==NULL){
        // struct node *temp1;
        temp=createNode();
        printf("Enter your number : ");
        scanf("%d",&temp->info);
        temp->link=NULL;
    }
    else
    { 
        temp=createNode();
        printf("Enter your number : ");
        scanf("%d",&temp->info);
        temp->link=NULL;
    }
    
    struct node *save;
    save=first;
    while (save->link!=NULL){
        save=save->link;
    }
    save->link=temp;
   }
  
}

                        // DELETE NODE
void deleteNode(){
    struct node *r,*del;
    if(start==NULL){
        printf("Node is empty.");
    }
    else
    {
        r=start;
        while(r->link!=NULL){
            del=r;
            r=r->link;
        }
        del->link=NULL;
        free(r);
    }
    
}

                            // DESPLAY NODE
int  viewList(){
    struct node *t;
    if(start==NULL)
    printf("\t\t<<<List is empty.>>>");
    else
    {
        t=start;
        printf("\t\t Your choice is : ");
        while(t!=NULL){
            printf("%d  ",t->info);
            t=t->link;
        }
        if(t==NULL){
            return 0;
        }
    }
}
int menu(){
    int ch;
    printf("\n\n1. Add values to the list.");
    printf("\n2. Delete the values to the list.");
    printf("\n3. View to the list");
    printf("\n4. Exit");
    printf("\n Enter your choice : ");
    scanf("%d",&ch);
    return(ch);
}
void main(){
    while(1){
        switch(menu()){
            case 1:
            insertNode();
            break;

            case 2:
            deleteNode();
            break;

            case 3:
            viewList();
            break;

            case 4:
            exit(0);
            
            default :
            printf("\t\t<<<Invalid chioce>>>");
        }
    }
}
