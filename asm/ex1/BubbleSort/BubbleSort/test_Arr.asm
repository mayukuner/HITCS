INCLUDE  ASM32.INC

MAXN=1000

.DATA
		V	DWORD	MAXN	DUP(?)
		N	DWORD	?
.CODE
	MAIN	PROC
			MOV		ESI,0
			MOV		EBX,0
			MOV		EAX,V[ESI*4+4]
			MOV		EAX,V[ESI*4]
			MOV		EAX,V[4]
			LEA		EAX,V
			INVOKE	getchar
			INVOKE	ExitProcess,0 
	MAIN	ENDP											; ���� - �ӳ������

			END		MAIN									; END ָʾ���г��򵽴˽�������һ����ִ�����λ��Ϊmain

