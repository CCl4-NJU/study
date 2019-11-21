#include <iostream>
#include <stdio.h>
#include <string.h>
using namespace std;
struct Node{
    Node *lChild;
    Node *rChild;
    char data;
}Tree[50];
int loc=0;
Node *creat(){
    Tree[loc].lChild = Tree[loc].rChild = NULL;
    return &Tree[loc++];
}
char str1[30],str2[30];
void postOrder(Node *T){
    if(T->lChild != NULL){
        postOrder(T->lChild);
    }
    if(T->rChild != NULL){
        postOrder(T->rChild);
    }
    printf("%c", T->data);
}
Node* build(int s1,int e1,int s2,int e2){
    char root = str1[s1];
    int lend = 0;
    for(int i=0; i<=e2;i++){
        if(root == str2[i]){
            lend = i;
            break;
        }
    }
    Node *node = creat();
    node->data = root;
    if(lend != s2){
            node->lChild = build(s1+1,s1+(lend-s2),s2, lend-1 );
    }
    if(lend != e2){
            node->rChild = build(s1+(lend-s2)+1, e1,lend + 1, e2 );
    }
    return node;
}
int main()
{
    while(scanf("%s", str1)!=EOF){
        scanf("%s", str2);
        Node *node = build(0, strlen(str1)-1, 0, strlen(str2)-1);
        postOrder(node);
    }
    return 0;
}
