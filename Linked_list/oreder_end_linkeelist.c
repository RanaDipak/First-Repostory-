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
void insertNode()
{
    struct node *temp, *t;
    temp = createNode();
    printf("\nEnter your number : ");
    scanf("%d", &temp->info);
    temp->link = NULL;
    if (start == NULL)
    {
        start = temp;
    }
    // else
    // {
    //     t = start;
    //     while (t->link != NULL)
    //     {
    //         t = t->link;
    //     }
    //     t->link = temp;
    // }

    struct node *first;
    first = start;
    if (first == NULL)
    {
        temp->link = NULL;
        //   return temp;
    }
    if (temp->info <= first->info)
    {
        temp->link = first;
        //   return temp;
    }
    struct node *save;
    save = first;
    while (save->link != NULL & temp->info >= (save->link)->info)
    {
        save = save->link;
    }
    temp->link = save->link;
    save->link = temp;
    // return first;

      t = start;
        while (t->link != NULL)
        {
            t = t->link;
        }
        t->link = temp;
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