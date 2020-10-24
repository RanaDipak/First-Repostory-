#include <stdio.h>
#include <stdlib.h>
struct node
{
    int info;
    struct node *link;
};
struct node *start = NULL;
struct node *createNode()
{
    struct node *n;
    n = (struct node *)malloc(sizeof(struct node));
    return (n);
}
int insertNode()
{
    struct node *temp, *t,*pred,*first;
    
    if (start == NULL)
    {
        temp = createNode();
        printf("\nEnter your number : ");
        scanf("%d", &temp->info);
        temp->link = NULL;
        start = temp;
    }
    else
    {
        temp = createNode();
        printf("\nEnter your number : ");
        scanf("%d", &temp->info);
        // temp->link = NULL;
        
    // struct node *first;
    first = start;

    if (first->link == NULL)
    {
        temp->link = NULL;              
        first->link=temp;
        return 0;
    }

    if (temp->info <= first->info)
    {
        temp->link = first;                 
        start=temp;
        return 0;
    }
    struct node *save;
    save = first;
    
    while (save->link != NULL & temp->info >= save->info)
    {
        pred=save;
        save = save->link; 
            
    }
    if(save->link!=NULL & temp->info<=save->info){
            
            pred->link=temp;
            temp->link=save;
            return 0;
    }
             temp->link = save->link;
            save->link = temp;
       }
        // return (first);
}




void deleteNode()
{
    struct node *r;
    if (start == NULL)
        printf("\t\t<<<List is empty.>>>");
    else
    {
        r = start;
        start = start->link;
        free(r);
    }
}
void viewList()
{
    struct node *t;
    if (start == NULL)
        printf("\t\t<<<List is empty.>>>");
    else
    {
        t = start;
        printf("\t\t Your choice is : ");
        while (t != NULL)
        {
            printf("%d  ", t->info);
            t = t->link;
        }
    }
}
int menu()
{
    int ch;
    printf("\n\n1. Add values to the list.");
    printf("\n2. Delete the values to the list.");
    printf("\n3. View to the list");
    printf("\n4. Exit");
    printf("\n Enter your choice : ");
    scanf("%d", &ch);
    return (ch);
}
void main()
{
    while (1)
    {
        switch (menu())
        {
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

        default:
            printf("\t\t<<<Invalid chioce>>>");
        }
    }
}