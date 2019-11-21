#include <iostream>

using namespace std;

class BinaryTree;
class BinaryTreeNode{
    friend BinaryTree;
private:
    BinaryTreeNode *left;
    BinaryTreeNode *right;
    char data;
public:
    BinaryTreeNode(){
        left = NULL;
        right = NULL;
    }
    BinaryTreeNode(char data, BinaryTreeNode *l = NULL, BinaryTreeNode *r = NULL){
        left = l;
        right = r;
        data = data;
    }
};
class BinaryTree{
private:
    BinaryTreeNode *root;
    char endTag;
    char data;
    void createTree(BinaryTreeNode *&root);
    void output(BinaryTreeNode *root);
    int height(BinaryTreeNode *root);
    int leaf(BinaryTreeNode *root);
    int node(BinaryTreeNode *root);
    void preorder(BinaryTreeNode *root);
public:
    BinaryTree(){root = NULL;endTag = '#';}
    BinaryTree(char d){data = d; root = NULL;endTag = '#';}
    void createTree(){createTree(root);}
    void output(){output(root);}
    int height(){return height(root);}
    int leaf(){return leaf(root);}
    int node(){return node(root);}
    void preorder(){return preorder(root);}
};
void BinaryTree::createTree(BinaryTreeNode *&subTree){
    char data;
    cin>>data;
    if(data!=endTag){
        subTree = new BinaryTreeNode(data);
        createTree(subTree->left);
        createTree(subTree->right);
    }
}
void BinaryTree::output(BinaryTreeNode *subTree){
    cout<<subTree->data;
    if(subTree!=NULL){
        output(subTree->left);
        output(subTree->right);
    }
}
int BinaryTree::height(BinaryTreeNode *subTree){
    if(subTree==NULL){
        return 0;
    }else{
        return 1 + max(height(subTree->left),height(subTree->right));
    }
}
int BinaryTree::leaf(BinaryTreeNode *subTree){
    if(subTree!=NULL){
        if(subTree->left == NULL && subTree->right == NULL){
            return 1 + leaf(subTree->left) + leaf(subTree->right);
        }else{
            return leaf(subTree->left) + leaf(subTree->right);
        }
    }else{
        return 0;
    }
}
int BinaryTree::node(BinaryTreeNode *subTree){
    if(subTree==NULL){
        return 0;
    }else{
        return 1 + node(subTree->left) + node(subTree->right);
    }
}
void BinaryTree::preorder(BinaryTreeNode *subTree){
    if(subTree!=NULL){
        cout<<subTree->data;
        preorder(subTree->left);
        preorder(subTree->right);
    }
}
int main()
{
    BinaryTree bt;
    return 0;
}
