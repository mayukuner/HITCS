#include <stdio.h>
#include <conio.h>
#include <string.h>

// �ⲿ�������������
extern "C" int n;
extern "C" int qi(char *buf, int *pi, char chr);
extern "C" int qo(char *buf, int *po, char *chr);
extern "C" int qp(char *buf, int pi, int po);

extern "C" {
  /*
    ����Ϊ�ⲿ�ṩ�ı��������
   */
    void incp(int *p);
    int QUEUE_SIZE = 16;
}

void incp(int *p) {
    (*p)++;
    if (*p == QUEUE_SIZE)
        *p = 0;
}

char buf[16];
int po, pi;
int main() {
    printf("��ѡ��ESC         �˳���\n");
    printf("        -           �Ӷ�����ȡԪ����ʾ\n");
    printf("        +           ��ӡ��ǰ����\n");
    printf("        [0-9A-Z]    ��ӡ��ǰ����\n");
    printf("��������\n");
    while (true) {
        char chr = _getche();
        if (chr == '-') {
            char chr_out;
            int status = qo(buf, &po, &chr_out);
            if (status == 0) {
                printf("\n�����ѿ�\n");
            } else {
                printf("��ȡ��Ԫ��Ϊ:%c\n", chr_out);
            }
        } else if (chr == '+') {
            int status = qp(buf, pi, po);
        } else if (('0' <= chr && chr <= '9') || ('A' <= chr && chr <= 'Z')) {
            int status = qi(buf, &pi, chr);
            if (status == 0) {
                printf("\n��������\n");
            }
        } else if (chr == 27) {
            break;
        }
    }
    return 0;
}
