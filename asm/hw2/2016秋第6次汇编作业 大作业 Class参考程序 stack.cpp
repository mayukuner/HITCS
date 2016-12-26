// stack.cpp : Defines the entry point for the console application.
//
#include <stdio.h>
#include <conio.h>

class  Stack
{
	int  *a; int  len, top;
public: Stack(int n);  //��ʼ����ջ
		~Stack(); 			//������ջ�ռ�
		Stack(const Stack& t); 		//�������캯��
		void  push(int x);    			//��xѹ���ջ
		int  pop();     			//����ջԪ�ص�������
};

Stack::Stack(int n)
{
	a = new int[n];
	len = n;	top = 0;
}
Stack::~Stack()
{
	delete[]a;
}
Stack::Stack(const Stack& t)
{
	a = new int[t.len];
	len = t.len;
	top = t.top;
	for (int i = 0; i < len; i++)
		a[i] = t.a[i];
}
void Stack::push(int x)
{
	if (top == len)
	{
		printf("Stack is Full !\n");
		return;
	}
	a[top++] = x;
}
int Stack::pop()
{
	return a[--top];
}

int main(int argc, char * argv[])
{
	Stack s(100);
	int i;

	for (i = 1; i <= 100; i++)
		s.push(i);
	for (i = 1; i <= 100; i++)
		printf(" %d ", s.pop());

	getchar();
	return 0;
}