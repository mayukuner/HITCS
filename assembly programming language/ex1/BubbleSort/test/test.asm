INCLUDE  ASM32.INC

MAXN=1000

.DATA
		V	DWORD	MAXN	DUP(?)
		N	DWORD	?
.CODE
	MAIN	PROC
		LEA	EBX,V
		MOV	EDI,0
		MOV	ESI,0
		
		MOV	ECX,2000000000
	L3:	MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		MOV	EAX,[EBX+4]
		LOOP	L3

		MOV	ECX,2000000000
	L1:	MOV	EAX,V[edi*4+4]
		MOV	EAX,V[edi*4+4]
		MOV	EAX,V[edi*4+4]
		MOV	EAX,V[edi*4+4]
		MOV	EAX,V[edi*4+4]
		MOV	EAX,V[edi*4+4]
		MOV	EAX,V[edi*4+4]
		LOOP	L1

		MOV	ECX,2000000000
	L2:	MOV	EAX,[ebx+esi*4+4]
		MOV	EAX,[ebx+esi*4+4]
		MOV	EAX,[ebx+esi*4+4]
		MOV	EAX,[ebx+esi*4+4]
		MOV	EAX,[ebx+esi*4+4]
		MOV	EAX,[ebx+esi*4+4]
		MOV	EAX,[ebx+esi*4+4]
		LOOP	L2
		INVOKE	  ExitProcess,0 
	MAIN	ENDP											; ���� - �ӳ������

		END       MAIN									; END ָʾ���г��򵽴˽�������һ����ִ�����λ��Ϊmain
