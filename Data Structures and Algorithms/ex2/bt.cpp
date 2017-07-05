#include<stdio.h>
#include<string.h>

#define N 100010
#define L 100010

struct Node {
  Node *lc, *rc;
  char *name;
  Node() : lc(NULL), rc(NULL) {
  }
};

void preDFS(Node *o) {
  // �������
  if (o == NULL)
    return;
  printf("%s\n", o->name);
  preDFS(o->lc);
  preDFS(o->rc);
}
void inoDFS(Node *o) {
  // �������
  if (o == NULL)
    return;
  inoDFS(o->lc);
  printf("%s\n", o->name);
  inoDFS(o->rc);
}
void sucDFS(Node *o) {
  // �������
  if (o == NULL)
    return;
  sucDFS(o->lc);
  sucDFS(o->rc);
  printf("%s\n", o->name);
}

Node *q[N];
int fr = 0, rr = 0;
void staBFS(Node *rt) {
  // �������
  fr = rr = 0;
  q[rr++] = rt;
  while (fr < rr) {
    Node *p = q[fr++];
    printf("%s\n", p->name);
    if (p->lc != NULL)
      q[rr++] = p->lc;
    if (p->rc != NULL)
      q[rr++] = p->rc;
  }
}

int tot = 0;
char n[L], P[L], D[10];
int main() {
  Node *rt;  // root
  while (true) {
    scanf("%s", n);
    if (strcmp(n, "-1") == 0)
      break;
    scanf("%s%s", P, D);
    Node *curNode = new Node();
    curNode->name = new char[strlen(n)+1];
    strcpy(curNode->name, n);
    if (strcmp(P, "-1") != 0) {
      while (strcmp(q[fr]->name, P) != 0)
        fr++;
      if (D[0] == 'L')
        q[fr]->lc = curNode;
      else
        q[fr]->rc = curNode;
    } else {
      rt = curNode;
    }
    q[rr++] = curNode;
  }

  printf("������������\n");
  preDFS(rt);

  printf("����������:\n");
  inoDFS(rt);

  printf("����������:\n");
  sucDFS(rt);

  printf("����������:\n");
  staBFS(rt);

  return 0;
}
