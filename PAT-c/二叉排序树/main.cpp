#include <iostream>
#include <stdio.h>
using namespace std;
struct Node{
    Node *lChild;
    Node *rChild;
    int value;
}Tree[100];
int loc = 0;
Node* create(){
    Tree[loc].lChild = Tree[loc].rChild = NULL;
    return &Tree[loc++];
}
Node* Insert(Node *T,int value){
    if(T!=NULL){
        if(T->value > value){
            T->lChild = Insert(T->lChild, value);
        }else{
            T->rChild = Insert(T->rChild, value);
        }
        return T;
    }else{
        T = create();
        T->value = value;
        return T;
    }
}
void inOrder(Node* T){
    if(T->lChild != NULL){
        inOrder(T->lChild);
    }
    printf("%d ", T->value);
    if(T->rChild != NULL){
        inOrder(T->rChild);
    }
}
void preOrder(Node* T){
    printf("%d ", T->value);
    if(T->lChild != NULL){
        preOrder(T->lChild);
    }
    if(T->rChild != NULL){
        preOrder(T->rChild);
    }
}
void postOrder(Node* T){
    if(T->lChild != NULL){
        postOrder(T->lChild);
    }
    if(T->rChild != NULL){
        postOrder(T->rChild);
    }
    printf("%d ", T->value);
}
void createTree(Node* &T){
    int data;
    cin>>data;
    if(data != 0){
        T = create();
        T->value = data;
        createTree(T->lChild);
        createTree(T->rChild);
    }

}
int main()
{
    int num;
    scanf("%d", &num);
    int value;
    Node* node = NULL;  //¶ş²æÅÅĞòÊ÷
    Node* node2 = NULL;  //ÆÕÍ¨Ê÷
    for(int i=0;i < num; i++){
        scanf("%d", &value);
        node = Insert(node, value);
    }
    createTree(node2);
    //inOrder(node);
    printf("\n");
    //postOrder(node);
    preOrder(node2);
    printf("\n");
    inOrder(node2);
    printf("\n");
    postOrder(node2);
    return 0;
}
