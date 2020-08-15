;Código TASM

.MODEL small

.STACK 200h

.DATA
vara DW 1 DUP(0)
varf DW 1 DUP(0)
t1 DW 1 DUP(0)
t2 DW 1 DUP(0)
t3 DW 1 DUP(0)
;dataFinal

.CODE
	.STARUP
mov ax,@data
mov ds,ax
mov es,ax
mov ax,5
add ax,a
mov t1,ax
mov ax,t1
add ax,3
mov t2,ax
mov ax,t2
add ax,f
mov t3,ax
mov ax,t3
mov z,ax
;codeFinal

	.EXIT

END
