#include<stdio.h>
int main(int argc, char *argv[])
{
    for (int i = 0; i < argc; i++)
    {
        printf("��%0d������Ϊ��%s\n", i, argv[i]);
    }
    getchar();
    return argc++;
}